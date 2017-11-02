package pieza;

/**
 *
 * @author Juan Catrileo / Javier Vergara
 */
public class Vacio extends Item{
    String vacio = "-";

    public Vacio() {
    }

    @Override
    public String toString() {
        return vacio;
    }
}
