//look into package when other classes and functions are called
package com.kujawski;

//swing: GUI toolkit for Java programs
import javax.swing.*;
//awt: abstract window toolkit (before Swing)- graphical library - depends on OSsw
import java.awt.*;
//listeners
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//this form class is called by main class
public class Form {

    //main form function
    public static void main(String[] args) {
        //set general look and feel to Nimbus: a cross-platform setting which is drawn and rendered at any resolution.
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel here
        }

        //set the GUI frontline based on Form.form - asimplified process through intelliJ
        JFrame frame = new JFrame("Calculate Distances from Homebase");
        frame.setContentPane(new Form().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }
    //GUI element names

    //Panel
    private JPanel mainPanel;
    //Origin point
    private JTextField originPoint;
    private JTextField coordX1;
    private JTextField coordY1;
    //First point
    private JTextField firstPoint;
    private JTextField coordX2;
    private JTextField coordX3;
    //Second point
    private JTextField secondPoint;
    private JTextField coordY2;
    private JTextField coordY3;
    //Third point
    private JTextField thirdPoint;
    private JTextField coordX4;
    private JTextField coordY4;
    //
    //textarea displays the results from calculations in the GUI
    private JTextArea textArea1;
    //
    //calculate button
    private JButton calculateButton;
    //button to automatically fill the data with assigned values
    private JButton exampleButton;
    //button to plot the points
    private JButton plotButton;
    //clear button
    private JButton clearButton;
    //top file menu bar
    private JMenuBar menuBar1;
    //the file menu has one item - exit
    private JMenu file;
    private JMenuItem exit;
    //the about menu links to a separate about window
    private JMenu About;
    private JPanel menuPanel;


    public Form() {

        //LISTENERS FOR FORM ELEMENTS

//==================================================================================================================
        //
        //FILE MENU - file section
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

        //
        //FILE MENU - About section
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





//==================================================================================================================

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                originPoint.setText("");
                firstPoint.setText("");
                secondPoint.setText("");
                thirdPoint.setText("");
                coordX1.setText("");
                coordX2.setText("");
                coordX3.setText("");
                coordX4.setText("");
                coordY1.setText("");
                coordY2.setText("");
                coordY3.setText("");
                coordY4.setText("");
                textArea1.setText("");

                //SYSTEM DEBUG
                System.out.println("-------------------------------------------------");
                System.out.println("Textboxes cleared.");

            }
        });
    //
    //CLEAR THE FIELDS IF CLEAR BUTTON IS PRESSED
        clearButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

    });

