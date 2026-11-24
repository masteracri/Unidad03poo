public class Gasolina {

    private int idGasolina;
    private String tipo;
    private float precio;

    public Gasolina() {
    }

    public Gasolina(int idGasolina, String tipo, float precio) {
        this.idGasolina = idGasolina;
        this.tipo = tipo;
        this.precio = precio;
    }

    public int getIdGasolina() {
        return idGasolina;
    }

    public void setIdGasolina(int idGasolina) {
        this.idGasolina = idGasolina;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}