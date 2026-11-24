public class CuentaAhorro extends CuentaBancaria {
    private float saldoPromedio;
    private int diaCorte;

    public CuentaAhorro(String numCuenta, String fechaApertura,
                        Cliente cliente, String banco, float saldo,
                        float saldoPromedio, int diaCorte) {
        super(numCuenta, fechaApertura, cliente, banco, saldo);
        this.saldoPromedio = saldoPromedio;
        this.diaCorte = diaCorte;
    }

    @Override
    public float calcularGanancia(int plazo) {
        validarPlazo(plazo);
        // Interes simple: tasa anual del 10 %, plazo en meses.
        return saldoPromedio * CUENTAAHORRO * (plazo / 12f);
    }

    @Override
    public void imprimir(int plazo) {
        float ganancia = calcularGanancia(plazo);
        System.out.println("CUENTA DE AHORRO");
        super.imprimir(plazo);
        System.out.printf("Saldo promedio: $%.2f%n", saldoPromedio);
        System.out.println("Dia de corte: " + diaCorte);
        System.out.printf("Ganancia: $%.2f%n", ganancia);
        System.out.printf("Saldo final: $%.2f%n", getSaldo() + ganancia);
    }

    public float getSaldoPromedio() {
        return saldoPromedio;
    }

    public void setSaldoPromedio(float saldoPromedio) {
        this.saldoPromedio = saldoPromedio;
    }

    public int getDiaCorte() {
        return diaCorte;
    }

    public void setDiaCorte(int diaCorte) {
        this.diaCorte = diaCorte;
    }
}