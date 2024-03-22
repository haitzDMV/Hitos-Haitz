package Hito2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class hito2 {
    public static void hito2() {
        JFrame ventana = new JFrame("Test Events: Files");
        ventana.setPreferredSize(new Dimension(900, 500));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenedor = ventana.getContentPane();
        contenedor.setLayout(new BorderLayout());

        //---------------Zona izquierda---------------

        JPanel izq = new JPanel();
        String[] txt = {"python.txt", "c.txt", "java.txt", "inventado.txt"};
        JComboBox<String> fich = new JComboBox<>(txt);
        fich.setSelectedItem("java.txt");
        JButton clearButton = new JButton("Clear");


        //---------------Zona derecha---------------

        JPanel drch = new JPanel();
        drch.setLayout(new BorderLayout());
        JTextArea muchoTexto = new JTextArea();
        //muchoTexto.setPreferredSize(new Dimension(400, 400));
        muchoTexto.setLineWrap(true);
        muchoTexto.setEditable(false);


        JScrollPane sp = new JScrollPane(muchoTexto);
        sp.setPreferredSize(new Dimension(450, 430));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JButton close = new JButton("Close");
        close.setPreferredSize(new Dimension(40,30));


        //---------------Acciones---------------

        fich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fichSeleccionado = (String) fich.getSelectedItem();
                try {
                    String contenido = new String(Files.readAllBytes(Paths.get(fichSeleccionado)));
                    muchoTexto.setText(contenido);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"Error, el fichero no se puede leer.");
                    //muchoTexto.setText("No se puede leer el archivo: " + ex.getMessage() + ".");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muchoTexto.setText("");
            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
                System.exit(0);
            }
        });

        ////---------------Añadir---------------

        izq.add(fich);
        izq.add(clearButton);
        contenedor.add(izq, BorderLayout.WEST);

        drch.add(sp,BorderLayout.NORTH);
        drch.add(close,BorderLayout.SOUTH);
        contenedor.add(drch, BorderLayout.EAST);

        ventana.pack();
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        hito2();
    }
}


