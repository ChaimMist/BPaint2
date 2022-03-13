import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static JFrame frame = new JFrame();
    public static void main(String[] args) {
        new Main();
    }
    public Main(){

        frame.setTitle("(!)Paint Brush(!)");
        frame.setBounds(5000, 5000, 10000, 10000);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(255,255,255));
        new Menu();


    }
}
