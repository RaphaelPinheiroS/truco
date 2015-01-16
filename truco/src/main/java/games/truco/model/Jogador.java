/**
 *
 */
package games.truco.model;

import java.io.Serializable;

/**
 * @author raphael.pinheiro
 */
public class Jogador implements Serializable {

    /**
     * Serial UID.
     */
    private static final long serialVersionUID = -8007527731297827314L;

    private String nome;

    private Carta[] cartas;

    /**
     * Obtém o valor do atributo nome.
     * @return valor do atributo nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Carrega o valor (nome) ao atributo nome.
     * @param nome novo valor para o atributo nome
     */
    public void setNome(final String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o valor do atributo cartas.
     * @return valor do atributo cartas
     */
    public Carta[] getCartas() {
        return cartas;
    }

    /**
     * Carrega o valor (cartas) ao atributo cartas.
     * @param cartas novo valor para o atributo cartas
     */
    public void setCartas(final Carta[] cartas) {
        this.cartas = cartas;
    }

    public void recebeMao(final Carta carta1, final Carta carta2, final Carta carta3) {
        carta1.setJogador(this);
        carta2.setJogador(this);
        carta3.setJogador(this);
        this.cartas = new Carta[] {carta1, carta2, carta3};
    }
}
