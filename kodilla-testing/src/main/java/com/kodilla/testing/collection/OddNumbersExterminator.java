package com.kodilla.testing.collection;
import java.lang.*;
import java.util.*;



public class OddNumbersExterminator {
    public List<Integer> numbersList;
    public OddNumbersExterminator(List<Integer> numbersList) {
        this.numbersList = numbersList;
    }


    public List<Integer> exterminate(List<Integer> numbers){
        for (int i=0; i<numbers.size();i++){
            if (numbers.get(i)%2 != 0){
                numbers.remove(i);
            }
        }
        return numbers;
    }
}
