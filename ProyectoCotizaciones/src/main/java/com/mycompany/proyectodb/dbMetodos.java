package com.mycompany.proyectodb;
import java.sql.ResultSet;
public interface dbMetodos {
    boolean abrir();
    boolean cerrar();
    int insertar(Object obj);
    int actualizar(Object obj);
    int habilitar(int id);
    int deshabilitar(int id);
    Object buscarId(int id);
    ResultSet buscarActivos();
    ResultSet buscarNoActivos();
    int borrar(int id);
    Object buscar(String num);
}
