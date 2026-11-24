public class Cliente {
    private String rfc;
    private String nombre;
    private String domicilio;
    private String regimenContribuyente;

    public Cliente(String rfc, String nombre, String domicilio,
                   String regimenContribuyente) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.regimenContribuyente = regimenContribuyente;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getRegimenContribuyente() {
        return regimenContribuyente;
    }

    public void setRegimenContribuyente(String regimenContribuyente) {
        this.regimenContribuyente = regimenContribuyente;
    }
}