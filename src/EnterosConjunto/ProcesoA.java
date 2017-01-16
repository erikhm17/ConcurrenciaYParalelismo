package EnterosConjunto;

import csp.lang.Thread;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * Created by hammer on 14/01/17.
 */
/* Implementamos Procces de la libreria CTJ */
public class ProcesoA implements Runnable {
    /**
     * creamos una cola bloqueante, para poner los enteros
     */
    private BlockingQueue<MyMap> buzonSincrono;
    /**
     * una lista de Enteros
     */
    ArrayList<MyMap> S = new ArrayList<>();

    public ProcesoA(BlockingQueue<MyMap> buzon, ArrayList<MyMap> S) {
        this.buzonSincrono = buzon;
        this.S = S;
    }

    public MyMap getMayor(ArrayList<MyMap> T) {
        MyMap mayor = T.get(0);

        for (int i = 1; i < T.size(); i++) {
            MyMap value = T.get(i);
            if (mayor.getValor() <= value.getValor()) {
                mayor = new MyMap(value.getClave(), value.getValor());
            }
        }
        return mayor;
    }

    public int getIndex(MyMap myMap) {
        int j = 0;
        for (int i = 0; i < this.S.size(); i++) {
            if (myMap.getValor() == S.get(i).getValor()) {
                j = i;
            }
        }
        return j;
    }

    @Override
    public void run() {
        /* recupero en cada ciclo el mensaje en cada elemento de la
        * lista */
        try {
            for (MyMap s : S) {
                MyMap mayor = getMayor(S);
                System.out.println("Enviar el mayor : " + mayor.getValor());
                buzonSincrono.put(mayor);

                MyMap data = null;

                if ((data = buzonSincrono.take()).getClave() != Main.infinito) {
                    S.get(getIndex(mayor)).setValor(data.getValor());

                    System.out.println("Asigno en el indice de S " + getIndex(mayor) +
                            "el valor : " + data.getValor());
                    for (MyMap s1 : S) {
                        System.out.println("Clave : " + s1.getClave() + " Valor : " + s1.getValor());
                    }
                    System.out.println("##################################################################");
                }

            }
            System.out.println("Salio del bucle en A ");
            buzonSincrono.put(new MyMap(Main.infinito, Main.infinito));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
