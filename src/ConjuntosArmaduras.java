import java.util.EnumMap;
import java.util.Map;

public class ConjuntosArmaduras {
    private final Map<TipoPeca, Armadura> pecas = new EnumMap<>(TipoPeca.class);

    public void equipar(Armadura peca) {
        pecas.put(peca.getTipoPeca(), peca);
    }

    public int getDefesaFisicaTotal() {
        return pecas.values().stream().mapToInt(Armadura::getDefesaFisica).sum();
    }

    public double getPesoTotal() {
        return pecas.values().stream().mapToDouble(Armadura::getPeso).sum();
    }
}