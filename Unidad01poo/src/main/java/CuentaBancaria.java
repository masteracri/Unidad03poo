public abstract class CuentaBancaria implements Ganancia {
    private String numCuenta;
    private String fechaApertura;
    private Cliente cliente;
    private String banco;
    private float saldo;

    protected CuentaBancaria(String numCuenta, String fechaApertura,
                            Cliente cliente, String banco, float saldo) {
        this.numCuenta = numCuenta;
        this.fechaApertura = fechaApertura;
        this.cliente = cliente;
        this.banco = banco;
        this.saldo = saldo;
    }

    @Override
    public abstract float calcularGanancia(int plazo);

    @Override
    public void imprimir(int plazo) {
        validarPlazo(plazo);
        System.out.println("Banco: " + banco);
        System.out.println("Numero de cuenta: " + numCuenta);
        System.out.println("Fecha de apertura: " + fechaApertura);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("RFC: " + cliente.getRfc());
        System.out.println("Domicilio: " + cliente.getDomicilio());
        System.out.println("Regimen: " + cliente.getRegimenContribuyente());
        System.out.printf("Saldo: $%.2f%n", saldo);
        System.out.println("Plazo: " + plazo + " meses");
    }

    // Correccion del nombre "validadPlazo" que aparece en el diagrama.
    public void validarPlazo(int plazo) {
        if (plazo != 6 && plazo != 12 && plazo != 24 && plazo != 36) {
            throw new IllegalArgumentException(
                "El plazo debe ser de 6, 12, 24 o 36 meses."
            );
        }
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}