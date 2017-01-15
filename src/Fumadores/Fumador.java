package Fumadores;

/**
 * Created by hammer on 03/01/17.
 */
public class Fumador extends Thread {
    private int id;
    private SalaFumadores sala;

    public Fumador(int id, SalaFumadores sala) {
        this.id = id;
        this.sala = sala;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sala.entrarFumar(id);
                System.out.println("Fumador " + id + " Esta fumando ");
                Thread.sleep(1000);
                sala.terminarFumar(id);
            }catch (InterruptedException e){}
        }
    }
}
