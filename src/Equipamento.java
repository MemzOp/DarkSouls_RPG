public abstract class Equipamento {
    private String nome;
    private int peso;
    private int durabilidade;

    public Equipamento(String nome, int peso, int durabilidade) {
        this.nome = nome;
        this.peso = peso;
        this.durabilidade = durabilidade;
    }

    public String getNome() {
        return nome;
    }

    public int getPeso() {
        return peso;
    }

    public void desgastar(int valor) {
        durabilidade = durabilidade - valor;
        if (durabilidade < 0) {
            durabilidade = 0;
        }
    }

    public boolean estaQuebrado() {
        return durabilidade == 0;
    }

    public abstract String descricao();
}