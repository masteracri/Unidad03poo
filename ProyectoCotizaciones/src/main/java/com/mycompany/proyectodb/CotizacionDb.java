package com.mycompany.proyectodb;
import java.sql.*;
import javax.sql.rowset.*;
public class CotizacionDb implements dbMetodos {
private final String MYSQLURL = System.getenv().getOrDefault("COT_DB_URL", "jdbc:mysql://127.0.0.1:3306/sistemas");
private final String usuario = System.getenv().getOrDefault("COT_DB_USER", "cotizaciones");
private final String password = System.getenv().getOrDefault("COT_DB_PASSWORD", "");
    private Connection conexion;
    private String error = "";
    public String getError() { return error; }
    public boolean abrir() {
        try { if (conexion == null || conexion.isClosed()) conexion = DriverManager.getConnection(MYSQLURL, usuario, password); return true; }
        catch(SQLException e) { error=e.getMessage(); return false; }
    }
    public boolean cerrar() {
        try { if(conexion != null) conexion.close(); return true; }
        catch(SQLException e) { error=e.getMessage(); return false; }
    }
    private Connection conectar() throws SQLException { if(!abrir()) throw new SQLException(error); return conexion; }
    private void datos(PreparedStatement p, Cotizacion c) throws SQLException {
        p.setString(1,c.getNumCotizacion()); p.setString(2,c.getDescripcion()); p.setFloat(3,c.getPrecio()); p.setFloat(4,c.getPorcentaje()); p.setInt(5,c.getPlazos()); p.setDate(6,c.getFecha()); p.setInt(7,c.getStatus());
    }
    public int insertar(Object obj) {
        Cotizacion c=(Cotizacion)obj;
        try(Connection cn=conectar(); PreparedStatement p=cn.prepareStatement("INSERT INTO Cotizacion(numCotizacion,descripcion,precio,porcentaje,plazos,fecha,status) VALUES(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS)) {
            datos(p,c); p.executeUpdate(); try(ResultSet r=p.getGeneratedKeys()) { if(r.next()) { c.setIdCotizacion(r.getInt(1)); return c.getIdCotizacion(); } } return 0;
        } catch(SQLException e) { error=e.getMessage(); return -1; }
    }
    public int actualizar(Object obj) {
        Cotizacion c=(Cotizacion)obj;
        try(Connection cn=conectar(); PreparedStatement p=cn.prepareStatement("UPDATE Cotizacion SET numCotizacion=?,descripcion=?,precio=?,porcentaje=?,plazos=?,fecha=?,status=? WHERE idCotizacion=?")) { datos(p,c); p.setInt(8,c.getIdCotizacion()); return p.executeUpdate(); }
        catch(SQLException e) { error=e.getMessage(); return -1; }
    }
    private int ejecutar(String sql,int... valores) {
        try(Connection cn=conectar(); PreparedStatement p=cn.prepareStatement(sql)) { for(int i=0;i<valores.length;i++) p.setInt(i+1,valores[i]); return p.executeUpdate(); }
        catch(SQLException e) { error=e.getMessage(); return -1; }
    }
    public int habilitar(int id) { return ejecutar("UPDATE Cotizacion SET status=? WHERE idCotizacion=?",0,id); }
    public int deshabilitar(int id) { return ejecutar("UPDATE Cotizacion SET status=? WHERE idCotizacion=?",1,id); }
    public int borrar(int id) { return ejecutar("DELETE FROM Cotizacion WHERE idCotizacion=?",id); }
    private ResultSet consultar(String sql,Object valor) {
        error="";
        try(Connection cn=conectar(); PreparedStatement p=cn.prepareStatement(sql)) { p.setObject(1,valor); try(ResultSet r=p.executeQuery()) { CachedRowSet filas=RowSetProvider.newFactory().createCachedRowSet(); filas.populate(r); return filas; } }
        catch(SQLException e) { error=e.getMessage(); return null; }
    }
    public static Cotizacion leer(ResultSet r) throws SQLException { return new Cotizacion(r.getInt("idCotizacion"),r.getString("numCotizacion"),r.getString("descripcion"),r.getFloat("porcentaje"),r.getFloat("precio"),r.getInt("plazos"),r.getDate("fecha"),r.getInt("status")); }
    private Cotizacion uno(String sql,Object valor) { try(ResultSet r=consultar(sql,valor)) { return r!=null && r.next()?leer(r):null; } catch(SQLException e) { error=e.getMessage(); return null; } }
    public Object buscarId(int id) { return uno("SELECT * FROM Cotizacion WHERE idCotizacion=?",id); }
    public Object buscar(String num) { return uno("SELECT * FROM Cotizacion WHERE numCotizacion=?",num); }
    public ResultSet buscarActivos() { return consultar("SELECT * FROM Cotizacion WHERE status=? ORDER BY idCotizacion",0); }
    public ResultSet buscarNoActivos() { return consultar("SELECT * FROM Cotizacion WHERE status=? ORDER BY idCotizacion",1); }
}
