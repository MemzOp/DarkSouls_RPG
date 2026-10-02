public enum Area {
    ASILO("Asilo dos Mortos",
            new TipoInimigo[]{TipoInimigo.HOLLOW, TipoInimigo.HOLLOW,
                    TipoInimigo.ASYLUM_DEMON}),
    BURGO("Burgo dos Mortos",
            new TipoInimigo[]{TipoInimigo.HOLLOW, TipoInimigo.HOLLOW_SOLDIER,
                    TipoInimigo.HOLLOW_ARCHER, TipoInimigo.FIRE_BOMB_HOLLOW,
                    TipoInimigo.BALDER_KNIGHT, TipoInimigo.TAURUS_DEMON}),
    PAROQUIA("Paróquia dos Mortos",
            new TipoInimigo[]{TipoInimigo.HOLLOW_SOLDIER, TipoInimigo.BLACK_KNIGHT,
                    TipoInimigo.BELL_GARGOYLE});

    private final String nome;
    private final TipoInimigo[] inimigos;

    Area(String nome, TipoInimigo[] inimigos) {
        this.nome = nome;
        this.inimigos = inimigos;
    }

    public TipoInimigo getInimigo(int posicao) {
        return inimigos[posicao];
    }

    public int getTotalInimigos() {
        return inimigos.length;
    }

    public String getNome() { return nome; }
}