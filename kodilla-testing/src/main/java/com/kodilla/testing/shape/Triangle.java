package com.kodilla.testing.shape;

public class Triangle implements Shape{
    public String name;
    public int base;
    public int height;


    public Triangle(String name, int base, int height){
        this.name = name;
        this.base = base;
        this.height = height;
    }

    public String getShapeName() {
        return name;
    }

    public double getField() {
        return ((double)base * (double)height)/2;
    }
}
