package com.kujawski;


import lombok.Data;

//using lombok
@Data
public class Point {

    private String nazwa;
    private double X;
    private double Y;

    public Point(String name, double x, double y) {
        this.nazwa  = name;
        this.X = x;
        this.Y = y;
    }

}
