package Spielerclass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Spielfläche extends JPanel {
    Spieler spieler;
    ArrayList<Barrriere> barrierik = new ArrayList<Barrriere>();

    private long LastTime;
    private int frames;

    public Thread gameloop;

    public Spielfläche(){
        setPreferredSize(new Dimension(400,400));
        setBackground(Color.LIGHT_GRAY);

        //Erstellung unserer Barrieren
        spieler = new Spieler(200, 20, 400, 20, 20);
        barrierik.add(new Barrriere(0, 100, 40, 10, 400, 5));
        barrierik.add(new Barrriere(80, 100, 40, 10, 400, 5));
        barrierik.add(new Barrriere(160, 100, 40, 10, 400, 5));
        barrierik.add(new Barrriere(240, 100, 90, 10, 400, 5));


        gameloop = new Thread(this::run);
        gameloop.start();

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    spieler.moveLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    spieler.moveRight();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    spieler.moveUp();
                } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    spieler.moveDown(10);
                }
                repaint();
            }
        });
        setFocusable(true);
    }

    //Gameloop
    public void run() {
        final int TARGET_FPS = 60;
        final long optimalTime = 1000000000 / TARGET_FPS;
        float fallSpeed = 40;


        while (true){
            long startTime = System.nanoTime();
            // Berechnung der Gravity des Spielers
            if(spieler.inAir()){
                spieler.moveDown(fallSpeed / TARGET_FPS);
            }
            for (Barrriere barrriere : barrierik){
                barrriere.moveLeft();
            }

            repaint();

            // Aktuelle Systemzeit - letzte Systemzeit
            long remainingTime = optimalTime - (System.nanoTime() - startTime);
            try {
                Thread.sleep((remainingTime / 1000000) - 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paintComponent (Graphics graphics){
        super.paintComponent(graphics);
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0, 0, 400, 400);
        graphics.setColor(Color.RED);
        graphics.fillRect((int) spieler.getxPos(), (int) spieler.getyPos(), 20, 20);
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < barrierik.size(); i++){
            graphics.fillRect(barrierik.get(i).getxPos_barr(),barrierik.get(i).getyPos_barr(), barrierik.get(i).getWidth_barr(), barrierik.get(i).getHeight_barr());
        }
        callFps();
    }

    // FPS Anzahl
    private void callFps(){
        frames++;
        if (System.nanoTime() - LastTime >= 1000000000){
            System.out.println("FPS: " + frames);
            frames = 0;
            LastTime = System.nanoTime();
        }
    }
}
