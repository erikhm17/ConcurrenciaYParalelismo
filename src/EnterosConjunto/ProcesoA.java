package EnterosConjunto;

import csp.lang.Thread;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * Created by hammer on 14/01/17.
 */
/* Implementamos Procces de la libreria CTJ */
public class ProcesoA implements Runnable {
    /**
     * creamos una cola bloqueante, para poner los enteros
     */
    private BlockingQueue<Integer> buzonSincrono;
    /**
     * una lista de Enteros
     */
    ArrayList<Integer> S = new ArrayList<>();

    public ProcesoA(BlockingQueue<Integer> buzon, ArrayList<Integer> S) {
        this.buzonSincrono = buzon;
        this.S = S;
    }


    @Override
    public void run() {
        try {
        /* recupero en cada ciclo el mensaje en cada elemento de la
        * lista */
            for (Integer s : S) {
                System.out.println("Enviando un elemento");
                buzonSincrono.put(s);
                Thread.sleep(1000);
            }
            /* mandamos el ultimo mensaje */
            buzonSincrono.put(new Integer(-1));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
