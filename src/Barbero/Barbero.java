package Barbero;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by hammer on 27/01/17.
 */
public class Barbero extends Thread {
    /**
     * atributos
     */
    MBarbero mBarbero;

    Image imagen = Toolkit.getDefaultToolkit().getImage("/home/hammer/IdeaProjects/Labos Segunda Parcial/src/Barbero/statics/dormido.gif");
    JPanel contendor;
    int cX;
    int cY;
    Graphics g;
    // ImageObserver imgObserver;

    public Barbero(Graphics g,
                   MBarbero mBarbero, JPanel contendor,
                   int cX, int cY) {
        this.g = g;
        this.mBarbero = mBarbero;
        this.contendor = contendor;
        this.cX = cX;
        this.cY = cY;
        //    this.imgObserver = imgObserver;
    }

    @Override
    public void run() {

        try {
            boolean flag = true;
            while (flag) {
                System.out.println("Cojer cliente ");
                mBarbero.cojerCliente(getName());
                sleep(1000);
                System.out.println("Sillas ocupadas : " + mBarbero.sillasOcupadas);
                if (mBarbero.dormido) {
                    cambiarABarberoDormilon();
                } else {
                    cambiarABarberoDespierto();
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void cambiarABarberoDormilon() {
        /** cambiamos de estado al barbero*/
        setBarberoDormilon();
        getContendor().repaint();
    }

    private void cambiarABarberoDespierto() {
        setBarberdoDespierto();
        getContendor().repaint();
        System.out.println("Barbero despierto " +
                imagen.toString());

    }

    private void setBarberoDormilon() {
        this.imagen = Toolkit.getDefaultToolkit().getImage("/home/hammer/IdeaProjects/Labos Segunda Parcial/src/Barbero/statics/dormido.gif");
    }

    private void setBarberdoDespierto() {
        this.imagen = Toolkit.getDefaultToolkit().getImage("/home/hammer/IdeaProjects/Labos Segunda Parcial/src/Barbero/statics/barbero.gif");
    }

    public MBarbero getmBarbero() {
        return mBarbero;
    }

    public void setmBarbero(MBarbero mBarbero) {
        this.mBarbero = mBarbero;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public JPanel getContendor() {
        return contendor;
    }

    public void setContendor(JPanel contendor) {
        this.contendor = contendor;
    }

    public int getcX() {
        return cX;
    }

    public void setcX(int cX) {
        this.cX = cX;
    }

    public int getcY() {
        return cY;
    }

    public void setcY(int cY) {
        this.cY = cY;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }
}
