package Barbero;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hammer on 27/01/17.
 */
public class MBarbero {
    int sillas = 50;
    int numeroSillas = sillas;

    final ReentrantLock bloqueador = new ReentrantLock();

    final Condition clienteEsperando = bloqueador.newCondition();
    final Condition barberoSiesta = bloqueador.newCondition();
    public int sillasOcupadas = 0;

    boolean dormido = true;

    public void cojerCliente(String hilo) throws InterruptedException {
        bloqueador.lock();
        try {
            /** si hay sillas vacias */
            if (sillasOcupadas == 0) { // esta vacio
                /**  entonces a dormir */
                dormido = true;
                System.out.println("Dormir");
                barberoSiesta.await();

                System.out.println("Atender a cliente, directamente " + sillasOcupadas);
                /* entra directamente ya q fue el q desperto al barbero*/
                clienteEsperando.signal(); /* ver si hay otro cliente, esperado*/
            } else {
            /* notificar al siguiente cliente */
                System.out.println("cojer cliente del asiento");
                clienteEsperando.signal();
            }
        } finally {
            bloqueador.unlock();
        }

    }

    public void pedirCorte(String hilo) throws InterruptedException {
        bloqueador.lock();
        try {
            if (sillasOcupadas == numeroSillas) { // esta lleno
                /** retirarse de la peluqieria */
                System.out.println("sillas ocupadas " + sillasOcupadas +
                        " El hilo " + hilo + " se va del local ");
            }
            /** verificar que  este dormido */
            if (dormido) {
                System.out.println("se desperto para cortar");
                dormido = false; /*despertar */
                barberoSiesta.signal(); // despierta al barbero
            } else { // si nó esta dormido, quiere decir que esta atendiendo
                if (sillasOcupadas == sillas) {
                    /** retirarse de la peluqieria */
                    System.out.println("sillas ocupadas ## " + sillasOcupadas +
                            " El hilo " + hilo + " se va del local ");
                } else {
                    /** entonces tiene q esperar, a que termine de atender al otro */
                    sillasOcupadas++;
                    System.out.println("ocupar una silla " + sillasOcupadas+" "+hilo);
                    clienteEsperando.await();
                    /** atender cliente */
                    sillasOcupadas--;
                    System.out.println("Atender cliente " + hilo + " Sillas " + sillasOcupadas);
                    clienteEsperando.signal(); /* verificar si hay mas en la sala de espera*/
                }

            }


        } finally {
            bloqueador.unlock();
        }

    }


    public synchronized int awaited(Condition condicion) { //--devuelve el número de hilos que esperan sobre la variable condicion
        return bloqueador.getWaitQueueLength(condicion);
    }
}
