package EnterosConjunto.Graphics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class MainConsole {
    final static int infinito = -100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        BlockingQueue<MyMap> buzon = new SynchronousQueue<>();
        ArrayList<MyMap> S = new ArrayList<>();
        ArrayList<MyMap> T = new ArrayList<>();

        System.out.println("Datos para el proceso A ");
        String data = leer.readLine();
        String[] datas = data.split(" ");
        for (int i = 0; i < datas.length; i++) {
            S.add(new MyMap(i, Integer.parseInt(datas[i])));
        }

        System.out.println("Datos para el proceso B ");
        String data2 = leer.readLine();
        String[] datas2 = data2.split(" ");
        for (int i = 0; i < datas2.length; i++) {
            T.add(new MyMap(i, Integer.parseInt(datas2[i])));
        }

        // T = -10 -5 -1 0 2 3 5 7 8
        // S = 10 11 17 4 9 -11 16


        /*
        S.add(new MyMap(0, -1));
        S.add(new MyMap(1, 2));
        S.add(new MyMap(2, 3));
        S.add(new MyMap(3, -4));
        S.add(new MyMap(3, -6));


        T.add(new MyMap(0, -5));
        T.add(new MyMap(1, 6));
        T.add(new MyMap(2, 7));
        T.add(new MyMap(3, -8));
        T.add(new MyMap(4, 9));
        T.add(new MyMap(4, 10));
        */

        new Thread(new ProcesoA(buzon, S)).start();
        new Thread(new ProcesoB(buzon, T)).start();

    }

}
