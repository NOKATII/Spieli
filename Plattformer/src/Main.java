import Spielerclass.Spielfläche;

import javax.swing.*;
import java.awt.event.WindowAdapter;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Spielflaeche");
        frame.add(new Spielfläche());
        frame.setSize(400,428);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}



