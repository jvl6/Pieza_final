package main;
import pieza.*;

/**
 *
 * @author Juan Catrileo / Javier Vergara
 */
public class Main {

    public static void main(String[] args) {
        Pieza mainPieza = new Pieza();
        
        mainPieza.mensajeBienvenida();
        mainPieza.setmPieza();
        mainPieza.getmPieza();
        mainPieza.setGato();
        mainPieza.setRatones();
        mainPieza.setMueble();
    }
}
