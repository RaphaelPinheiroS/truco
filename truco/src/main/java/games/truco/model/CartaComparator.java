/**
 *
 */
package games.truco.model;

import java.util.Comparator;
import javax.inject.Inject;

/**
 * @author raphael.pinheiro
 */
public class CartaComparator implements Comparator<Carta> {

    private Carta vira;

    @Inject
    private NaipeComparator naipeComparator;

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(final Carta o1, final Carta o2) {
        // o1 manilha
        if (o1.valor().peso() == vira.valor().peso() + 1) {
            // o2 não manilha
            if (o1.valor().peso() != vira.valor().peso() + 1) {
                return 1;
            }
            // o2 manilha
            return naipeComparator.compare(o1.naipe(), o2.naipe());
        }
        // o1 não manilha
        // o2 manilha
        if (o2.valor().peso() == vira.valor().peso() + 1) {
            return -1;
        }
        // o2 não manilha
        return new Integer(o1.valor().peso()).compareTo(o2.valor().peso());
    }

    public void setVira(final Carta carta) {
        this.vira = carta;
    }

}
