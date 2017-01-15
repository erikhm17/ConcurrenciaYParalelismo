package Aeropuerto;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hammer on 31/12/16.
 */
public class MonitorTorre {
    final ReentrantLock bloqueador = new ReentrantLock();
    final Condition desp = bloqueador.newCondition();
    final Condition aterr = bloqueador.newCondition();
    final Condition alerta = bloqueador.newCondition();

    boolean ocu = false;

    public boolean isOcu() {
        return ocu;
    }

    public void pedirDespegue(String nombreHilo) throws InterruptedException {
        bloqueador.lock();
        if (ocu) {
            System.out.println("Esperar " + nombreHilo);
            desp.await();
        }
        System.out.println("Pedir despeque " + nombreHilo);
        ocu = true;
        bloqueador.unlock();
    }

    public void pedirAterrizaje(String nombreHilo) throws InterruptedException {
        bloqueador.lock();
        if (ocu) {
            System.out.println("Esperar " + nombreHilo);
            aterr.await();
        }
        ocu = true;
        System.out.println("Pedir aterrizaje " + nombreHilo);
        bloqueador.unlock();
    }

    public void alertaRoja(String nombreHilo) throws InterruptedException {
        bloqueador.lock();
        if (ocu) {
            System.out.println("Esperar " + nombreHilo);
            alerta.await();
        }
        ocu = true;
        System.out.println("Alerta roja " + nombreHilo);
        bloqueador.unlock();
    }

    public void confirmarDespegado(String nombreHilo) throws InterruptedException {
        bloqueador.lock();
        confirmar();
        System.out.println("Se confirmo despegado " + nombreHilo);
        bloqueador.unlock();
    }

    public void confirmarAterrizado(String nombreHilo) throws InterruptedException {
        bloqueador.lock();
        confirmar();
        System.out.println("Se confirmo Aterrizado " + nombreHilo);
        bloqueador.unlock();
    }

    public void confirmar() throws InterruptedException {
        if (awaited(alerta) != 0) {
            alerta.signal();
        } else if (awaited(desp) != 0) {
            desp.signal();
        } else if (awaited(aterr) != 0) {
            aterr.signal();
        } else {
            ocu = false;
        }
    }

    /* es una cola que se maneja la variable del tipo condition q es la cola del sistema operativo */
    private int awaited(Condition condicion) { //--devuelve el número de hilos que esperan sobre la variable condicion
        return bloqueador.getWaitQueueLength(condicion);
    }
}
