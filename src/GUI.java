import javax.swing.*;
import java.awt.*;

public class GUI {
    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Try yourself");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //BorderLayout
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());





        //Tamaño, titulo centrado y visible
        //frame.setSize(800, 400);
        frame.setPreferredSize(new Dimension(1000, 500));

        frame.pack();
        frame.setLocationRelativeTo(null);


        frame.setVisible(true);
    }
}
