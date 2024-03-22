package Hito2;

import javax.swing.*;
import java.awt.*;

public class hito2 {
    public static void hito2() {
        JFrame ventana = new JFrame("Test Events: Files");
        ventana.setPreferredSize(new Dimension(900,500));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenedor=ventana.getContentPane();
        contenedor.setLayout(new BorderLayout());

        //---------------Zona izquierda---------------

        JPanel izq = new JPanel();
        String[] txt = {"python.txt","c.txt","java.txt"};
        JComboBox fich = new JComboBox<>(txt);



        izq.add(fich);
        contenedor.add(izq,BorderLayout.WEST);



        //---------------Zona derecha---------------

        JPanel drch = new JPanel();
        JTextField muchoTexto=new JTextField("AAA");
        muchoTexto.setPreferredSize(new Dimension(450,450));
        muchoTexto.setEditable(false);



        drch.add(muchoTexto);
        contenedor.add(drch,BorderLayout.EAST);
        //ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setVisible(true);
    }
    public static void main(String[] args) {
        hito2();
    }
}


