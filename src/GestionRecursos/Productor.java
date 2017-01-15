package GestionRecursos;

/**
 * Created by hammer on 28/12/16.
 */
public class Productor extends Thread {
    GestorRecursos gestorRecursos;

    public Productor(GestorRecursos gestorRecursos) {
        this.gestorRecursos = gestorRecursos;
    }

    public GestorRecursos getGestorRecursos() {
        return gestorRecursos;
    }

    public void setGestorRecursos(GestorRecursos gestorRecursos) {
        this.gestorRecursos = gestorRecursos;
    }
    public void run() {
        try {
            this.gestorRecursos.producir();
            System.out.println("Productor : "
                    + super.getName()
                    + " "
                    + this.gestorRecursos.getBuffer()
            );

            sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
