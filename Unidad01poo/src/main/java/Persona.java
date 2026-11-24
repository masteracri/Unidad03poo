package unidad01poo;

public class Persona {

    protected String nombre;
    protected int edad;
    protected String sexo;
    protected int edoCivil;

    public Persona(String nombre, int edad, String sexo, int edoCivil) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.edoCivil = edoCivil;
    }
}