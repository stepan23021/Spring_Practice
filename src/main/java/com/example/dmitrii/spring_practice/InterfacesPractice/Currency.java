package com.example.dmitrii.spring_practice.InterfacesPractice;

/**
 * @author Dmitrii Stepcenco
 * @created 12 September 2018
 **/

public interface Currency {
    double convertToMDL(int value);
    double convertFromMDL(double value);
}
