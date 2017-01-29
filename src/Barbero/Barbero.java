package Barbero;

import javax.swing.*;

/**
 * Created by hammer on 27/01/17.
 */
public class Barbero extends Thread {
    /** atributos */
    MBarbero mBarbero;

    JPanel contendor;
    int cX;
    int cY;

    public Barbero(MBarbero barbero) {

        this.mBarbero = barbero;
    }

    @Override
    public void run() {

        try {
            while (true) {
                mBarbero.cojerCliente(getName());
                sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
