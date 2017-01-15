package BarcosYCoches; /**
 * Created by hammer on 27/12/16.
 */
/*===== MONITOR PUENTE LEVADIZO ===*/

import java.util.concurrent.locks.*;

public class CPuenteLevadizo {
    final ReentrantLock cerrojo = new ReentrantLock();

    /*son variables condicionales, similar al de semaforos... que
        tambien despierta y hace dormir a los procesos*/
    final Condition okCoche = cerrojo.newCondition();
    final Condition okBarco = cerrojo.newCondition();
    int c, b;

    public CPuenteLevadizo() {
        b = 0;
        c = 0;
    }

    public void entrarCoche() throws InterruptedException {
        cerrojo.lock(); /*bloquea el modulo*/
        try {
            //hay barco pasando o esperando
            while ((b > 0) || (awaited(okBarco) > 0))
            { //tiene prioridad los barcos
                System.out.println("coche esperando..puente ocupado");
                okCoche.await();
                //el coche espera
            }
            c++; //incrementa el número de coches pasando
            okCoche.signal(); //despierta si hay otro coche esperando
        }//BAJAR PUENTE
        finally {
            /*desbloquea el modulo*/
            cerrojo.unlock();
        }
    }

    public void salirCoche() throws InterruptedException {
        cerrojo.lock(); /* bloqueamos con lock*/
        try {
            System.out.println("coche saliendo..puente libre");
            c--; //disminuye el nro. de coches pasando
            if (c == 0) /* si es el ultimo coche despierta */
                okBarco.signal(); //El último coche que pasa
                //comunica al barco que puede pasar (si hubiera)
        } finally {
            /*desbloquamos*/
            cerrojo.unlock();
        }
    }

    public void entrarBarco() throws InterruptedException {
        cerrojo.lock();
        try {
            while ((c > 0))
            //--si hay coches pasando
            {
                System.out.println("barco esperando..puente ocupado");
                okBarco.await(); //--esperar a que pasen los coches
            }
            b++; //--incrementa el no. de barcos pasando
            okBarco.signal(); //--despierta a otro barco si hubiera
//--para que intente pasar
//LEVANTAR PUENTE
        } finally {
            cerrojo.unlock();
        }
    }

    public void salirBarco() throws InterruptedException {
        cerrojo.lock();
        try {
            System.out.println("barco saliendo..puente libre");
            b--; //--disminuye el num. de barcos pasando
            if (b == 0)
                okCoche.signal(); //-- el último barco comunica al coche
                                  //--que espera (si hubiera) que puede intentar pasar
        } finally {
            cerrojo.unlock();
        }
    }
    /* es una cola que se maneja la variable del tipo condition q es la cola del sistema operativo */
    private int awaited(Condition condicion) { //--devuelve el número de hilos que esperan sobre la variable condicion
        return cerrojo.getWaitQueueLength(condicion);
    }
}
