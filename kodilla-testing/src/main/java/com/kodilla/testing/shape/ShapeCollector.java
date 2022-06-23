package com.kodilla.testing.shape;

import java.util.*;


public class ShapeCollector {
    public List<Shape> shapeList = new ArrayList<>();


    public void addFigure(Shape shape) {
        shapeList.add(shape);
    }
    public void removeFigure(Shape shape){
        shapeList.remove(shape);
    }
    public Shape getFigure(int n){
        return shapeList.get(n);
    }
    public int getListQuantity() {
        return shapeList.size();
    }

    public String showFigures(){
        String showFigures = "";
        for (int i=0; i<shapeList.size();i++){
            if (i < shapeList.size()-1) {
                showFigures += shapeList.get(i).getShapeName() + ", ";
            }else{
                showFigures += shapeList.get(i).getShapeName();
            }
        }
        return showFigures;

    }

}
