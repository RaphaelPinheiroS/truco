/**
 *
 */
package games.truco.model;

/**
 * @author raphael.pinheiro
 */
public enum Valor {

    A(7), _2(8), _3(9), _4(0), _5(1), _6(2), _7(3), Q(4), J(5), K(6);

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

    public int peso() {
        return this.valor;
    }

    public String asString() {
        if (this == _2) {
            return "2";
        } else if (this == _3) {
            return "3";
        } else if (this == _4) {
            return "4";
        } else if (this == _5) {
            return "5";
        } else if (this == _6) {
            return "6";
        } else if (this == _7) {
            return "7";
        }
        return this.toString();
    }
}
