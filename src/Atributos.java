import java.util.EnumMap;
import java.util.Map;

public class Atributos {
    private final Map<TipoAtributo, Integer> valores = new EnumMap<>(TipoAtributo.class);

    public Atributos(int resistencia, int vitalidade, int forca,
                     int destreza, int inteligencia, int fe) {
        valores.put(TipoAtributo.RESISTENCIA, resistencia);
        valores.put(TipoAtributo.VITALIDADE, vitalidade);
        valores.put(TipoAtributo.FORCA, forca);
        valores.put(TipoAtributo.DESTREZA, destreza);
        valores.put(TipoAtributo.INTELIGENCIA, inteligencia);
        valores.put(TipoAtributo.FE, fe);
    }

    public int get(TipoAtributo tipo) {
        return valores.get(tipo);
    }

    public void subir(TipoAtributo tipo) {
        valores.put(tipo, valores.get(tipo) + 1);
    }

    public int getNivel() {
        return valores.values().stream().mapToInt(Integer::intValue).sum();
    }
}