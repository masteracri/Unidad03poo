import java.util.Scanner;

public class TestNomProducto {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        NomProducto producto = new NomProducto();

        int opcion;

        do {
            System.out.println("\n--- MENÚ DE PRODUCTO ---");
            System.out.println("1. Capturar información");
            System.out.println("2. Imprimir producto");
            System.out.println("3. Mostrar costo de compra");
            System.out.println("4. Mostrar costo de venta");
            System.out.println("5. Calcular valor del inventario");
            System.out.println("6. Probar constructor de copia");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = in.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Código del producto: ");
                    producto.setCodigoProducto(in.nextInt());

                    in.nextLine(); // Consumir el salto de línea

                    System.out.print("Descripción: ");
                    producto.setDescripcion(in.nextLine());

                    System.out.print("Precio de compra: ");
                    producto.setPrecioCompra(in.nextInt());

                    System.out.print("Precio de venta: ");
                    producto.setPrecioVenta(in.nextInt());

                    System.out.print("Cantidad de productos: ");
                    producto.setCantidadProducto(in.nextInt());

                    System.out.println("Información guardada.");
                    break;

                case 2:
                    producto.imprimirProducto();
                    break;

                case 3:
                    System.out.println("Costo de compra: $"
                            + producto.calcularCostoCompra());
                    break;

                case 4:
                    System.out.println("Costo de venta: $"
                            + producto.calcularCostoVenta());
                    break;

                case 5:
                    System.out.println("Valor del inventario: $"
                            + producto.calcularInventario());
                    break;

                case 6:
                    NomProducto copia = new NomProducto(producto);
                    System.out.println("--- COPIA DEL PRODUCTO ---");
                    copia.imprimirProducto();
                    break;

                case 7:
                    System.out.println("Programa terminado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        in.close();
    }
}
