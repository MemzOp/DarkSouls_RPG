public class Armadura extends Equipamento {
    private final TipoPeca tipoPeca;
    private final int defesaFisica;
    private final int defesaMagica;

    public Armadura(String nome, int peso, int durabilidade,
                    TipoPeca tipoPeca, int defesaFisica, int defesaMagica) {
        super(nome, peso, durabilidade);
        if (defesaFisica < 0 || defesaMagica < 0)
            throw new IllegalArgumentException("Defesa inválida");
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