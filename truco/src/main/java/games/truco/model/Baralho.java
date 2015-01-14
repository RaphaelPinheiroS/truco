/**
 *
 */
package games.truco.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import com.google.common.collect.Lists;

/**
 * @author raphael.pinheiro
 */
@Startup
@Singleton
public class Baralho {

    private static Carta[] cartas;

    @PostConstruct
    public void initBaralho() {
        cartas = new Carta[44];
        int i = 0;
        for (Naipe naipe : Naipe.values()) {
            for (Valor valor : Valor.values()) {
                cartas[i++] = new Carta(naipe, valor);
            }
        }
    }

    public static List<Carta> shuffle() {
        ArrayList<Carta> cartas = Lists.newArrayList(Baralho.cartas);
        Collections.shuffle(cartas);
        return cartas;
    }

}
