package EnterosConjunto.Graphics;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * Created by hammer on 14/01/17.
 */
public class ProcesoB implements Runnable {
    /**
     * Creamos una cola bloqueante
     */
    private BlockingQueue<MyMap> buzonSincrono;
    ArrayList<MyMap> T = new ArrayList<>();

    public ProcesoB(BlockingQueue<MyMap> buzonSincrono,
                    ArrayList<MyMap> T) {

        this.buzonSincrono = buzonSincrono;
        this.T = T;
    }

    public MyMap getMenor(ArrayList<MyMap> T) {
        MyMap menor = T.get(0);
        for (int i = 1; i < T.size(); i++) {
            MyMap value = T.get(i);

            if (menor.getValor() >= value.getValor()) {
                menor = new MyMap(value.getClave(), value.getValor());
            }
        }
        return menor;
    }

    public int getIndex(MyMap myMap) {
        int j = 0;
        for (int i = 0; i < this.T.size(); i++) {
            if (myMap.getValor() == T.get(i).getValor()) {
                j = i;
            }
        }
        return j;
    }

    @Override
    public void run() {
        try {
            MyMap data = null;

            while ((data = buzonSincrono.take()).getClave() != MainConsole.infinito) {
                System.out.println("Recupero el dato enviado por A : " + data.getValor());
                MyMap auxData = new MyMap(data.getClave(), data.getValor());
                MyMap menor = getMenor(T);
                MyMap auxMenor = new MyMap(menor.getClave(), menor.getValor());

                System.out.println("El menor de T es : " + menor.getValor());

                if (data.getValor() >= menor.getValor()) {
                    System.out.println("Intercambio datos en el arreglo T  " + data.getValor() + " indice : "
                            + getIndex(menor));
                    T.get(getIndex(menor)).setValor(data.getValor());
                    System.out.println("Envio a A el menor : " + auxMenor.getValor());
                    buzonSincrono.put(auxMenor);

                } else {
                    buzonSincrono.put(auxData);
                }
            }
            System.out.println("Escribiendo el arreglo T ");
            for (int i = 0; i < T.size(); i++) {
                System.out.println("clave: " + T.get(i).getClave() + " valor : " + T.get(i).getValor());
            }

        } catch (InterruptedException intEx) {
            System.out.println(" Opps, paso algo interrupido ");
        }
    }
}
