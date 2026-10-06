public class Armadura extends Equipamento {
    private TipoPeca tipoPeca;
    private int defesaFisica;
    private int defesaMagica;

    public Armadura(String nome, int peso, int durabilidade,
                    TipoPeca tipoPeca, int defesaFisica, int defesaMagica) {
        super(nome, peso, durabilidade);
        this.tipoPeca = tipoPeca;
        this.defesaFisica = defesaFisica;
        this.defesaMagica = defesaMagica;
    }

    public TipoPeca getTipoPeca() {
        return tipoPeca;
    }

    public int getDefesaFisica() {
        return defesaFisica;
    }

    public int getDefesaMagica() {
        return defesaMagica;
    }

    @Override
    public String descricao() {
        return getNome() + " [" + tipoPeca + "] | Def: " + defesaFisica + " | Mag: " + defesaMagica;
    }
}