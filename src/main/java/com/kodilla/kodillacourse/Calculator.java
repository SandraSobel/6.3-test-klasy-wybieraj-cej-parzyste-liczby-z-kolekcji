package com.kodilla.kodillacourse;

public class Calculator {
    int a;
    int b;
    public void addNumbers (int a, int b){
        int result = a + b;
        System.out.println("Wynik dodawania liczby " + a + " do liczby " + b + " to " + result);
    }
    public void substractNumbers(int a, int b){
        int result = a - b;
        System.out.println("Wynik odejmowania liczby " + b + " od liczby " + a + " to " + result);
    }
    public static void main (String [] args){
        Calculator calculator = new Calculator();
        calculator.addNumbers(5,2);
        calculator.substractNumbers(5,2);


    }
}
