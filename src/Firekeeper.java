public class Firekeeper {
    private final String nome;
    private static final int NIVEL_MAXIMO = 10;

    public Firekeeper(String nome) {
        this.nome = nome;
    }

    public boolean melhorarCura(Personagem jogador) {
        FrascoDeEstus frasco = jogador.getFrasco();
        if (frasco.getNivel() >= NIVEL_MAXIMO) {
            return false;
        }
        if (!jogador.getInventario().remover("Fragmento de Estus", 1)) {
            return false;
        }
        frasco.aumentarCura(10);
        return true;
    }

    public boolean melhorarCargas(Personagem jogador) {
        if (!jogador.getInventario().remover("Fragmento de Estus", 1)) {
            return false;
        }
        jogador.getFrasco().aumentarCargas(1);
        return true;
    }

    public String getNome() { return nome; }
}