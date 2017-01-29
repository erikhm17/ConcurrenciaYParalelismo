package SincronizacionMonitores;

/**
 * Created by hammer on 28/01/17.
 */
public class Consumidor extends Thread {
    MSincronizacion mSincronizacion = new MSincronizacion();

    public Consumidor(MSincronizacion mSincronizacion) {
        this.mSincronizacion = mSincronizacion;
    }

    @Override
    public void run() {
            try {
                mSincronizacion.consumir(getName());
                //sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
