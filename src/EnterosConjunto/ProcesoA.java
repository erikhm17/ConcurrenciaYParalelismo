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
                mayor = value;
                mayor.setIndice(i);
            }
        }
        return mayor;
    }

    @Override
    public void run() {
        /* recupero en cada ciclo el mensaje en cada elemento de la
        * lista */
        try {
            int x = 0;
            for (MyMap s : S) {
                MyMap mayor = getMayor(S);
                System.out.println("Enviar el mayor : " + mayor.getValor());
                buzonSincrono.put(mayor);

                MyMap data = buzonSincrono.take();
                System.out.println("Recupero de B : " + data.getValor());
                if (data.getClave() != -1) {
                    System.out.println("Intecambio valores en S " + data.getValor() +
                            " en el indice " + mayor.getIndice());

                    s.setValor(data.getValor());
                    System.out.println(" el objeto s ahora tiene el valor : " + s.getValor());
                    S.get(mayor.getIndice()).setValor(data.getValor());
                    System.out.println("Asigno en el indice de S " + mayor.getIndice() +
                            "el valor : " + data.getValor());
                }

                x++;
            }
            System.out.println("Salio del bucle en A ");
            buzonSincrono.put(new MyMap(-1, -1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
