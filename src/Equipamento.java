public abstract class Equipamento {
    private String nome;
    private int peso;
    private int durabilidade;

    public Equipamento(String nome, int peso, int durabilidade) {
        if (peso < 0) throw new IllegalArgumentException("Peso Invalido");
        this.nome = nome;
        this.peso = peso;
        this.durabilidade = durabilidade;
    }

    public int getPeso() {
        return peso;
    }

    public String getNome() {
        return nome;
    }

    public void desgastar(int valor) {                 // encapsulamento: regra dentro da classe
        durabilidade = Math.max(0, durabilidade - valor);
    }
    public boolean estaQuebrado() { return durabilidade == 0; }

    public abstract String descricao();
}
