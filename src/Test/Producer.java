package Test;

import csp.lang.Thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> buzon; // la cola bloqueante que permite guardar cadenas

    List<String> mensajes = Arrays.asList("Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "Wouldn't you eat ivy too?");

    public Producer(BlockingQueue<String> d) {
// inicializar el buzon
        buzon = d;
    }

    public void run() {
        try {
            // recupero en cada ciclo el mensaje que esta
// en cada lista el mensaje del buzon, PARA MANDARLO
            for (String s : mensajes){
                buzon.put(s);
                Thread.sleep(1000);
            }
            buzon.put("DONE"); // manda el ultimo mensaje “DONE”
        } catch (InterruptedException intEx) {
            System.out.println("Interrupted! " +
                    "Last one out, turn out the lights!");
        }
    }
}
