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

        //--------Panel de los botones de los juegos del hambre--------
        JPanel northPanel = new JPanel();
        northPanel.add(new JCheckBox("Katniss"));
        northPanel.add(new JCheckBox("Peeta"));
        container.add(northPanel, BorderLayout.NORTH);

        //--------Panel de la imagen--------
        JPanel centerPanel = new JPanel(new GridLayout(2, 2));
        ImageIcon icon = new ImageIcon("img/flores.jpg");

        //4 imagenes
        for (int i = 0; i < 4; i++) {
            centerPanel.add(new JLabel(icon));
        }
        container.add(centerPanel, BorderLayout.CENTER);





        //Tamaño, titulo centrado y visible
        //frame.setSize(800, 400);
        frame.setPreferredSize(new Dimension(1000, 500));

        frame.pack();
        frame.setLocationRelativeTo(null);


        frame.setVisible(true);
    }
}
