package Test; /* en si es buzon sincrono para este Main*/

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;


public class MainSincrono {
    public static void main(String[] args) {
        BlockingQueue<String> buzon = new SynchronousQueue<>();

        new Thread(new Producer(buzon)).start();
        new Thread(new Consumer(buzon)).start();
    }
}
