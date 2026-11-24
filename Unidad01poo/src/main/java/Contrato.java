package unidad01poo;
public class Contrato {

 // atributos
    private String numContrato;
    private String nombre;
    private int nivel;
    private float pagoBase;
    private int diasTrabajados;
    private int IMPUESTO = 16;

    // constructor vacío
    public Contrato() {
    }

    // constructor con parámetros
    public Contrato(String numContrato, String nombre, int nivel,
                    float pagoBase, int diasTrabajados) {

        this.numContrato = numContrato;
        this.nombre = nombre;
        this.nivel = nivel;
        this.pagoBase = pagoBase;
        this.diasTrabajados = diasTrabajados;
    }

    // constructor copia
    public Contrato(Contrato contrato) {
        this.numContrato = contrato.numContrato;
        this.nombre = contrato.nombre;
        this.nivel = contrato.nivel;
        this.pagoBase = contrato.pagoBase;
        this.diasTrabajados = contrato.diasTrabajados;
    }

    // set/get
    public void setNumContrato(String numContrato) {
        this.numContrato = numContrato;
    }

    public String getNumContrato() {
        return numContrato;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setPagoBase(float pagoBase) {
        this.pagoBase = pagoBase;
    }

    public float getPagoBase() {
        return pagoBase;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public float calcularSubtotal() {

        float incremento = 0;

        if (nivel == 1) {
            incremento = 0.30f;
        } else if (nivel == 2) {
            incremento = 0.50f;
        } else if (nivel == 3) {
            incremento = 1.00f;
        }

        return pagoBase * (1 + incremento) * diasTrabajados;
    }

    // calcular impuesto
    public float calcularImpuesto() {
        return calcularSubtotal() * IMPUESTO / 100;
    }

    // calcular total
    public float calcularTotal() {
        return calcularSubtotal() - calcularImpuesto();
    }

    // imprimir contrato
    public void imprimirContrato() {

        System.out.println("========== CONTRATO ==========");
        System.out.println("Número de contrato: " + numContrato);
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Nivel de estudios: " + nivel);
        System.out.println("Pago base: $" + pagoBase);
        System.out.println("Días trabajados: " + diasTrabajados);
        System.out.println("------------------------------");
        System.out.println("Subtotal: $" + calcularSubtotal());
        System.out.println("Impuesto: $" + calcularImpuesto());
        System.out.println("Total a pagar: $" + calcularTotal());
        System.out.println("==============================");
    }
}