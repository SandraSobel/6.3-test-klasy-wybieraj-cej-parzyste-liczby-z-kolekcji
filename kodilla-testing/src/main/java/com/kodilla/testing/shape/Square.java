package com.kodilla.testing.shape;

public class Square implements Shape{
    String name;
    int squareSide;
    public Square(String name,int squareSide){
        this.name = name;
        this.squareSide = squareSide;
    }
    public String getShapeName() {
        return name;

    }

    public double getField() {
        return Math.pow((double)squareSide,2);
    }

}
