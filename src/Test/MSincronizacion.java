package Test;

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
            if (buffer < 100) {
                buffer++;
                System.out.println("producer buffer " + buffer + " hilo : " + hilo);
                /** si pongo este signal
                 * la linea que sigue despues de este signal aun se tiene q
                 * ejecutar, lo mismo con el codigo de "System.out.println("Otro modulo mas entra"); y
                 * un for hasta 1000, que no se van a entrecortar ya q es un bloque ReentrantLock"
                 * ya que el signal despierta al que esta sincronizado con
                 * el wait de su condicion, pero recuerda que
                 * el signal no retiene su modulo asi q las lineas siguientes
                 * se ejecutan normal despues de hacer signal.
                 * */
                consumidor.signal();
                System.out.println(awaited(consumidor));
            } else {
                System.out.println("sleep producer " + buffer + " hilo : " + hilo);
                /** en cambio el awai, tiene q esperar a q haya un signal
                 * pero algo importante, si llamo a un signal que está sincronizado
                 * en este caso con productor , no necesariamente se iniciara de inmediato
                 * sino q entra a la cola de procesos listos de lo q estaba en suspension
                 * */
                productor.await();
            }
            System.out.println("Otro modulo mas entra");
            for (int i = 0 ; i<=1000;i++){
                System.out.print(" "+i);
            }
            System.out.println("");
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
                consumidor.await(); // asi se queda a dormir hasta que algioen lo despierte para ejecutar el buffer--
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
