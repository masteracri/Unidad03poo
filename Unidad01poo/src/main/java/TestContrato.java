package unidad01poo;


import java.util.Scanner;

public class TestContrato {


    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        Contrato contrato = new Contrato();

        int opcion = 0;

        do {

            System.out.println("\n===== MENU CONTRATO =====");
            System.out.println("1. Capturar datos del contrato");
            System.out.println("2. Mostrar contrato");
            System.out.println("3. Mostrar subtotal");
            System.out.println("4. Mostrar impuesto");
            System.out.println("5. Mostrar total a pagar");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("\n===== CAPTURA DE CONTRATO =====");

                    System.out.print("Número de contrato: ");
                    contrato.setNumContrato(entrada.nextLine());

                    System.out.print("Nombre del empleado: ");
                    contrato.setNombre(entrada.nextLine());

                    System.out.println("\nNivel de estudios");
                    System.out.println("1. Licenciatura");
                    System.out.println("2. Maestría");
                    System.out.println("3. Doctorado");
                    System.out.print("Seleccione el nivel: ");
                    contrato.setNivel(entrada.nextInt());

                    System.out.print("Pago base: $");
                    contrato.setPagoBase(entrada.nextFloat());

                    System.out.print("Días trabajados: ");
                    contrato.setDiasTrabajados(entrada.nextInt());

                    break;

                case 2:

                    contrato.imprimirContrato();

                    break;

                case 3:

                    System.out.println("Subtotal: $" 
                            + contrato.calcularSubtotal());

                    break;

                case 4:

                    System.out.println("Impuesto: $" 
                            + contrato.calcularImpuesto());

                    break;

                case 5:

                    System.out.println("Total a pagar: $" 
                            + contrato.calcularTotal());

                    break;

                case 6:

                    System.out.println("Saliendo del programa...");

                    break;

                default:

                    System.out.println("Opción no válida.");

            }

        } while (opcion != 6);

        entrada.close();
    }
}