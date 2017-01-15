package Antropofago;

import java.util.ArrayList;

/**
 * Created by hammer on 31/12/16.
 */
public class Main2 {
    public static void main(String[] args) {
        Thread hilo = new Thread(() -> {
            MAntropofago mAntropofago = new MAntropofago();
            Cocinero c1 = new Cocinero(mAntropofago);
            ArrayList<Antropofago> antropofagos = new ArrayList<Antropofago>();
            c1.setName("C1");
            c1.start();
            int i = 0;
            while (true) {
                try {
                    antropofagos.add(new Antropofago(mAntropofago));
                    antropofagos.get(i).setName(""+i);
                    antropofagos.get(i).start();
                    Thread.sleep(10);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        hilo.start();


    }

}