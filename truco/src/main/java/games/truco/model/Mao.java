/**
 *
 */
package games.truco.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.enterprise.context.Dependent;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * Representa cada mão jogada dentro de uma partida.
 * @author raphael.pinheiro
 */
@Dependent
public class Mao implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4022716244531361338L;

    private Tento tento;

    private Carta vira;

    private Jogador[] jogadores;

    private int indexJogadorInicial;

    private int indexProximoJogador;

    private List<Carta> cartasJogadas;

    public void iniciaMao(final Jogador[] jogadores) {
        this.jogadores = jogadores;
        tento = Tento.TENTO;
        indexJogadorInicial = 0;
        indexProximoJogador = 0;
        cartasJogadas = new ArrayList<Carta>();

        List<Carta> cartas = Baralho.shuffle();
        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i] == null) {
                Jogador j = new JogadorBot();
                j.setNome("Bot" + UUID.randomUUID().toString().substring(0, 3));
                jogadores[i] = j;
            }
            int j = i * 3;
            jogadores[i].recebeMao(cartas.get(j), cartas.get(j + 1), cartas.get(j + 2));
        }
        vira = cartas.get(jogadores.length * 3 + 1);
    }

    /**
     * Obtém o valor do atributo tento.
     * @return valor do atributo tento
     */
    public Tento getTento() {
        return tento;
    }

    /**
     * Carrega o valor (tento) ao atributo tento.
     * @param tento novo valor para o atributo tento
     */
    public void setTento(final Tento tento) {
        this.tento = tento;
    }

    /**
     * Obtém o valor do atributo vira.
     * @return valor do atributo vira
     */
    public Carta getVira() {
        return vira;
    }

    /**
     * Carrega o valor (vira) ao atributo vira.
     * @param vira novo valor para o atributo vira
     */
    public void setVira(final Carta vira) {
        this.vira = vira;
    }

    /**
     * Obtém o valor do atributo jogadores.
     * @return valor do atributo jogadores
     */
    public Jogador[] getJogadores() {
        return jogadores;
    }

    /**
     * Carrega o valor (jogadores) ao atributo jogadores.
     * @param jogadores novo valor para o atributo jogadores
     */
    public void setJogadores(final Jogador[] jogadores) {
        this.jogadores = jogadores;
    }

    /**
     * Obtém o valor do atributo indexJogadorInicial.
     * @return valor do atributo indexJogadorInicial
     */
    public int getIndexJogadorInicial() {
        return indexJogadorInicial;
    }

    /**
     * Carrega o valor (indexJogadorInicial) ao atributo indexJogadorInicial.
     * @param indexJogadorInicial novo valor para o atributo indexJogadorInicial
     */
    public void setIndexJogadorInicial(final int indexJogadorInicial) {
        this.indexJogadorInicial = indexJogadorInicial;
    }

    /**
     * Obtém o valor do atributo cartaJogada.
     * @return valor do atributo cartaJogada
     */
    public Carta getCartaJogada(final Jogador jogador) {

        return cartasJogadas == null ? null : Iterables.tryFind(cartasJogadas, new Predicate<Carta>() {

            @Override
            public boolean apply(final Carta carta) {
                return carta.getJogador().equals(jogador);
            }
        }).orNull();
    }

    public boolean jogaCarta(final Carta carta) {
        if (carta.getJogador().equals(jogadores[indexProximoJogador])) {
            cartasJogadas.add(carta);
            return true;
        }
        return false;
    }

}
