public class Inimigo {
    private final TipoInimigo tipo;
    private int vida;

    public Inimigo(TipoInimigo tipo) {
        this.tipo = tipo;
        this.vida = tipo.getVidaMaxima();
    }

    public void receberDano(int dano) {
        vida = Math.max(vida - dano, 0);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public int atacar() {
        return tipo.getDano();
    }

    public int getVida() { return vida; }
    public TipoInimigo getTipo() { return tipo; }
}