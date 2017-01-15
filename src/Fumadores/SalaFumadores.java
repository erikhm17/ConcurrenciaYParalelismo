package Fumadores;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hammer on 03/01/17.
 */
public class SalaFumadores {
    static int mesa;
    static Lock l;
    static Condition[] puedoFumar;
    static Boolean alguienFuma;
    static Condition puedoColocar;

    public SalaFumadores() {
        l = new ReentrantLock();
        puedoFumar = new Condition[3];
        puedoFumar[0] = l.newCondition();
        puedoFumar[1] = l.newCondition();
        puedoFumar[2] = l.newCondition();
        puedoColocar = l.newCondition();
        mesa = 0;
        alguienFuma = false;
    }

    public void entrarFumar(int id) {
        l.lock();
        try {
            while (mesa != id || alguienFuma) {
                try {
                    puedoFumar[id - 1].await();
                } catch (InterruptedException e) {

                }
            }
            /** ya puedo fumar*/
            mesa = 0;
            alguienFuma = true;

        } finally {
            l.unlock();
        }
    }

    public void terminarFumar(int id) {
        l.lock();
        try {
            alguienFuma = false;
            puedoColocar.signal();
        } finally {
            l.unlock();
        }
    }

    public void colocar(int ingredientes) {
        l.lock();
        try {
            while (mesa != 0 || alguienFuma) {
                try {
                    puedoColocar.await();
                } catch (InterruptedException e){

                }
            }
            mesa = ingredientes;
            System.out.println("En la mesa falta el ingrediente"+mesa);
            puedoFumar[mesa-1].signal();
        }finally {
            l.unlock();
        }
    }

}
