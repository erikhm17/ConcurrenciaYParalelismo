package PuenteEstrecho;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hammer on 27/12/16.
 */
public class CPuenteEstrecho {
    /**
     * ponemos un bloqueador
     */
    final ReentrantLock bloqueador = new ReentrantLock();
    /**
     * variables condicionales similares a los semaforos
     * Tambien despierta y hace dormir a los semaforos
     */
    final Condition okSur = bloqueador.newCondition();
    final Condition okNorte = bloqueador.newCondition();
    int nroCochesPasandoNorte, nroCochesPasandoSur;

    public CPuenteEstrecho() {
        nroCochesPasandoNorte = 0;
        nroCochesPasandoSur = 0;
    }

    public void entrarCocheDelSur() throws InterruptedException {
        bloqueador.lock();
        try {
            while ((nroCochesPasandoNorte > 0)) {
                /** el coche del sur espera */
                okSur.await();
            }
            /** en caso de que no haya coches pasando del norte
             * se incrementa el numero de coches*/
            nroCochesPasandoSur++;
            okSur.signal();

        } finally {
            /** sacamos el bloqueador */
            bloqueador.unlock();
        }
    }

    public void entrarCocheDelNorte() throws InterruptedException {
        bloqueador.lock();
        try {
            /** si hay coches pasando del sur , entonces
             * el coche del norte tiene q esperar
             * */
            while ((nroCochesPasandoSur > 0)) {
                /** entonces el coche del norte espera*/
                okNorte.await();
            }
            /** en caso de que no haya coches pasando del norte
             * se incrementa el numero de coches*/
            nroCochesPasandoNorte++;
            /** despierta si hay otro coche esperando*/
            okNorte.signal();
        } finally {
            bloqueador.unlock();
        }
    }

    public void salirPuenteDelSur() throws  InterruptedException{
        bloqueador.lock();
        try {
            nroCochesPasandoSur--;
            if (nroCochesPasandoSur==0){
                okNorte.signal();
            }
        }finally {
            bloqueador.unlock();
        }
    }

    public void salirPuenteDelNorte() throws  InterruptedException{
        bloqueador.lock();
        try {
            nroCochesPasandoNorte--;
            if (nroCochesPasandoNorte==0){
                okSur.signal();
            }
        }finally {
            bloqueador.unlock();
        }
    }

}
