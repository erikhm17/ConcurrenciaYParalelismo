package Aeropuerto;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by hammer on 31/12/16.
 */
public class AvionEmergencia extends Thread {
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

    public AvionEmergencia(MonitorTorre monitorTorre) {
        this.monitorTorre = monitorTorre;
    }

    public AvionEmergencia(MonitorTorre monitorTorre, int index,
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

    private void avanzar() {
        if (coordenadaY > 275) {
            coordenadaX = coordenadaX + 1;
            getPanel().repaint();
            return;
        }
        coordenadaX = coordenadaX + 1;
        coordenadaY = coordenadaY + 1;
        getPanel().repaint();
    }
    private void detener(){
        coordenadaX = 750;
    }
    public void run() {

        while (true) {
            try {
                monitorTorre.alertaRoja(getName());
                while (monitorTorre.isOcu()) {
                    if (coordenadaX >= 600) {
                        /** Ya llego solo falta confirmar*/
                        monitorTorre.confirmarAterrizado(getName());
                        //detener();
                        coordenadaX = 3000;
                        sleep(delay);
                    } else {
                        avanzar();
                        sleep(delay);
                    }

                }
            /*

            sleep((long) Math.random() * 1000);

            */
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
