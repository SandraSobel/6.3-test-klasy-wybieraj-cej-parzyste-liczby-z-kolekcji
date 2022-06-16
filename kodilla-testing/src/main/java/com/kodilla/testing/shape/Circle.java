package com.kodilla.testing.shape;

public class Circle implements Shape{
    public String name;
    public int diameter;
    public Circle(String name, int diameter){
        this.name = name;
        this.diameter = diameter;
    }

    public String getShapeName() {
        return name;
    }

    public double getField() {
        return Math.PI * Math.pow((double)diameter,2);
    }
}
