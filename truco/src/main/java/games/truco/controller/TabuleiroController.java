/**
 *
 */
package games.truco.controller;

import games.truco.model.Carta;
import games.truco.model.Jogador;
import games.truco.model.Partida;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 * @author raphael.pinheiro
 */
@ManagedBean(name = "tabuleiroController")
@ViewScoped
public class TabuleiroController implements Serializable {

    /**
     * Serial UID.
     */
    private static final long serialVersionUID = -3888884707925236740L;

    @Inject
    private Partida partida;

    /**
     * Pangaré.
     */
    private Jogador jogador;

    private Carta cartaJogada;

    @PostConstruct
    public void init() {
        jogador = new Jogador();
        cartaJogada = null;
    }

    public void iniciarPartida() {
        partida.entrar(jogador);
        partida.iniciar();
        System.out.println("Pronto!");
    }

    public void jogarCarta(final int i) {
        System.out.println(i);
        if (jogador.getCartas() != null && jogador.getCartas()[i] != null) {
            Carta c = jogador.getCartas()[i];
            if (partida.getMao().jogaCarta(c)) {
                cartaJogada = c;
                jogador.getCartas()[i] = null;
            }
        }
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
     * Obtém o valor do atributo partida.
     * @return valor do atributo partida
     */
    public Partida getPartida() {
        return partida;
    }

    /**
     * Obtém o valor do atributo cartaJogada.
     * @return valor do atributo cartaJogada
     */
    public Carta getCartaJogada() {
        return cartaJogada;
    }

    /**
     * Carrega o valor (cartaJogada) ao atributo cartaJogada.
     * @param cartaJogada novo valor para o atributo cartaJogada
     */
    public void setCartaJogada(final Carta cartaJogada) {
        this.cartaJogada = cartaJogada;
    }

}
