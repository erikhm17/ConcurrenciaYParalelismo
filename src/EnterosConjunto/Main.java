package EnterosConjunto;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Suponga dados dos procesos A y B. A tiene un conjunto de enteros S,
 * y B tiene un conjunto de enteros T. Los dos procesos intercambian
 * valores (uno a la vez) hasta que todos los elementos de S sean
 * menores que todos los elementos de T. Desarrolle un programa que
 * utilice pasaje de mensajes sincrónicos para resolver el problema.
 * <p>
 * Created by hammer on 14/01/17.
 */

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> buzon = new SynchronousQueue<>();

        ArrayList<Integer> S = new ArrayList<>();
        S.add(new Integer(5));
        S.add(new Integer(7));
        S.add(new Integer(8));
        S.add(new Integer(9));

        ArrayList<Integer> T = new ArrayList<>();
        S.add(new Integer(4));
        S.add(new Integer(8));
        S.add(new Integer(1));
        S.add(new Integer(2));
        S.add(new Integer(3));


        new Thread(new ProcesoA(buzon, S)).start();
        new Thread(new ProcesoB(buzon,T)).start();

    }

}
