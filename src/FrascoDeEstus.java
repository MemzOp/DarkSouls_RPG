public class FrascoDeEstus {
    private int nivel;
    private int cargasMaximas;
    private int cargasAtuais;
    private int cura;

    public FrascoDeEstus(int cargasMaximas, int cura) {
        this.nivel = 0;
        this.cargasMaximas = cargasMaximas;
        this.cargasAtuais = cargasMaximas;
        this.cura = cura;
    }

    public int beber() {
        if (cargasAtuais == 0) {
            return 0;
        }
        cargasAtuais--;
        return cura;
    }

    public void reabastecer() {
        cargasAtuais = cargasMaximas;
    }

    public void aumentarCura(int valor) {
        cura += valor;
        nivel++;
    }

    public void aumentarCargas(int quantidade) {
        cargasMaximas += quantidade;
        cargasAtuais += quantidade;
    }

    public int getNivel() { return nivel; }
    public int getCura() { return cura; }
    public int getCargasAtuais() { return cargasAtuais; }
    public int getCargasMaximas() { return cargasMaximas; }
}