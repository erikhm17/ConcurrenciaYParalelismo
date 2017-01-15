package Antropofago;

import Aeropuerto.MonitorTorre;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hammer on 31/12/16.
 */
public class Antropofago extends Thread {
    MAntropofago mAntropofago;

    /**
     * Atributos
     */
    private Color color;
    /* default*/
    private int coordenadaX;
    private int coordenadaY;
    private JPanel panel;
    private Graphics graphics;
    private int index;
    /* delay*/
    private int delay;

    public Antropofago(MAntropofago mAntropofago) {
        this.mAntropofago = mAntropofago;
    }

    public Antropofago(MAntropofago mAntropofago, int index,
                       JPanel panel,
                       Graphics graphics,
                       int coordenadaX,
                       int coordenadaY,
                       int delay,
                       Color color) {
        this.mAntropofago = mAntropofago;
        this.panel = panel;
        this.graphics = graphics;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.index = index;
        this.delay = delay;
        this.color = color;

    }

    public Color getColor() {
        return color;
    }


    public int getCordenadaX() {
        return coordenadaX;
    }


    public int getCordenadaY() {
        return coordenadaY;
    }


    public JPanel getPanel() {
        return panel;
    }


    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    private void avanzar() {
        coordenadaX = coordenadaX + 1;
        getPanel().repaint();
    }

    public void run() {
        while (true) {
            try {
                this.mAntropofago.ComerMisionero(getName());
                while (this.mAntropofago.getNumeroMisioneros() != 0) {
                    avanzar();
                    sleep(delay);
                }
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
