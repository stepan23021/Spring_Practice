package com.example.dmitrii.spring_practice.InterfacesPractice;

/**
 * @author Dmitrii Stepcenco
 * @created 12 September 2018
 **/

public class Euro implements Currency {
    private Double multiplier = JSONParser.arr.get(1);

    @Override
    public double convertToMDL(int value) {
        return value * multiplier;
    }

    @Override
    public double convertFromMDL(double value) {
        return value / multiplier;
    }
}
