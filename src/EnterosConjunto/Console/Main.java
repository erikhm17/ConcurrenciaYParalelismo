package EnterosConjunto.Console;

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
    final static int infinito = -100000000;

    public static void main(String[] args) {
        BlockingQueue<MyMap> buzon = new SynchronousQueue<>();


        ArrayList<MyMap> S = new ArrayList<>();
        S.add(new MyMap(0, -1));
        S.add(new MyMap(1, 2));
        S.add(new MyMap(2, 3));
        S.add(new MyMap(3, -4));
        S.add(new MyMap(3, -6));

        ArrayList<MyMap> T = new ArrayList<>();
        T.add(new MyMap(0, -5));
        T.add(new MyMap(1, 6));
        T.add(new MyMap(2, 7));
        T.add(new MyMap(3, -8));
        T.add(new MyMap(4, 9));
        T.add(new MyMap(4, 10));


        new Thread(new ProcesoA(buzon, S)).start();
        new Thread(new ProcesoB(buzon, T)).start();

    }

}
