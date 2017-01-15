package EnterosConjunto;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * Created by hammer on 14/01/17.
 */
public class ProcesoB implements Runnable {
    /**
     * Creamos una cola bloqueante
     */
    private BlockingQueue<Integer> buzonSincrono;
    ArrayList<Integer> T = new ArrayList<>();

    public ProcesoB(BlockingQueue<Integer> buzonSincrono,
                    ArrayList<Integer> T) {

        this.buzonSincrono = buzonSincrono;
        this.T = T;
    }

    public int getMayor(ArrayList T) {
        int menor = Integer.parseInt(T.get(0).toString());

        for (int i = 0; i <= T.size(); i++) {
            int value = Integer.parseInt(T.get(i).toString());
            if (menor >= value) {
                menor = value;
            }
        }
        return menor;
    }

    @Override
    public void run() {
        try {
            Integer data = null;
            while (!((data = buzonSincrono.take()).equals(-1))) {
                System.out.println(" recibido : " + data);
                Thread.sleep(3000);
            }
            System.out.println("Se recibio -1 , Fin del proceso de " +
                    "envio  ");
        } catch (InterruptedException intEx) {
            System.out.println(" Opps, paso algo interrupido ");
        }
    }
}
