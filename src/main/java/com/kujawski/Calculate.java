package com.kujawski;

import lombok.Getter;
import static java.lang.Math.sqrt;

//using lombok
@Getter
public class Calculate {

    private double dst;

    public Calculate(String name1, double x1, double y1, String name2, double x2, double y2){

        System.out.print("Distance from " + name1 + " to " + name2 + " is: ");
        double distance = sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double x = Math.floor(distance * 100) / 100;
        System.out.println(x + "km");
        this.dst = x;
    }
}
