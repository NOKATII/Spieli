package Spielerclass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Spielfläche extends JPanel {
    Spieler spieler;

    public Spielfläche(){
        setPreferredSize(new Dimension(400,400));
        setBackground(Color.LIGHT_GRAY);
        spieler = new Spieler(200, 200, 400, 20);

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    spieler.moveLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    spieler.moveRight();
                } else spieler.moveUp();
                repaint();
            }
        });
        setFocusable(true);
    }

    public void paintComponent (Graphics graphics){
        super.paintComponent(graphics);
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0, 0, 400, 400);
        graphics.setColor(Color.RED);
        graphics.fillRect(spieler.getxPos(), spieler.getyPos(), 20, 20);

    }
}
