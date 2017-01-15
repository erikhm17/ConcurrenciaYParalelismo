package Fumadores;

import java.util.Random;

/**
 * Created by hammer on 03/01/17.
 */
public class Agente extends Thread {
    private SalaFumadores sala;
    private Random r; /* generador de numeros aleatorios */

    public Agente(SalaFumadores sala) {
        this.sala = sala;
        r = new Random();
    }

    @Override
    public void run() {
        while (true) {
            sala.colocar(r.nextInt(3) + 1);
        }
    }
}
