public class Escudo extends Equipamento {
    private final double absorcaoFisica;
    private final int estabilidade;
    private final int reqForca;

    public Escudo(String nome, int peso, int durabilidade,
                  double absorcaoFisica, int estabilidade, int reqForca) {
        super(nome, peso, durabilidade);
        if (absorcaoFisica < 0 || absorcaoFisica > 1)
            throw new IllegalArgumentException("Absorção deve estar entre 0 e 1");
        this.absorcaoFisica = absorcaoFisica;
        this.estabilidade = estabilidade;
        this.reqForca = reqForca;
    }

    @Override
    public String descricao() {
        return getNome() + " | Absorção: " + (int) (absorcaoFisica * 100) + "% | Estab: " + estabilidade;
    }


}