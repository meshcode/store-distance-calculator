package com.kujawski;

//Lombok: "is a java library that automatically plugs into your editor and build tools, spicing up your java
//Never write another getter or equals method again,
//with one annotation your class has a fully featured builder, Automate your logging variables, and much more"
import lombok.Data;

//This Point class will work with a point name and its X Y coordinates
//Define the data to work with: here it will be a Point.
@Data
public class Point {
//define the variables for point name, the x and the y coordinate
    private String nazwa;
    private double X;
    private double Y;

    //receive a name, and x y coordinates as doubles
    public Point(String name, double x, double y) {
        //assign these to this new point
        this.nazwa  = name;
        this.X = x;
        this.Y = y;
    }

}
