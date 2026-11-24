public class NomProducto {

    private int codigoProducto;
    private String descripcion;
    private int precioCompra;
    private int precioVenta;
    private int cantidadProducto;

    
    public NomProducto() {
    }

    
    public NomProducto(int codigoProducto, String descripcion,
                       int precioCompra, int precioVenta,
                       int cantidadProducto) {

        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidadProducto = cantidadProducto;
    }

    
    public NomProducto(NomProducto producto) {
        this.codigoProducto = producto.codigoProducto;
        this.descripcion = producto.descripcion;
        this.precioCompra = producto.precioCompra;
        this.precioVenta = producto.precioVenta;
        this.cantidadProducto = producto.cantidadProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public float calcularCostoCompra() {
        return precioCompra;
    }

    public float calcularCostoVenta() {
        return precioVenta;
    }

    public float calcularInventario() {
        return (float) precioCompra * cantidadProducto;
    }

    public void imprimirProducto() {
        System.out.println("Código: " + codigoProducto);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio de compra: $" + precioCompra);
        System.out.println("Precio de venta: $" + precioVenta);
        System.out.println("Cantidad: " + cantidadProducto);
        System.out.println("Valor del inventario: $"
                + calcularInventario());
    }
}
