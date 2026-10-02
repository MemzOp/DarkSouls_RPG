public class Armas extends Equipamento{
    private final int danoBase;
    private final int reqForca;
    private final int reqDestreza;

    protected Armas(String nome, int peso, int durabilidade,
                int danoBase, int reqForca, int reqDestreza) {
        super(nome, peso, durabilidade);
        this.danoBase = danoBase;
        this.reqForca = reqForca;
        this.reqDestreza = reqDestreza;

    }

    @Override
    public String descricao() {
        return getNome() + " | Dano: " + danoBase + " | Req: FOR " + reqForca + " DES " + reqDestreza;
    }
}