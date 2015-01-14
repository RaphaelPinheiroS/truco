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
}
