package buzonasincrono; /* en si es buzon sincrono para este MainConsole*/

import java.util.concurrent.*;


public class MainSincrono {
    public static void main(String[] args) {
        BlockingQueue<String> buzon = new SynchronousQueue<String>();
        (new Thread(new Producer(buzon))).start();
        (new Thread(new Consumer(buzon))).start();
    }
}
