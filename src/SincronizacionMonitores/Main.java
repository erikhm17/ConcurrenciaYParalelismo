package SincronizacionMonitores;

/**
 * Created by hammer on 20/01/17.
 */
public class Main {
    public static void main(String[] args) {
        MSincronizacion mSincronizacion = new MSincronizacion();
        Productor p1 = new Productor(mSincronizacion);
        Productor p2 = new Productor(mSincronizacion);
        Productor p3 = new Productor(mSincronizacion);

        Consumidor c1 = new Consumidor(mSincronizacion);
        Consumidor c2 = new Consumidor(mSincronizacion);
        Consumidor c3 = new Consumidor(mSincronizacion);

        c1.setName("c1");
        c2.setName("c2");
        c3.setName("c3");

        p1.setName("p1");
        p2.setName("p2");
        p3.setName("p3");


        c1.start();
        c2.start();
        c3.start();

        p1.start();
        p2.start();
        p3.start();

/**
 * con arreglos
 * */
/*
*    MSincronizacion mSincronizacion = new MSincronizacion();
        ArrayList<Productor> productors = new ArrayList<>();
        ArrayList<Consumidor> consumidors = new ArrayList<>();
        Productor p;
        Consumidor c;
        int n = 100;
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
       /* for (int i = 0; i < productors.size(); i++) {
            productors.get(i).start();
        }
        for (int i = 0; i < consumidors.size(); i++) {
            consumidors.get(i).start();
        }*/

    }

}
