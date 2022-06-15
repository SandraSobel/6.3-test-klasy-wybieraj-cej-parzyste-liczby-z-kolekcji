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

    public void getShapeName() {
        //do nothing
    }

    public void getField() {
        //do nothing
    }
}
