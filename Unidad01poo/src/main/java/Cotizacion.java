package unidad01poo;

public class Cotizacion {
 // atributos
    private String numCotizacion;
    private String descripcion;
    private float precio;
    private float porPagoini;
    private int plazos;

    // constructor por omision
    public Cotizacion() {
        numCotizacion = "";
        descripcion = "";
        precio = 0;
        porPagoini = 0;
        plazos = 0;
    }

    // constructor con parametros
    public Cotizacion(String numCotizacion, String descripcion,
                      float precio, float porPagoini, int plazos) {

        this.numCotizacion = numCotizacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.porPagoini = porPagoini;
        this.plazos = plazos;
    }

    // constructor copia
    public Cotizacion(Cotizacion cotizacion) {
        this.numCotizacion = cotizacion.numCotizacion;
        this.descripcion = cotizacion.descripcion;
        this.precio = cotizacion.precio;
        this.porPagoini = cotizacion.porPagoini;
        this.plazos = cotizacion.plazos;
    }

    // set/get de numero de cotizacion
    public void setNumCotizacion(String numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

    public String getNumCotizacion() {
        return numCotizacion;
    }

    // set/get de descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // set/get de precio
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    // set/get de porcentaje de pago inicial
    public void setPorPagoini(float porPagoini) {
        this.porPagoini = porPagoini;
    }

    public float getPorPagoini() {
        return porPagoini;
    }

    // set/get de plazos
    public void setPlazos(int plazos) {
        this.plazos = plazos;
    }

    public int getPlazos() {
        return plazos;
    }

    // calcular pago inicial
    public float calcularPagoInicial() {
        return precio * porPagoini / 100;
    }

    // calcular total a financiar
    public float calcularTotalFin() {
        return precio - calcularPagoInicial();
    }

    // calcular pago mensual
    public float calcularPagoMensual() {

        if (plazos > 0) {
            return calcularTotalFin() / plazos;
        } else {
            return 0;
        }
    }

    // imprimir cotizacion
    public void imprimirCotizacion() {

        System.out.println("COTIZACION");
        System.out.println("------------------------------");

        System.out.println("Num Cotizacion: " + numCotizacion);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Precio: $" + precio);
        System.out.println("Porcentaje pago inicial: " + porPagoini + "%");
        System.out.println("Plazo: " + plazos + " meses");

        System.out.println();

        System.out.println("Pago Inicial: $" + calcularPagoInicial());
        System.out.println("Total a Financiar: $" + calcularTotalFin());
        System.out.println("Pago Mensual: $" + calcularPagoMensual());

        System.out.println("------------------------------");
    }
}