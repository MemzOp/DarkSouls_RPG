public class Jornada {
    private int areaAtual = 0;
    private int posicao = 0;

    public Inimigo proximoInimigo() {
        Area area = Area.values()[areaAtual];
        return new Inimigo(area.getInimigo(posicao));
    }

    // Chamar quando o jogador derrota o inimigo atual
    public void avancar() {
        Area area = Area.values()[areaAtual];
        posicao++;
        if (posicao == area.getTotalInimigos()) {
            areaAtual++;
            posicao = 0;
        }
    }

    public boolean terminou() {
        return areaAtual >= Area.values().length;
    }

    public Area getAreaAtual() {
        return Area.values()[areaAtual];
    }
}