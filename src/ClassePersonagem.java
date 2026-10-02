public enum ClassePersonagem {
    WARRIOR("Guerreiro",   11, 11, 13, 13,  9,  9, "Longsword",     "Standard Helm",   "Heater Shield"),
    KNIGHT("Cavaleiro",    10, 14, 11, 11,  9, 11, "Broadsword",    "Knight Set",      "Tower Kite Shield"),
    WANDERER("Andarilho",  12, 10, 10, 14, 11,  8, "Scimitar",      "Wanderer Set",    "Leather Shield"),
    THIEF("Ladrão",        10,  9,  9, 15, 12, 11, "Bandit's Knife","Thief Set",       "Target Shield"),
    BANDIT("Bandido",      11, 12, 14,  9,  8, 10, "Battle Axe",    "Brigand Set",     "Spider Shield"),
    HUNTER("Caçador",      11, 11, 12, 14,  9,  9, "Shortsword",    "Hunter Set",      "Large Leather Shield"),
    SORCERER("Feiticeiro",  8,  8,  9, 11, 15,  8, "Dagger",        "Sorcerer Set",    "Nenhum"),
    PYROMANCER("Piromante",12, 10, 12,  9, 10,  8, "Hand Axe",      "Tattered Cloth Set","Cracked Round Shield"),
    CLERIC("Clérigo",      11, 11, 12,  8,  8, 14, "Mace",          "Holy Robe Set",   "East-West Shield"),
    DEPRIVED("Desprovido", 11, 11, 11, 11, 11, 11, "Club",          "Nenhum",          "Plank Shield");

    private final String nome;
    private final int resistencia, vitalidade, forca, destreza, inteligencia, fe;
    private final String armaInicial, armaduraInicial, escudoInicial;

    ClassePersonagem(String nome, int resistencia, int vitalidade, int forca, int destreza,
                     int inteligencia, int fe,
                     String armaInicial, String armaduraInicial, String escudoInicial) {
        this.nome = nome;
        this.resistencia = resistencia;
        this.vitalidade = vitalidade;
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.fe = fe;
        this.armaInicial = armaInicial;
        this.armaduraInicial = armaduraInicial;
        this.escudoInicial = escudoInicial;
    }

    public String getNome()            { return nome; }
    public int getResistencia()        { return resistencia; }
    public int getVitalidade()         { return vitalidade; }
    public int getForca()              { return forca; }
    public int getDestreza()           { return destreza; }
    public int getInteligencia()       { return inteligencia; }
    public int getFe()                 { return fe; }
    public String getArmaInicial()     { return armaInicial; }
    public String getArmaduraInicial() { return armaduraInicial; }
    public String getEscudoInicial()   { return escudoInicial; }

    public Atributos criarAtributos() {
        return new Atributos(resistencia, vitalidade, forca, destreza, inteligencia, fe);
    }
}