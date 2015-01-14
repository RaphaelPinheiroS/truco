/**
 *
 */
package games.truco.model;

import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author raphael.pinheiro
 */
@ApplicationScoped
public class Partida {

    private Jogador[] jogadores;

    @PostConstruct
    public void init() {
        jogadores = new Jogador[4];
    }

    public boolean entrar(final Jogador jogador) {
        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i] == null) {
                jogadores[i] = jogador;
                return true;
            }
        }
        return false;
    }

    public void iniciar() {
        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i] == null) {
                Jogador j = new JogadorBot();
                j.setNome("Bot" + UUID.randomUUID().toString().substring(0, 3));
                jogadores[i] = j;
            }
        }
    }

}
