package Barbero;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hammer on 28/01/17.
 */
public class Cliente extends Thread {
    MBarbero mBarbero;

    Image imagen = Toolkit.getDefaultToolkit().getImage("/home/hammer/IdeaProjects/Labos Segunda Parcial/src/Barbero/statics/persona2.png");
    JPanel contendor;
    int coordenadaX;
    int coordenadaY;
    Graphics g;


    public Cliente(Graphics g,
                   MBarbero mBarbero, JPanel contendor,
                   int cX, int cY) {
        this.g = g;
        this.mBarbero = mBarbero;
        this.contendor = contendor;
        this.coordenadaX = cX;
        this.coordenadaY = cY;
    }


    @Override
    public void run() {
        /* no hay while*/
        avanzar();
    }

    private void avanzar() {
        Thread hilo = new Thread(() -> {
            try {
                boolean flag = true;
                while (flag) {
                    //mBarbero.pedirCorte(getName());
                    sleep(10);
                    if (entroASalaDeEspera()) {
                        if (mBarbero.dormido) {
                            System.out.println("pedir corte ");
                            mBarbero.pedirCorte(getName());
                            /** aqui ya sabe que el barbero se durmio */
                            entrarDirecto();
                        } else {
                            sentarseEnSalaDeEspera();
                        }
                        flag = false;
                    } else {
                        caminarCliente();
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        hilo.start();

    }

    private void entrarDirecto() {
        Thread entrar = new Thread(() -> {
            boolean flag = true;
            while (flag) {
                if (entroASalaDeAtencion()) {
                    /** entro a la sala de atencion*/
                    sentarseEnSalaDeAtencion();
                    flag = false;
                } else {
                    caminarCliente();
                }
            }
        });
        entrar.start();
    }

    public void caminarCliente() {
        /** reducimos la coordenada */
        coordenadaX--;
        getContendor().repaint();
        //  System.out.println("Ingresa un cliente ");
    }

    /**
     * inicialmente esta en false
     */


    public void sentarseEnSalaDeAtencion() {
        coordenadaX = 100;
        coordenadaY = 250;
    }

    public int buscarAsientoLibre() {
        for (int i = 0; i < Main.coordenadas.length; i++) {
            if (!Main.coordenadas[i].isOcupado()) {
                System.err.println("Asiento libre : " + i);
                return i;
            }
        }
        return -1;
    }

    public void sentarseEnSalaDeEspera() {
        System.out.println("Colocando a los asientos , coordenada X " +
                coordenadaX);
        {
            /** verifico que asientos hay libres para colocar
             * un punto del asiento */
            System.err.println(buscarAsientoLibre());
            if (buscarAsientoLibre() != -1) {
                if (!Main.coordenadas[buscarAsientoLibre()].isOcupado()) {
                    coordenadaX = Main.coordenadas[buscarAsientoLibre()].getX();
                    coordenadaY = Main.coordenadas[buscarAsientoLibre()].getY();
                    Main.coordenadas[buscarAsientoLibre()].setOcupado(true);
                }
            }


        }
    }

    public boolean entroASalaDeEspera() {
        return (coordenadaX < 1000);
    }

    public boolean entroASalaDeAtencion() {
        return (coordenadaX < 260);
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

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }
}
