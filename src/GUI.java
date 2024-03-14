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

        //--------Panel de los botones--------
        JPanel eastPanel = new JPanel(null);
        eastPanel.setPreferredSize(new Dimension(250, 0));

        //Creo grupo de botones
        ButtonGroup botones = new ButtonGroup();

        //Creo array de botones
        JRadioButton[] boton=new JRadioButton[3];

        //Creo los botones que habrá que añadir al array
        JRadioButton boton1 = new JRadioButton("OPT1");
        JRadioButton boton2 = new JRadioButton("OPT2");
        JRadioButton boton3 = new JRadioButton("OPT3");

        //Añado los botones al array
        boton[0]=boton1;
        boton[1]=boton2;
        boton[2]=boton3;

        //Añado los botones del array al grupo de botones
        botones.add(boton[0]);
        botones.add(boton[1]);
        botones.add(boton[2]);

        //le doy posicion a los botones
        boton[0].setBounds(10, 100, 100, 30);
        boton[1].setBounds(10, 130, 100, 30);
        boton[2].setBounds(10, 160, 100, 30);

        //Añado los botones al panel
        eastPanel.add(boton[0]);
        eastPanel.add(boton[1]);
        eastPanel.add(boton[2]);

        //Pongo el primer boton como seleccionado
        botones.setSelected(boton[0].getModel(),true);

        container.add(eastPanel, BorderLayout.EAST);

        /*
        //Añadir RadioButtons al grupo
        botones.add(boton1);
        botones.add(boton2);
        botones.add(boton3);
        boton1.setBounds(10, 100, 100, 30);
        boton2.setBounds(10, 130, 100, 30);
        boton3.setBounds(10, 160, 100, 30);

        //Añadir RadioButtons al panel
        eastPanel.add(boton1);
        eastPanel.add(boton2);
        eastPanel.add(boton3);
        container.add(eastPanel, BorderLayout.EAST);

         */

        //--------Panel de los botones de abajo--------
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.add(new JButton("But 1"));
        southPanel.add(new JButton("But 2"));
        southPanel.setPreferredSize(new Dimension(0,50));
        container.add(southPanel, BorderLayout.SOUTH);

        //Tamaño, titulo centrado y visible
        //frame.setSize(800, 400);
        frame.setPreferredSize(new Dimension(1000, 500));

        frame.pack();
        frame.setLocationRelativeTo(null);


        frame.setVisible(true);
    }
}
