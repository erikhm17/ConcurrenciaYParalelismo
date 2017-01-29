package SincronizacionMonitores;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hammer on 28/01/17.
 */
public class MSincronizacion {
    final ReentrantLock bloqueador = new ReentrantLock();

    /**
     * cola de consumidores
     */
    final Condition consumidor = bloqueador.newCondition();
    final Condition productor = bloqueador.newCondition();
    int buffer = 0;

    void producir(String hilo) throws InterruptedException {
        bloqueador.lock();
        try {
            if (buffer < 3) {
                buffer++;
                System.out.println("producer buffer " + buffer + " hilo : " + hilo);
                consumidor.signal();
                System.out.println(awaited(consumidor));
            } else {
                System.out.println("sleep producer " + buffer + " hilo : " + hilo);
                productor.await();
            }
        } finally {
            bloqueador.unlock();
        }
    }

    void consumir(String hilo) throws InterruptedException {
        bloqueador.lock();
        try {
            if (buffer > 0) {
                buffer--;
                System.out.println("consumer buffer  " + buffer + " hilo : " + hilo);
                productor.signal();
            } else {
                System.out.println("sleep consumer " + buffer + " hilo : " + hilo);
                consumidor.await();
                buffer--;
                System.out.println("Desperto el hilo " + hilo + " buffer : "+buffer);
                System.out.println("consumer buffer  " + buffer + " hilo : " + hilo);
                productor.signal();

            }
        } finally {
            bloqueador.unlock();
        }
    }

    /* es una cola que se maneja la variable del tipo condition q es la cola del sistema operativo */
    private int awaited(Condition condicion) { //--devuelve el número de hilos que esperan sobre la variable condicion
        return bloqueador.getWaitQueueLength(condicion);
    }

}
