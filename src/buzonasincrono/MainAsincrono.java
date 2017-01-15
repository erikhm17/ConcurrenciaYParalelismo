//--PROGRAMA PRINCIPAL
package buzonasincrono;

import java.util.concurrent.*;

public class MainAsincrono {
    public static void main(String[] args) {
/* la cola bloqueante */
        BlockingQueue<String> buzon = new ArrayBlockingQueue(1, true);

  /* los hilos */
        (new Thread(new Producer(buzon))).start();
        (new Thread(new Consumer(buzon))).start();
    }
}