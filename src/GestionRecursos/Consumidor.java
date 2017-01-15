package GestionRecursos;

/**
 * Created by hammer on 28/12/16.
 */
public class Consumidor extends Thread {
    GestorRecursos gestorRecursos;

    public Consumidor(GestorRecursos gestorRecursos) {
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
            this.gestorRecursos.consumir();
            System.out.println("Consumidor : "
                    + super.getName()
                    + " " + this.gestorRecursos.getBuffer()
            );
            sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
