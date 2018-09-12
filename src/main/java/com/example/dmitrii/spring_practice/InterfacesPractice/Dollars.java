package com.example.dmitrii.spring_practice.InterfacesPractice;

import java.util.ArrayList;

/**
 * @author Dmitrii Stepcenco
 * @created 12 September 2018
 **/

public class Dollars implements Currency {
    private Double multiplier = JSONParser.arr.get(0);

    @Override
    public double convertToMDL(int value) {
        return value * multiplier;
    }

    @Override
    public double convertFromMDL(double value) {
        return value / multiplier;
    }
}
