package GestionRecursos;

import java.util.ArrayList;

/**
 * Created by hammer on 28/12/16.
 */
public class AppGestionRecursos {
    public static void main(String [] args){

        Thread hiloGenerador = new Thread(() -> {
            GestorRecursos gestorRecursos = new GestorRecursos();
            ArrayList<Productor> productores = new ArrayList<>();
            ArrayList<Consumidor> consumidores = new ArrayList<>();
            int i = 0;
            while (true){
                try {
                    Productor p = new Productor(gestorRecursos);
                    Consumidor c = new Consumidor(gestorRecursos);
                    productores.add(p);
                    consumidores.add(c);
                    p.setName("Productor "+i);
                    c.setName("Consumidor "+i);

                    productores.get(i).start();
                    consumidores.get(i).start();

                    i++;
                    Thread.sleep(1300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        hiloGenerador.start();

    }



}
