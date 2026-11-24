public class CuentaInversion extends CuentaBancaria {
    // Porcentaje sobre la ganancia: 10f representa 10 %.
    private float impuesto;
    private String fechaPago;

    public CuentaInversion(String numCuenta, String fechaApertura,
                           Cliente cliente, String banco, float saldo,
                           float impuesto, String fechaPago) {
        super(numCuenta, fechaApertura, cliente, banco, saldo);
        this.impuesto = impuesto;
        this.fechaPago = fechaPago;
    }

    @Override
    public float calcularGanancia(int plazo) {
        validarPlazo(plazo);
        // Ganancia bruta con interes simple anual del 30 %.
        return getSaldo() * CUENTAINVERSION * (plazo / 12f);
    }

    public float calcularImpuesto(int plazo) {
        return calcularGanancia(plazo) * (impuesto / 100f);
    }

    @Override
    public void imprimir(int plazo) {
        float ganancia = calcularGanancia(plazo);
        float retencion = calcularImpuesto(plazo);
        System.out.println("CUENTA DE INVERSION");
        super.imprimir(plazo);
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.printf("Ganancia bruta: $%.2f%n", ganancia);
        System.out.printf("Impuesto (%.2f%%): $%.2f%n", impuesto, retencion);
        System.out.printf("Ganancia neta: $%.2f%n", ganancia - retencion);
        System.out.printf("Saldo final: $%.2f%n",
                          getSaldo() + ganancia - retencion);
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
}