package PuenteEstrecho;

import Barbero.Cliente;
import Barbero.MBarbero;
import Barbero.Barbero;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hammer on 28/01/17.
 */
public class Main {
    public static void main(String[] args) {
        MBarbero mBarbero = new MBarbero();
        Barbero barbero = new Barbero(mBarbero);
        Cliente cliente1 = new Cliente(mBarbero);
        Cliente cliente2 = new Cliente(mBarbero);
        Cliente cliente3 = new Cliente(mBarbero);
        Cliente cliente4 = new Cliente(mBarbero);
        Cliente cliente5 = new Cliente(mBarbero);
        Cliente cliente6 = new Cliente(mBarbero);
        Cliente cliente7 = new Cliente(mBarbero);
        Cliente cliente8 = new Cliente(mBarbero);
        Cliente cliente9 = new Cliente(mBarbero);
        Cliente cliente10 = new Cliente(mBarbero);

        barbero.start();
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        cliente6.start();
        cliente7.start();
        cliente8.start();
        cliente9.start();
        cliente10.start();
    }
}
