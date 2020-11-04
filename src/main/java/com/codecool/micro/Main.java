package com.codecool.micro;

import com.codecool.micro.microbe.Labor;
import com.codecool.micro.microbe.Microbe;

public class Main {
    public static void main(String[] args) {
        Labor labor = new Labor(720, 25);
        labor.simulate();
        for (Microbe microbe:labor.getMicrobes()) {
            System.out.println(microbe.getClass().getSimpleName());
            System.out.println(microbe.getCellNumber());
        }
    }
}
