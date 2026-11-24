package unidad01poo;

import java.util.Scanner;

public class TestAlumno {

    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

            System.out.println("--- REGISTRO DE ALUMNO ---");

            System.out.print("Nombre: ");
            String nombre = entrada.nextLine();

            int edad = leerEntero(entrada, "Edad: ");

            System.out.print("Sexo: ");
            String sexo = entrada.nextLine();

            int edoCivil = leerEntero(
                entrada, "Estado civil (código numérico): "
            );

            System.out.print("Matrícula: ");
            String matricula = entrada.nextLine();

            System.out.print("Carrera: ");
            String carrera = entrada.nextLine();

            System.out.print("Turno: ");
            String turno = entrada.nextLine();

            Alumno alumno = new Alumno(
                nombre, edad, sexo, edoCivil,
                matricula, carrera, turno
            );

            alumno.imprimir();
        }
    }

    private static int leerEntero(Scanner entrada, String mensaje) {
        while (true) {
            System.out.print(mensaje);

            try {
                return Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException error) {
                System.out.println("Debes escribir un número entero.");
            }
        }
    }
}