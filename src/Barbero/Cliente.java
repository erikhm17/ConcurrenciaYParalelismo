package Barbero;

/**
 * Created by hammer on 28/01/17.
 */
public class Cliente extends Thread {
    MBarbero mBarbero;

    public Cliente(MBarbero mBarbero) {
        this.mBarbero = mBarbero;
    }

    @Override
    public void run() {
        try {
            mBarbero.pedirCorte(getName());
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
