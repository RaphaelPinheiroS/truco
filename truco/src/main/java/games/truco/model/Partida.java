/**
 *
 */
package games.truco.model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author raphael.pinheiro
 */
@ApplicationScoped
public class Partida {

    private Jogador[] jogadores;

    @Inject
    private Mao mao;

    @PostConstruct
    public void init() {
        jogadores = new Jogador[4];
    }

    public boolean entrar(final Jogador jogador) {
        for (int i = 0; i < jogadores.length; i++) {
            // if (jogadores[i] == null) {
            jogadores[i] = jogador;
            return true;
            // }
        }
        return false;
    }

    public void iniciar() {
        mao.iniciaMao(jogadores);
    }

    public Mao getMao() {
        return mao;
    }

}
