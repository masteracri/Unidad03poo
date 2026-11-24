public interface Ganancia extends Imprimible {
    float CUENTAAHORRO = 0.10f;
    float CUENTAINVERSION = 0.30f;

    float calcularGanancia(int plazo);
}