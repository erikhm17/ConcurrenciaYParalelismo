package Aeropuerto;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hammer on 31/12/16.
 */
public class AvionAire extends Thread {
    MonitorTorre monitorTorre;

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

    public AvionAire(MonitorTorre monitorTorre) {
        this.monitorTorre = monitorTorre;
    }

    public AvionAire(MonitorTorre monitorTorre, int index,
                     JPanel panel,
                     Graphics graphics,
                     int coordenadaX,
                     int coordenadaY,
                     int delay,
                     Color color) {
        this.monitorTorre = monitorTorre;
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

    private void aterrizarDiagonal() {
        coordenadaX = coordenadaX + 1;
        coordenadaY = coordenadaY - 1;
        getPanel().repaint();
    }

    private void avanzar() {
        coordenadaX = coordenadaX + 1;
        getPanel().repaint();
    }

    public void run() {
        while (true) {
            try {
                monitorTorre.pedirAterrizaje(getName());

                while (monitorTorre.isOcu()) {
                    if (coordenadaY <= 310) {
                        monitorTorre.confirmarAterrizado(getName());
//                        avanzar();
                        coordenadaX = 3000;
                        sleep(delay);
                    } else {
                        aterrizarDiagonal();
                        sleep(delay);
                    }
                }
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
