package com.kujawski;

//IMPORTS
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//
//ABOUT CLASS
public class AboutWindow {

    private static JDialog frame3;
    private JButton OKButton;
    private JLabel Icon;
    private JPanel panel2;
    private JLabel hyperlink;
    static JFrame f;

    //
    //MAIN ABOUT FUNCTION
    public static void main(String[] args) {

        f = new JFrame();

        frame3 = new JDialog(f, "About Distance Calculator");
        frame3.setContentPane(new AboutWindow().panel2);
        frame3.setPreferredSize(new Dimension(400, 200));
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3.pack();
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);


    }


    public final JDialog getMainJFrame() {
        return frame3;
    }


    public AboutWindow() {
        //
        //OK BUTTON
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getMainJFrame().dispose();
            }
        });

        //HYPERLINK TO WK
        hyperlink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {

                    Desktop.getDesktop().browse(new URI("https://git.kobiela.click/wiktor.kobiela/Java3Exercise"));

                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                    System.out.println("Error occured. Couldn't move to webpage.");
                }
            }
        });
        hyperlink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setText("<html><a href=''>Original by WK</a></html>");
            }
        });
        hyperlink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setText("Original by WK");
            }
        });
    }




    private void createUIComponents() {
        // TODO: place custom component creation code here

       // Hyperlink jlabel definition
        hyperlink = new JLabel();
        hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}
