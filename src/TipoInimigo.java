public enum TipoInimigo {
    HOLLOW("Hollow", 50, 8, 10, false),
    HOLLOW_SOLDIER("Hollow Soldier", 80, 12, 25, false),
    HOLLOW_ARCHER("Hollow Archer", 60, 10, 25, false),
    BLACK_KNIGHT("Black Knight", 200, 30, 200, false),
    FIRE_BOMB_HOLLOW("Fire Bomb Hollow", 70, 15, 40, false),
    BALDER_KNIGHT("Balder Knight", 150, 22, 120, false),
    ASYLUM_DEMON("Asylum Demon", 500, 35, 1000, true),
    TAURUS_DEMON("Taurus Demon", 900, 50, 3000, true),
    BELL_GARGOYLE("Bell Gargoyle", 800, 45, 2000, true);

    private final String nome;
    private final int vidaMaxima;
    private final int dano;
    private final int almas;
    private final boolean chefe;

    TipoInimigo(String nome, int vidaMaxima, int dano, int almas, boolean chefe) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.dano = dano;
        this.almas = almas;
        this.chefe = chefe;
    }

    public String getNome() { return nome; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getDano() { return dano; }
    public int getAlmas() { return almas; }
    public boolean isChefe() { return chefe; }
}