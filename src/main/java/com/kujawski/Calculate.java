package com.kujawski;

//using lombok
import lombok.Getter;
import static java.lang.Math.sqrt;

//getter method for retreiving calculation
@Getter
public class Calculate {

    //variable which stores the distance when called
    private double dst;
//receive argumants which are needed to calculate distance between ANY two points
    public Calculate(String name1, double x1, double y1, String name2, double x2, double y2){

        //the names of the points are only needed in order to debug in system out
        System.out.print("Distance from " + name1 + " to " + name2 + " is: ");
        //distance formula where "2" is the power of 2
        double distance = sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        //round the integer to two decimals and store as x double
        double x = Math.floor(distance * 100) / 100;
        //output the distance in km
        System.out.println(x + "km");
        //store variable
        this.dst = x;
    }
}
