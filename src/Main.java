import static java.lang.IO.*;

public class Main {

    public static void main(String[] args) {
        println("=== DARK SOULS RPG ===");

        ClassePersonagem[] classes = ClassePersonagem.values();
        println("Escolha sua classe:");
        for (int i = 0; i < classes.length; i++) {
            println((i + 1) + " - " + classes[i].getNome());
        }
        ClassePersonagem classe = classes[lerOpcao(1, classes.length) - 1];

        println("Seu nome:");
        String nome = readln();

        Personagem jogador = new Personagem(nome, classe, new FrascoDeEstus(5, 40));
        Firekeeper firekeeper = new Firekeeper("Anastasia");
        Jornada jornada = new Jornada();

        while (!jornada.terminou()) {
            Area area = jornada.getAreaAtual();
            Inimigo inimigo = jornada.proximoInimigo();

            println("--- " + area.getNome() + " ---");
            println(inimigo.getTipo().getNome() + " aparece!");

            lutar(jogador, inimigo);

            if (!jogador.estaVivo()) {
                println("YOU DIED");
                return;
            }

            TipoInimigo tipo = inimigo.getTipo();
            jogador.ganharAlmas(tipo.getAlmas());
            println(tipo.getNome() + " derrotado! +" + tipo.getAlmas() + " almas");
            if (tipo.isChefe()) {
                jogador.getInventario().adicionar("Fragmento de Estus", 1);
                println("Você encontrou um Fragmento de Estus!");
            }

            jornada.avancar();
            if (!jornada.terminou() && jornada.getAreaAtual() != area) {
                fogueira(jogador, firekeeper);
            }
        }

        println("VICTORY ACHIEVED! Você venceu o jogo!");
    }

    static void lutar(Personagem jogador, Inimigo inimigo) {
        while (inimigo.estaVivo() && jogador.estaVivo()) {
            println(jogador.getNome() + ": " + jogador.getVida() + " de vida | Estus: "
                    + jogador.getFrasco().getCargasAtuais() + " | "
                    + inimigo.getTipo().getNome() + ": " + inimigo.getVida());
            println("1 - Atacar");
            println("2 - Usar Estus");
            println("3 - Ver inventário");
            int opcao = lerOpcao(1, 3);

            if (opcao == 1) {
                inimigo.receberDano(jogador.atacar());
            } else if (opcao == 2) {
                if (jogador.getFrasco().getCargasAtuais() == 0) {
                    println("Sem cargas de Estus!");
                    continue;
                }
                jogador.usarEstus();
            } else {
                jogador.getInventario().mostrar();
                continue;
            }

            if (inimigo.estaVivo()) {
                jogador.receberDano(inimigo.atacar());
            }
        }
    }

    static void fogueira(Personagem jogador, Firekeeper firekeeper) {
        jogador.descansar();
        println("Você chegou a uma fogueira. " + firekeeper.getNome() + " acolhe você.");

        int opcao = 0;
        while (opcao != 4) {
            println("Almas: " + jogador.getAlmas() + " | Vida: " + jogador.getVida());
            println("1 - Melhorar cura do Estus");
            println("2 - Aumentar cargas do Estus");
            println("3 - Subir atributo");
            println("4 - Seguir em frente");
            opcao = lerOpcao(1, 4);

            if (opcao == 1) {
                if (firekeeper.melhorarCura(jogador)) {
                    println("Cura do Estus: " + jogador.getFrasco().getCura());
                } else {
                    println("Sem Fragmento de Estus ou nível máximo.");
                }
            } else if (opcao == 2) {
                if (firekeeper.melhorarCargas(jogador)) {
                    println("Cargas do Estus: " + jogador.getFrasco().getCargasMaximas());
                } else {
                    println("Sem Fragmento de Estus.");
                }
            } else if (opcao == 3) {
                subirAtributo(jogador);
            }
        }
    }

    static void subirAtributo(Personagem jogador) {
        TipoAtributo[] tipos = TipoAtributo.values();
        println("Custo: " + jogador.getAtributos().getNivel() * 100 + " almas");
        for (int i = 0; i < tipos.length; i++) {
            println((i + 1) + " - " + tipos[i] + " (" + jogador.getAtributos().get(tipos[i]) + ")");
        }
        TipoAtributo escolhido = tipos[lerOpcao(1, tipos.length) - 1];

        if (jogador.subirAtributo(escolhido)) {
            println(escolhido + " aumentou!");
        } else {
            println("Almas insuficientes.");
        }
    }

    static int lerOpcao(int min, int max) {
        while (true) {
            try {
                int valor = Integer.parseInt(readln());
                if (valor >= min && valor <= max) {
                    return valor;
                }
            } catch (NumberFormatException e) {

            }
            println("Opção inválida. Digite um número de " + min + " a " + max + ".");
        }
    }
}