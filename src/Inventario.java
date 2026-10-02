import static java.lang.IO.*;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private final Map<String, Integer> itens = new HashMap<>();

    public void adicionar(String item, int quantidade) {
        itens.put(item, quantidade(item) + quantidade);
    }

    public boolean remover(String item, int quantidade) {
        int atual = quantidade(item);
        if (atual < quantidade) {
            return false;
        }
        if (atual == quantidade) {
            itens.remove(item);
        } else {
            itens.put(item, atual - quantidade);
        }
        return true;
    }

    public int quantidade(String item) {
        return itens.getOrDefault(item, 0);
    }

    public boolean possui(String item) {
        return quantidade(item) > 0;
    }

    public void mostrar() {
        if (itens.isEmpty()) {
            println("Inventário vazio");
            return;
        }
        for (Map.Entry<String, Integer> entrada : itens.entrySet()) {
            println(entrada.getKey() + " x" + entrada.getValue());
        }
    }

    public Map<String, Integer> getItens() {
        return itens;
    }
}