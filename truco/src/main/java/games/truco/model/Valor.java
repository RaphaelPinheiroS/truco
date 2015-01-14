/**
 *
 */
package games.truco.model;

/**
 * @author raphael.pinheiro
 */
public enum Valor {

    A(7), _1(8), _2(9), _3(10), _4(0), _5(1), _6(2), _7(3), Q(4), J(5), K(6);

    private Valor(final int valor) {
        this.valor = valor;
    }

    private int valor;

    public int comparteTo(final Valor valor) {
        if (valor.valor == this.valor) {
            return 0;
        }
        return this.valor > valor.valor ? 1 : -1;
    }
}
