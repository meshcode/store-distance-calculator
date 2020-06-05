package com.kujawski;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Form {

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }


        JFrame frame = new JFrame("Distance calculator");
        frame.setContentPane(new Form().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    private JPanel panel1;
    private JButton button;
    private JTextField name1;
    private JTextField coordX1;
    private JTextField coordY1;
    private JTextField name2;
    private JTextField name3;
    private JTextArea textArea1;
    private JTextField coordX2;
    private JTextField coordX3;
    private JTextField coordY2;
    private JTextField coordY3;
    private JTextField name4;
    private JTextField coordX4;
    private JTextField coordY4;
    private JButton button2;
    private JButton fill;
    private JButton draw;
    private JMenu file;
    private JMenu About;
    private JMenuBar menuBar1;
    private JMenuItem exit;

    public Form() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Create points for calculations
                    Point first = new Point(name1.getText(), Double.parseDouble(coordX1.getText()), Double.parseDouble(coordY1.getText()));
                    Point second = new Point(name2.getText(), Double.parseDouble(coordX2.getText()), Double.parseDouble(coordY2.getText()));
                    Point third = new Point(name3.getText(), Double.parseDouble(coordX3.getText()), Double.parseDouble(coordY3.getText()));
                    Point forth = new Point(name4.getText(), Double.parseDouble(coordX4.getText()), Double.parseDouble(coordY4.getText()));

                    System.out.println("-------------------------------------------------");
                    System.out.println("Calculate.java test: ");

                    //calculate between home point and first point
                    Calculate distance1 = new Calculate(first.getNazwa(), first.getX(), first.getY(), second.getNazwa(), second.getX(), second.getY());
                    //calculate between home point and second point
                    Calculate distance2 = new Calculate(first.getNazwa(), first.getX(), first.getY(), third.getNazwa(), third.getX(), third.getY());
                    //calculate between home point and third point
                    Calculate distance3 = new Calculate(first.getNazwa(), first.getX(), first.getY(), forth.getNazwa(), forth.getX(), forth.getY());

                    String winner = "";
                    String looser = "";
                    String winner2 = "";
                    double difference = 0;
                    double difference2 = 0;
                    double howfar = 0;
                    //where is closer? new shop or second shop
                    if (distance2.getDst() < distance3.getDst()) {
                        winner = third.getNazwa();
                        difference = distance3.getDst() - distance2.getDst();
                        difference = Math.floor(difference * 100) / 100;
                        looser = forth.getNazwa();
                        howfar = distance2.getDst();
                    } else {
                        winner = forth.getNazwa();
                        difference = distance2.getDst() - distance3.getDst();
                        difference = Math.floor(difference * 100) / 100;
                        looser = third.getNazwa();
                        howfar = distance3.getDst();
                    }

                    //difference between distance to old shop and the winner
                    if (distance1.getDst() < howfar) {
                        difference2 = howfar - distance1.getDst();
                        difference2 = Math.floor(difference2 * 100) / 100;
                        winner2 = second.getNazwa();
                    } else {
                        difference2 = distance1.getDst() - howfar;
                        difference2 = Math.floor(difference2 * 100) / 100;
                        winner2 = winner;
                    }

                    //Checking in terminal if everything is OK
                    System.out.println("-------------------------------------------------");
                    System.out.println("Form.java calculations test: ");
                    System.out.println("Distance difference between Home->Point1 and closer one of Home->Point2 or Home->Point3: " + difference2);
                    System.out.println("Checking the difference calculation: " + (howfar - distance1.getDst()));
                    System.out.println("Distance to Point1 from get.Dst(): " + distance1.getDst());
                    System.out.println("Distance to closer one of Home->Point2 or Home->Point3: " + howfar);

                    //Fill textarea
                    textArea1.setText("Distance between " + first.getNazwa() + " and " + second.getNazwa() + " is " + Double.toString(distance1.getDst()) + " km"
                            + "\n" + "Distance between " + first.getNazwa() + " and " + third.getNazwa() + " is " + Double.toString(distance2.getDst()) + " km"
                            + "\n" + "Distance between " + first.getNazwa() + " and " + forth.getNazwa() + " is " + Double.toString(distance3.getDst()) + " km"
                            + "\n" + "It is closer to " + winner + " than to " + looser + " and the difference is " + difference + " km"
                            + "\n" + "Closest to Home point is the " + winner2 + ". The distance difference is " + difference2 + " km");
                } catch (Exception exp) {

                    //If anything wrong, popup appears
                    JOptionPane.showMessageDialog(null, "The entered values are incorrect or missing." + "\n" + "Fill in with the correct data or use the example data provided.", "Incorrect or missing data", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("-------------------------------------------------");
                    System.out.println("Some value has not been entered or is invalid and calculations cannot be performed.");
                }
            }
        });
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

        });

        //Clear button
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name1.setText("");
                name2.setText("");
                name3.setText("");
                name4.setText("");
                coordX1.setText("");
                coordX2.setText("");
                coordX3.setText("");
                coordX4.setText("");
                coordY1.setText("");
                coordY2.setText("");
                coordY3.setText("");
                coordY4.setText("");
                textArea1.setText("");

                System.out.println("-------------------------------------------------");
                System.out.println("Textboxes cleared.");

            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

        });

        //Fill button
        fill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name1.setText("Dom");
                name2.setText("Żabka");
                name3.setText("BP");
                name4.setText("Biedronka");
                coordX1.setText("0");
                coordX2.setText("1.2");
                coordX3.setText("5.5");
                coordX4.setText("3.3");
                coordY1.setText("0");
                coordY2.setText("2.5");
                coordY3.setText("-2.3");
                coordY4.setText("2.7");

                System.out.println("-------------------------------------------------");
                System.out.println("Textboxes filled with default values.");
            }
        });
        fill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                fill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

        });

        //Draw button
        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Point first = new Point(name1.getText(), Double.parseDouble(coordX1.getText()), Double.parseDouble(coordY1.getText()));
                    Point second = new Point(name2.getText(), Double.parseDouble(coordX2.getText()), Double.parseDouble(coordY2.getText()));
                    Point third = new Point(name3.getText(), Double.parseDouble(coordX3.getText()), Double.parseDouble(coordY3.getText()));
                    Point forth = new Point(name4.getText(), Double.parseDouble(coordX4.getText()), Double.parseDouble(coordY4.getText()));

                    System.out.println("-------------------------------------------------");
                    System.out.println("Calculate.java test: ");

                    //calculate between home and first old shop
                    Calculate distance1 = new Calculate(first.getNazwa(), first.getX(), first.getY(), second.getNazwa(), second.getX(), second.getY());
                    //calculate distance between home and new shop
                    Calculate distance2 = new Calculate(first.getNazwa(), first.getX(), first.getY(), third.getNazwa(), third.getX(), third.getY());
                    //calculate distance between home and second shop
                    Calculate distance3 = new Calculate(first.getNazwa(), first.getX(), first.getY(), forth.getNazwa(), forth.getX(), forth.getY());


                    XChart.main(null, first.getX(), second.getX(), third.getX(), forth.getX(), first.getY(), second.getY(), third.getY(), forth.getY(), first.getNazwa(), second.getNazwa(), third.getNazwa(), forth.getNazwa(), distance1.getDst(), distance2.getDst(), distance3.getDst());

                } catch (Exception exp) {

                    //If anything wrong, popup appears
                    JOptionPane.showMessageDialog(null, "The entered values are incorrect or missing." + "\n" + "Fill in with the correct data or use the example data provided.", "Incorrect or missing data", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("-------------------------------------------------");
                    System.out.println("Some value has not been entered or is invalid and calculations cannot be performed.");
                }
            }
        });
        draw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                draw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

        });

        About.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AboutWindow.main(null);
            }
        });
        About.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                About.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

        });
        file.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                file.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        file.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(null,"Are you sure?", "Closing...", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                if(input==0)
                {
                    System.exit(0);
                }

            }
        });
    }


}


