package unidad01poo;
 import java.util.Scanner;
public class TestCotizacion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Cotizacion cotizacion = new Cotizacion();

        int opcion = 0;

        do {

            System.out.println();
            System.out.println("1. Capturar informacion");
            System.out.println("2. Imprimir cotizacion");
            System.out.println("3. Imprimir pago inicial");
            System.out.println("4. Imprimir total a financiar");
            System.out.println("5. Imprimir pago mensual");
            System.out.println("6. Salir");
            System.out.println("Dame la opcion 1-6");

            opcion = in.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Dame el numero de cotizacion");
                    cotizacion.setNumCotizacion(in.next());

                    in.nextLine();

                    System.out.println("Dame la descripcion del automovil");
                    cotizacion.setDescripcion(in.nextLine());

                    System.out.println("Dame el precio del automovil");
                    cotizacion.setPrecio(in.nextFloat());

                    System.out.println("Dame el porcentaje de pago inicial");
                    cotizacion.setPorPagoini(in.nextFloat());

                    System.out.println("Dame el plazo en meses");
                    cotizacion.setPlazos(in.nextInt());

                    break;

                case 2:
                    cotizacion.imprimirCotizacion();
                    break;

                case 3:
                    System.out.println("Pago Inicial: $"
                            + cotizacion.calcularPagoInicial());
                    break;

                case 4:
                    System.out.println("Total a Financiar: $"
                            + cotizacion.calcularTotalFin());
                    break;

                case 5:
                    System.out.println("Pago Mensual: $"
                            + cotizacion.calcularPagoMensual());
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        } while (opcion != 6);

    }
}

