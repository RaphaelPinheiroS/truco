/**
 *
 */
package games.truco.model;

import java.util.Comparator;

/**
 * @author raphael.pinheiro
 */
public class NaipeComparator implements Comparator<Naipe> {

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(final Naipe o1, final Naipe o2) {
        if (o1 == Naipe.PAUS) {
            return 1;
        } else if (o1 == Naipe.COPAS && o2 != Naipe.PAUS) {
            return 1;
        } else if (o1 == Naipe.ESPADAS && o2 == Naipe.OUROS) {
            return 1;
        }
        return -1;
    }

}
