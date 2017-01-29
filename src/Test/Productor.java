package Test;

/**
 * Created by hammer on 28/01/17.
 */
public class Productor extends Thread {
    MSincronizacion mSincronizacion = new MSincronizacion();

    public Productor(MSincronizacion mSincronizacion) {
        this.mSincronizacion = mSincronizacion;
    }

    @Override
    public void run() {
        try {
            mSincronizacion.producir(getName());
            //sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
