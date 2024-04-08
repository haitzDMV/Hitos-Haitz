package Hito3.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class hito3 extends JFrame {
    private JLabel imagenLabel;
    private JComboBox<String> imagenComboBox;
    private JCheckBox commentCheckBox;
    private JTextField commentTextField;

    private static final String FOLDER_PATH = "img";
    private static final String PASSWORD = "damocles";

    public hito3() {
        setTitle("Swing - Example 2");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //--------------

        JPanel topPanel = new JPanel();
        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordField = new JPasswordField(10);
        JButton enterButton = new JButton("Entrar");
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] input = passwordField.getPassword();
                if (new String(input).equals(PASSWORD)) {
                    imagenComboBox= new JComboBox<>();
                    load_combo();
                    getContentPane().remove(topPanel);
                    getContentPane().add(Principal(), BorderLayout.CENTER);
                    revalidate();
                    repaint();
                } else {
                    System.exit(0);
                }
            }
        });

        topPanel.add(passwordLabel);
        topPanel.add(passwordField);
        topPanel.add(enterButton);
        add(topPanel, BorderLayout.NORTH);




        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(hito3.this, "Adiós!");
            }
        });
    }

    private JPanel Principal() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));

        imagenComboBox = new JComboBox<>();
        load_combo();
        imagenComboBox.addActionListener(new ComboListener());
        mainPanel.add(imagenComboBox);

        imagenLabel = new JLabel();
        mainPanel.add(imagenLabel);



        commentCheckBox = new JCheckBox("Agregar comentario");
        mainPanel.add(commentCheckBox);


        commentTextField = new JTextField();
        mainPanel.add(commentTextField);


        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String imageName = (String) imagenComboBox.getSelectedItem();
                String comment = commentTextField.getText();
                if (commentCheckBox.isSelected()) {
                    try (PrintWriter writer = new PrintWriter(new FileWriter(FOLDER_PATH + "/" + imageName + ".txt", true))) {
                        writer.println(comment);
                    } catch (IOException a) {
                        a.printStackTrace();
                    }
                }
            }
        });



        mainPanel.add(saveButton);

        return mainPanel;
    }


    private void load_combo() {
        File folder = new File(FOLDER_PATH);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    imagenComboBox.addItem(file.getName());
                }
            }
        }
    }
    private class ComboListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String imageName = (String) imagenComboBox.getSelectedItem();
            ImageIcon icon = new ImageIcon(FOLDER_PATH + "/" + imageName);
            imagenLabel.setIcon(icon);
        }
    }





    public static void main(String[] args) {

        hito3 app = new hito3();
        app.setVisible(true);
    };
}

