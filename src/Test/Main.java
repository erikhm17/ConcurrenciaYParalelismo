package Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by hammer on 20/01/17.
 */
public class Main {
    public static void main(String[] args) {
        MSincronizacion mSincronizacion = new MSincronizacion();
        ArrayList<Productor> productors = new ArrayList<>();
        ArrayList<Consumidor> consumidors = new ArrayList<>();
        Productor p;
        Consumidor c;
        int n = 5;
        for (int i = 0; i <n; i++) {
            p = new Productor(mSincronizacion);
            p.setName("p" + i);
            productors.add(p);

        }
        for (int i = 0; i < n; i++) {
            c = new Consumidor(mSincronizacion);
            c.setName("c" + i);
            consumidors.add(c);
        }
        /* iniciaremos */
        for (int i = 0; i < productors.size(); i++) {
            productors.get(i).start();
        }
        for (int i = 0; i < consumidors.size(); i++) {
            consumidors.get(i).start();
        }
    }

}
