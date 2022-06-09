package com.kodilla.testing;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.user.Calculator;


public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculatorTestAdd = new Calculator();
        int addResult = calculatorTestAdd.add(5,3);
        if (addResult == (5+3)){
            System.out.println("calculator add test OK");
        } else {
            System.out.println("Error(calculator+)!");
        }
        Calculator calculatorTestSubstract = new Calculator();
        int substractResult = calculatorTestSubstract.substract(5,3);
        if (substractResult == (5-3)){
            System.out.println("calculator substract test OK");
        } else {
            System.out.println("Error(calculator-)!");
        }
    }
}
