/**
 *
 */
package games.truco.model;

/**
 * @author raphael.pinheiro
 */
public class Carta {

    private final Naipe naipe;

    private final Valor valor;

    private boolean virada;

    /**
     * Dono da carta.
     */
    private Jogador jogador;

    public Carta(final Naipe naipe, final Valor valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public Naipe naipe() {
        return this.naipe;
    }

    public Valor valor() {
        return this.valor;
    }

    public boolean isRed() {
        return naipe != null && (naipe == Naipe.COPAS || naipe == Naipe.OUROS);
    }

    /**
     * Obtém o valor do atributo jogador.
     * @return valor do atributo jogador
     */
    public Jogador getJogador() {
        return jogador;
    }

    /**
     * Carrega o valor (jogador) ao atributo jogador.
     * @param jogador novo valor para o atributo jogador
     */
    public void setJogador(final Jogador jogador) {
        this.jogador = jogador;
    }

    /**
     * Obtém o valor do atributo virada.
     * @return valor do atributo virada
     */
    public boolean isVirada() {
        return virada;
    }

    /**
     * Carrega o valor (virada) ao atributo virada.
     * @param virada novo valor para o atributo virada
     */
    public void setVirada(final boolean virada) {
        this.virada = virada;
    }

}
