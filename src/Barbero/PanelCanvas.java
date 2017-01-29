package Barbero;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hammer on 27/01/17.
 */
public class PanelCanvas extends JPanel {
    private Image img = Toolkit.getDefaultToolkit().createImage("background.jpg");
    JLabel olla1 = new JLabel();

    public PanelCanvas() {
        this.setSize(1280, 720);
        JButton boton = new JButton("Hola mundo");
        this.add(boton);
        this.setBackground(Color.GRAY);
        this.add(olla1);
    }

    @Override
    public void paint(Graphics g) {
        Image img1 = Toolkit.getDefaultToolkit().getImage("/home/hammer/IdeaProjects/Labos Segunda Parcial/src/Barbero/statics/background.jpg");
        g.drawImage(img1,10,10,this);

        g.finalize();

    }

    public void setBackgroundImage() {
        olla1.setIcon(new ImageIcon("statics/background.jpg"));
    }
}

