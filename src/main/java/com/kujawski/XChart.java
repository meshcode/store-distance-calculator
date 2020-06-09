package com.kujawski;

//IMPORT SPECIAL CHARTING
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import javax.swing.*;
import java.awt.*;

public class XChart extends JFrame {

//RECEIVE CHARTING ARGUMENTS
        public static void main(String[] args, double x1, double x2, double x3, double x4, double y1, double y2, double y3, double y4, String name1, String name2, String name3, String name4, double dst1, double dst2, double dst3) {

            // Create Chart
            final XYChart chart =
                    new XYChartBuilder()
                            .width(600)
                            .height(500)
                            .title("Distances from Origin (km)")
                            .xAxisTitle("X")
                            .yAxisTitle("Y")
                            .build();

            // Customize Chart
            chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideS);
            chart.getStyler().setLegendLayout(Styler.LegendLayout.Horizontal);
            chart.getStyler().setHasAnnotations(true);
            chart.getStyler().setToolTipsEnabled(true); //shows values of points if pointed

            // Series

            chart.addSeries(name1 + "->" + name2 +" (" + dst1 + "km)" + " ", new double[] {x1, x2}, new double[] {y1, y2});
            chart.addSeries(name1 + "->" + name3 +" (" + dst2 + "km)" + " ", new double[] {x1, x3}, new double[] {y1, y3});
            chart.addSeries(name1 + "->" + name4 +" (" + dst3 + "km)" + " ", new double[] {x1, x4}, new double[] {y1, y4});


            // Schedule a job for the event-dispatching thread:
            // creating and showing this application's GUI.
            SwingUtilities.invokeLater(
                    new Runnable() {

                        @Override
                        public void run() {

                            // Create and set up the window.
                            JFrame frame = new JFrame("Distances from Origin in Kilometers");
                            frame.setLayout(new BorderLayout());
                            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                            // chart
                            JPanel chartPanel = new XChartPanel<XYChart>(chart);
                            frame.add(chartPanel, BorderLayout.CENTER);

                            // label
                            //JLabel label = new JLabel("Blah blah blah.", SwingConstants.CENTER);
                            //frame.add(label, BorderLayout.SOUTH);

                            // Display the window.
                            frame.pack();
                            frame.setVisible(true);

                            System.out.println("-------------------------------------------------");
                            System.out.println("Chart drawn correctly.");



                        }
                    });
        }



    }
