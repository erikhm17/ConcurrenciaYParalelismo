package Barbero;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hammer on 27/01/17.
 */
public class Main {
    static Coordenada[] coordenadas = new Coordenada[]{
            new Coordenada(340, 320, false),
            new Coordenada(480, 310, false),
            new Coordenada(600, 300, false),
            new Coordenada(700, 300, false),
            new Coordenada(730, 360, false),
            new Coordenada(840, 400, false)
    };

    public static void main(String[] args) {


        JFrame frame = new JFrame();
        Container contentPane = frame.getContentPane();
        //contentPane.setLayout(new FlowLayout());
        /* panel */
        JPanel panel = new PanelCanvas();
        frame.add(panel);
        frame.setSize(1280, 720);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Thread hilo = new Thread((Runnable) panel);
        hilo.start();



      /*  MBarbero mBarbero = new MBarbero();
        Barbero barbero = new Barbero(mBarbero);
        barbero.setName("Barbero");
        barbero.start();

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        for (int i = 0; i < 10; i++) {
            Cliente c = new Cliente(mBarbero);
            c.setName("Cliente " + i);
            clientes.add(c);

        }
        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).start();
        }
*/
    }
}
