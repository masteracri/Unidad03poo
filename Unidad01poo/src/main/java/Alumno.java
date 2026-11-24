package unidad01poo;

public class Alumno extends Persona {

    private String matricula;
    private String carrera;
    private String turno;

    public Alumno(String nombre, int edad, String sexo, int edoCivil,
                  String matricula, String carrera, String turno) {

        super(nombre, edad, sexo, edoCivil);

        this.matricula = matricula;
        this.carrera = carrera;
        this.turno = turno;
    }

    public void imprimir() {
        System.out.println("\n--- DATOS DEL ALUMNO ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Sexo: " + sexo);
        System.out.println("Estado civil: " + edoCivil);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Carrera: " + carrera);
        System.out.println("Turno: " + turno);
    }
}