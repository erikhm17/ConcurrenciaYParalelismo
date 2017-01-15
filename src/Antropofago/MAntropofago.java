package Antropofago;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hammer on 31/12/16.
 */
public class MAntropofago {
    final ReentrantLock bloqueador = new ReentrantLock();
    final Condition okCocinero = bloqueador.newCondition();
    final Condition okAntropofago = bloqueador.newCondition();
    int nroMisionerosEnOlla = 5;

    public void ComerMisionero(String nombre) throws InterruptedException {
        bloqueador.lock();
        while (nroMisionerosEnOlla == 0) {
            System.out.println(" Espera cocinero y Reanuda antropofago " + nombre);
            okCocinero.signal();
            okAntropofago.await();
        }
        /** Sacar Misionero */
        nroMisionerosEnOlla = nroMisionerosEnOlla - 1;
        okAntropofago.signal();
        System.out.println(" Comer misionero " + nombre);
        bloqueador.unlock();
    }

    public void rellenarOlla(String nombre) throws InterruptedException {
        bloqueador.lock();
        if (nroMisionerosEnOlla != 0) {
            actulizarNumeroDeMisioneros();
            okCocinero.await();
            System.out.println("Cocinero en espera " + nombre);
        }

        /** Rellenar olla */
        nroMisionerosEnOlla = 5;
        okAntropofago.signal();
        System.out.println("Rellenar olla con 5 misioneros " + nombre);
        bloqueador.unlock();
    }

    public  void actulizarNumeroDeMisioneros() {
        nroMisionerosEnOlla = 5;
    }

    public  int getNumeroMisioneros() {
        return nroMisionerosEnOlla;
    }

}
