public class Test {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(
            "RFC_EJEMPLO",
            "Juan Perez",
            "Mazatlan, Sinaloa",
            "Persona fisica"
        );

        CuentaAhorro ahorro = new CuentaAhorro(
            "AH001", "28/10/2026", cliente, "Finanzas Seguras",
            10000f, 10000f, 15
        );

        CuentaInversion inversion = new CuentaInversion(
            "IN001", "28/10/2026", cliente, "Finanzas Seguras",
            20000f, 10f, "28/10/2027"
        );

        int plazo = 12;

        ahorro.imprimir(plazo);
        System.out.println();
        inversion.imprimir(plazo);
    }
}