import java.util.Scanner;

public class Testbomba {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Gasolina gas = new Gasolina();
        bomba bomba = new bomba();
        bomba.setGasolina(gas);
        int opcion = 0;

        do {
            System.out.println("\n1. Capturar informacion");
            System.out.println("2. Hacer una venta");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Mostrar venta total");
            System.out.println("5. Mostrar informacion bomba");
            System.out.println("6. Salir");
            opcion = in.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID de gasolina: ");
                    gas.setIdGasolina(in.nextInt());
                    in.nextLine();
                    System.out.print("Tipo de gasolina: ");
                    gas.setTipo(in.nextLine());
                    System.out.print("Precio por litro: ");
                    gas.setPrecio(in.nextFloat());

                    System.out.print("ID de bomba: ");
                    bomba.setIdBomba(in.nextInt());
                    System.out.print("Capacidad de la bomba: ");
                    bomba.setCapacidad(in.nextFloat());
                    bomba.setConLitros(0f);
                    break;

                case 2: {
                    System.out.print("Cuantos litros deseas: ");
                    float cantidad = in.nextFloat();
                    float costoVenta = 0;

                    if (cantidad <= 0 || !Float.isFinite(cantidad)) {
                        System.out.println("Cantidad incorrecta.");
                        break;
                    }

                    if (cantidad <= bomba.obtenerInventario()) {
                        costoVenta = cantidad * gas.getPrecio();
                    }

                    if (costoVenta == 0) {
                        System.out.println(
                                "No hay suficiente gasolina o falta capturar el precio.");
                    } else {
                        System.out.println("El costo es: $" + costoVenta);
                        bomba.setConLitros(bomba.getConLitros() + cantidad);
                    }
                    break;
                }

                case 3:
                    System.out.println("Inventario: "
                            + bomba.obtenerInventario() + " litros");
                    break;

                case 4:
                    System.out.println("Venta total: $" + bomba.ventaTotal());
                    break;

                case 5:
                    System.out.println("ID bomba: " + bomba.getIdBomba());
                    System.out.println("Tipo de gasolina: " + gas.getTipo());
                    System.out.println("Precio por litro: $" + gas.getPrecio());
                    System.out.println("Capacidad: " + bomba.getCapacidad());
                    System.out.println("Litros vendidos: " + bomba.getConLitros());
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opcion != 6);

        in.close();
    }
}