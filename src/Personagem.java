public class Personagem {
    private final String nome;
    private final ClassePersonagem classe;
    private final Atributos atributos;
    private final Inventario inventario = new Inventario();
    private final FrascoDeEstus frasco;
    private int vida;
    private int almas;

    public Personagem(String nome, ClassePersonagem classe, FrascoDeEstus frasco) {
        this.nome = nome;
        this.classe = classe;
        this.atributos = classe.criarAtributos();
        this.frasco = frasco;
        this.vida = getVidaMaxima();

        equiparInicial(classe.getArmaInicial());
        equiparInicial(classe.getArmaduraInicial());
        equiparInicial(classe.getEscudoInicial());
    }

    private void equiparInicial(String item) {
        if (!item.equals("Nenhum")) {
            inventario.adicionar(item, 1);
        }
    }

    public int getVidaMaxima() {
        return 100 + atributos.get(TipoAtributo.VITALIDADE) * 10;
    }

    public int atacar() {
        return 5 + atributos.get(TipoAtributo.FORCA) * 2;
    }

    public void receberDano(int dano) {
        vida = Math.max(vida - dano, 0);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void usarEstus() {
        vida = Math.min(vida + frasco.beber(), getVidaMaxima());
    }

    public void descansar() {
        vida = getVidaMaxima();
        frasco.reabastecer();
    }

    public boolean subirAtributo(TipoAtributo tipo) {
        int custo = atributos.getNivel() * 100;
        if (almas < custo) {
            return false;
        }
        almas -= custo;
        atributos.subir(tipo);
        return true;
    }

    public void ganharAlmas(int quantidade) { almas += quantidade; }

    public String getNome() { return nome; }
    public ClassePersonagem getClasse() { return classe; }
    public Atributos getAtributos() { return atributos; }
    public Inventario getInventario() { return inventario; }
    public FrascoDeEstus getFrasco() { return frasco; }
    public int getVida() { return vida; }
    public int getAlmas() { return almas; }
}