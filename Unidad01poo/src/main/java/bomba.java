public class bomba {

    private int idBomba;
    private float conLitros;
    private Gasolina gasolina;
    private float capacidad;

    public bomba() {
    }

    public bomba(int idBomba, float conLitros,
            Gasolina gasolina, float capacidad) {
        this.idBomba = idBomba;
        this.conLitros = conLitros;
        this.gasolina = gasolina;
        this.capacidad = capacidad;
    }

    public int getIdBomba() {
        return idBomba;
    }

    public void setIdBomba(int idBomba) {
        this.idBomba = idBomba;
    }

    public float getConLitros() {
        return conLitros;
    }

    public void setConLitros(float conLitros) {
        this.conLitros = conLitros;
    }

    public Gasolina getGasolina() {
        return gasolina;
    }

    public void setGasolina(Gasolina gasolina) {
        this.gasolina = gasolina;
    }

    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }

    public float obtenerInventario() {
        return capacidad - conLitros;
    }

    public void venderGasolina(float litros) {
        if (!Float.isFinite(litros) || litros <= 0) {
            throw new IllegalArgumentException(
                    "Los litros deben ser positivos.");
        }

        if (litros > obtenerInventario()) {
            throw new IllegalArgumentException(
                    "No hay suficiente gasolina.");
        }

        conLitros += litros;
    }

    public float ventaTotal() {
        if (gasolina == null) {
            throw new IllegalStateException(
                    "Asigna una gasolina a la bomba.");
        }

        return conLitros * gasolina.getPrecio();
    }
}