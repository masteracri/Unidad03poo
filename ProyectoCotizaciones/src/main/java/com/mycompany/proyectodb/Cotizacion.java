package com.mycompany.proyectodb;
import java.sql.Date;
public class Cotizacion {
    private int idCotizacion;
    private String numCotizacion;
    private String descripcion;
    private float porcentaje;
    private float precio;
    private int plazos;
    private Date fecha;
    private int status;
    public Cotizacion() { this(0,"","",0,0,12,null,0); }
    public Cotizacion(int idCotizacion, String numCotizacion, String descripcion, float porcentaje, float precio, int plazos, Date fecha, int status) {
        this.idCotizacion = idCotizacion;
        this.numCotizacion = numCotizacion;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
        this.precio = precio;
        this.plazos = plazos;
        this.fecha = fecha;
        this.status = status;
    }
    public int getIdCotizacion() { return idCotizacion; }
    public void setIdCotizacion(int idCotizacion) { this.idCotizacion = idCotizacion; }
    public String getNumCotizacion() { return numCotizacion; }
    public void setNumCotizacion(String numCotizacion) { this.numCotizacion = numCotizacion; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public float getPorcentaje() { return porcentaje; }
    public void setPorcentaje(float porcentaje) { this.porcentaje = porcentaje; }
    public float getPrecio() { return precio; }
    public void setPrecio(float precio) { this.precio = precio; }
    public int getPlazos() { return plazos; }
    public void setPlazos(int plazos) { this.plazos = plazos; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public float calcularPagoInicial() { return precio * porcentaje / 100; }
    public float calcularTotalFin() { return precio - calcularPagoInicial(); }
    public float calcularPagoMensual() { return plazos > 0 ? calcularTotalFin()/plazos : 0; }
}
