package EnterosConjunto.Graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hammer on 16/01/17.
 */
public class Numero extends MyMap {
    private int coordenadaX;
    private int coordenadaY;
    private Graphics g;
    private JPanel panel;

    public Numero(int clave, int valor, int coordenadaX, int coordenadaY, Graphics g, JPanel panel) {
        super(clave, valor);
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.g = g;
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public void avanzar() {
        coordenadaX = coordenadaX + 10;
        getPanel().repaint();
    }
}
