package enums;

public enum Pontos {
    ACERTA_PRIMEIRA(5),
    ACERTA_PASSA(7),
    ACERTA_REPASSA(10),
    ERRA_PRIMEIRA(-5),
    ERRA_PASSA(-5),
    ERRA_REPASSA(-3),
    ;

    private final int pontos;

    Pontos(int pontos) {
        this.pontos = pontos;
    }

    public int getPontos() {
        return pontos;
    }
}
