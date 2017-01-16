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
        BlockingQueue<MyMap> buzon = new SynchronousQueue<>();

        ArrayList<MyMap> S = new ArrayList<>();
        S.add(new MyMap(0, 5));
        S.add(new MyMap(1, 7));
        S.add(new MyMap(2, 8));
        S.add(new MyMap(3, 9));

        ArrayList<MyMap> T = new ArrayList<>();
        T.add(new MyMap(0, 4));
        T.add(new MyMap(1, 6));
        T.add(new MyMap(2, 1));
        T.add(new MyMap(3, 2));
        T.add(new MyMap(4, 3));
        T.add(new MyMap(4, 10));


        new Thread(new ProcesoA(buzon, S)).start();
        new Thread(new ProcesoB(buzon, T)).start();

    }

}
