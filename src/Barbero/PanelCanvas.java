package Barbero;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by hammer on 27/01/17.
 */
public class PanelCanvas extends JPanel implements Runnable {
    private Image fondo = Toolkit.getDefaultToolkit().getImage("/home/hammer/IdeaProjects/Labos Segunda Parcial/src/Barbero/statics/background.jpg");


    private MBarbero mBarbero = new MBarbero();
    private Barbero barbero;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public PanelCanvas() {
        this.setSize(1280, 720);
        JButton boton = new JButton("Hola mundo");
        this.add(boton);
        this.setBackground(Color.GRAY);
        barbero = new Barbero(null, mBarbero,
                this, 10, 10);
        iniciarBarbero();
        //iniciarClientes();
    }


    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 10, 10, this);

        barbero.setG(g);
        g.drawImage(barbero.getImagen(), barbero.getcX(),
                barbero.getcY(), this);

        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).setG(g);
            g.drawImage(clientes.get(i).getImagen(),
                    clientes.get(i).getCoordenadaX(),
                    clientes.get(i).getCoordenadaY(), this);
        }

        /*c.setG(g);
        g.drawImage(c.getImagen(),
                c.getCoordenadaX(),
                c.getCoordenadaY(), this);
            */
        g.fillOval(100, 250, 20, 20);
    }

    @Override
    public void run() {
        generarClienteThread.start();
    }

    Thread generarClienteThread = new Thread(() -> {
        int i = 0;
        while (true) {
            try {
                repaint();
                iniciarClientes(i);
                Thread.sleep(1000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    public void iniciarBarbero() {
        barbero.start();
    }

    Cliente c;

    public void iniciarClientes(int i) {
        c = new Cliente(null, mBarbero,
                this, 1200, 350);
        clientes.add(c);
        clientes.get(i).start();
    }
}

