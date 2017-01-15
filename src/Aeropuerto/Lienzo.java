/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aeropuerto;


import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Erik
 */
public class Lienzo extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form Lienzo
     */
    public static ArrayList<AvionAire> avionAires = new ArrayList<>();
    public static ArrayList<AvionEmergencia> avionEmergencias = new ArrayList<>();
    public static ArrayList<AvionSuperficie> avionSuperficie = new ArrayList<>();


    MonitorTorre monitorPuente = new MonitorTorre();

    ArrayList<Color> colores;

    public Lienzo() {
        initComponents();

        colores = new ArrayList<>();
        colores.add(Color.BLACK);
        colores.add(Color.BLUE);
        colores.add(Color.YELLOW);
        colores.add(Color.CYAN);
        colores.add(Color.DARK_GRAY);
        colores.add(Color.GREEN);
        colores.add(Color.LIGHT_GRAY);
        colores.add(Color.ORANGE);
        colores.add(Color.RED);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 942, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 518, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void paint(Graphics g) {
        /* color del fondo*/
        g.setColor(new Color(246, 236, 236));
        /* tamaño del fondo*/
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.DARK_GRAY);
        g.fillRect(10, 260, 1000, 10);
        g.fillRect(10, 310, 1000, 10);
        /**
         *  (X,Y,Ancho,Alto)
         * */
        g.fillRect(10, 360, 1000, 10);


         /* dibujando Aviones */
        for (int i = 0; i < avionAires.size(); i++) {
            avionAires.get(i).setGraphics(g);
            avionAires.get(i).getGraphics().setColor(avionAires.get(i).getColor());
            g.fillOval(avionAires.get(i).getCordenadaX(),
                    avionAires.get(i).getCordenadaY(),
                    30, 30);
        }
        for (int i = 0; i < avionEmergencias.size(); i++) {
            avionEmergencias.get(i).setGraphics(g);
            avionEmergencias.get(i).getGraphics().setColor(Color.RED);
            g.fillOval(avionEmergencias.get(i).getCordenadaX(),
                    avionEmergencias.get(i).getCordenadaY(),
                    30, 30);
        }
        for (int i = 0; i < avionSuperficie.size(); i++) {
            avionSuperficie.get(i).setGraphics(g);
            avionSuperficie.get(i).getGraphics().setColor(avionSuperficie.get(i).getColor());
            g.fillOval(avionSuperficie.get(i).getCordenadaX(),
                    avionSuperficie.get(i).getCordenadaY(),
                    30, 30);
        }

    }

    public void generarAvionAire(int i) {
        avionAires.add(new AvionAire(monitorPuente,
                0,
                this,
                null,
                10,// coordenada X
                600,// coordenada Y
                15,//delay
                colores.get((int) (Math.random() * colores.size()))
        ));

        avionAires.get(i).start();

    }

    public void generarAvionSuperficie(int i) {
        avionSuperficie.add(new AvionSuperficie(monitorPuente,
                0,
                this,
                null,
                850,// coordenada X
                325,// coordenada Y
                15,//delay
                colores.get((int) (Math.random() * colores.size()))
        ));

        avionSuperficie.get(i).start();

    }

    public void generarAvionEmergencia(int i) {
        avionEmergencias.add(new AvionEmergencia(monitorPuente,
                0,
                this,
                null,
                0,// coordenada X
                0,// coordenada Y
                15,//delay
                colores.get((int) (Math.random() * colores.size()))
        ));
        avionEmergencias.get(i).start();
    }

    Thread generadorAvionesAire = new Thread(() -> {
        int i = 0;
        while (true) {
            try {
                repaint();
                generarAvionAire(i);
                Thread.sleep(25000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    Thread generadorAvionesSuperficie = new Thread(() -> {
        int i = 0;
        while (true) {
            try {
                repaint();
                generarAvionSuperficie(i);
                Thread.sleep(20000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    Thread generadorAvionesEmergencia = new Thread(() -> {
        int i = 0;
        while (true) {
            try {
                repaint();
                generarAvionEmergencia(i);
                Thread.sleep(35000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    @Override
    public void run() {
        generadorAvionesEmergencia.start();
        generadorAvionesAire.start();
        generadorAvionesSuperficie.start();
    }

}