//==================================================================================================================
        //
        //FILL WITH EXAMPLE DATA BUTTON
        exampleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                exampleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

        });
        exampleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                originPoint.setText("Basecamp");
                firstPoint.setText("Old Żabka");
                secondPoint.setText("New Żabka");
                thirdPoint.setText("Biedronka");
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
//==================================================================================================================
        //
        //PLOT BUTTON - MOUSE CURSOR SETTING
        plotButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                plotButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

        });

        //
        //PLOT BUTTON LISTENER
        plotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Point first = new Point(originPoint.getText(), Double.parseDouble(coordX1.getText()), Double.parseDouble(coordY1.getText()));
                    Point second = new Point(firstPoint.getText(), Double.parseDouble(coordX2.getText()), Double.parseDouble(coordY2.getText()));
                    Point third = new Point(secondPoint.getText(), Double.parseDouble(coordX3.getText()), Double.parseDouble(coordY3.getText()));
                    Point fourth = new Point(thirdPoint.getText(), Double.parseDouble(coordX4.getText()), Double.parseDouble(coordY4.getText()));

                    System.out.println("-------------------------------------------------");
                    System.out.println("Calculate.java test: ");

                    //
                    //CALL CALCULATE CLASS
                    //calculate between home and first old shop
                    Calculate distance1 = new Calculate(first.getNazwa(), first.getX(), first.getY(), second.getNazwa(), second.getX(), second.getY());
                    //calculate distance between home and new shop
                    Calculate distance2 = new Calculate(first.getNazwa(), first.getX(), first.getY(), third.getNazwa(), third.getX(), third.getY());
                    //calculate distance between home and second shop
                    Calculate distance3 = new Calculate(first.getNazwa(), first.getX(), first.getY(), fourth.getNazwa(), fourth.getX(), fourth.getY());

                    //CALL XCHART CLASS - MAIN FUNCTION - SEND POINTS TO PLOT
                    XChart.main(null, first.getX(), second.getX(), third.getX(), fourth.getX(), first.getY(), second.getY(), third.getY(), fourth.getY(), first.getNazwa(), second.getNazwa(), third.getNazwa(), fourth.getNazwa(), distance1.getDst(), distance2.getDst(), distance3.getDst());
                    //
                    //POPUP IF ENTERED VALUES ARE INCORRECT
                } catch (Exception exp) {

                    JOptionPane.showMessageDialog(null, "The entered values are incorrect or missing." + "\n" + "Fill in with the correct data or use the example data provided.", "Incorrect or missing data", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("-------------------------------------------------");
                    System.out.println("Some value has not been entered or is invalid and calculations cannot be performed.");
                }
            }
        });
    //==================================================================================================================
    //
    //CALCULATE BUTTON
        calculateButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            calculateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

    });
        calculateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //run code - try if it can since it involved user input and possible human error
            try {
                //Create points for calculations
                Point first = new Point(originPoint.getText(), Double.parseDouble(coordX1.getText()), Double.parseDouble(coordY1.getText()));
                Point second = new Point(firstPoint.getText(), Double.parseDouble(coordX2.getText()), Double.parseDouble(coordY2.getText()));
                Point third = new Point(secondPoint.getText(), Double.parseDouble(coordX3.getText()), Double.parseDouble(coordY3.getText()));
                Point fourth = new Point(thirdPoint.getText(), Double.parseDouble(coordX4.getText()), Double.parseDouble(coordY4.getText()));

                //SYSTEM DEBUG OUTPUT
                System.out.println("-------------------------------------------------");
                System.out.println("Calculate.java test: ");

                //calculate between origin point and first point - using Lombok for automated code
                Calculate distance1 = new Calculate(first.getNazwa(), first.getX(), first.getY(), second.getNazwa(), second.getX(), second.getY());
                //calculate between origin point and second point
                Calculate distance2 = new Calculate(first.getNazwa(), first.getX(), first.getY(), third.getNazwa(), third.getX(), third.getY());
                //calculate between origin point and third point
                Calculate distance3 = new Calculate(first.getNazwa(), first.getX(), first.getY(), fourth.getNazwa(), fourth.getX(), fourth.getY());

                String winner = "";
                String looser = "";
                String winner2 = "";
                double difference = 0;
                double difference2 = 0;
                double howfar = 0;

                //CALCULATE WHICH POINT IS CLOSER
                //if it is closer to point 2 than 3
                if (distance2.getDst() < distance3.getDst()) {
                    winner = third.getNazwa();
                    difference = distance3.getDst() - distance2.getDst();
                    difference = Math.floor(difference * 100) / 100;
                    looser = fourth.getNazwa();
                    howfar = distance2.getDst();
                    //
                    //otherwise if it is closer to point 3 than 2
                } else {
                    winner = fourth.getNazwa();
                    difference = distance2.getDst() - distance3.getDst();
                    //round to two decimals
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

                //SYSTEM OUTPUT
                //Checking in terminal if everything is OK
                System.out.println("-------------------------------------------------");
                System.out.println("Form.java calculations test: ");
                System.out.println("Distance difference between Home->Point1 and closer one of Home->Point2 or Home->Point3: " + difference2);
                System.out.println("Checking the difference calculation: " + (howfar - distance1.getDst()));
                System.out.println("Distance to Point1 from get.Dst(): " + distance1.getDst());
                System.out.println("Distance to closer one of Home->Point2 or Home->Point3: " + howfar);

                //TEXT AREA OUTPUT
                textArea1.setText("Distance between " + first.getNazwa() + " and " + second.getNazwa() + " is " + Double.toString(distance1.getDst()) + " km."
                        + "\n" + "Distance between " + first.getNazwa() + " and " + third.getNazwa() + " is " + Double.toString(distance2.getDst()) + " km."
                        + "\n" + "Distance between " + first.getNazwa() + " and " + fourth.getNazwa() + " is " + Double.toString(distance3.getDst()) + " km."
                        + "\n" + "It is closer to " + winner + " than to " + looser + " and the difference is " + difference + " km."
                        + "\n" + "Closest to Home point is the " + winner2 + ". The difference in distance is " + difference2 + " km.");
                //
                //POPUP APPEARS IF ANY VALUES ARE OF HUMAN ERROR
            } catch (Exception exp) {
                JOptionPane.showMessageDialog(null, "The entered values are incorrect or missing." + "\n" + "Fill in with the correct data or use the example data provided.", "Incorrect or missing data", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("-------------------------------------------------");
                System.out.println("Some value has not been entered or is invalid and calculations cannot be performed.");
            }
        }
    });
    }

//CREATES THE UI COMPONENTS
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


