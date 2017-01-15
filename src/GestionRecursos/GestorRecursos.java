package GestionRecursos;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hammer on 28/12/16.
 * MONITOR PARA EL GestorRecursos DE RECURSOS 
 */

public class GestorRecursos {
    final ReentrantLock bloqueador = new ReentrantLock();
    final Condition productor = bloqueador.newCondition();
    final Condition consumidor = bloqueador.newCondition();
    int buffer;

    public int getBuffer() {
        return buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public GestorRecursos(){
        this.buffer = 0;
    }
    public void consumir() throws InterruptedException{
        bloqueador.lock();
        try {
            /** Mientras no exista algo para consumir , entonces
             * el productor que espere */
            while (this.buffer<=0){
                productor.await();
            }
            this.buffer--;
        }finally {
            bloqueador.unlock();
        }
    }
    public void producir() throws InterruptedException{
        bloqueador.lock();
        try {
            /** producir con todo*/
            buffer++;
        }finally {

        }
        bloqueador.unlock();
    }
}
