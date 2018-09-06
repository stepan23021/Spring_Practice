package com.example.dmitrii.spring_practice.Some_Practice;

/**
 * @author Dmitrii Stepcenco
 * @created 05 September 2018
 **/

public class Car {

    static String wheels = "Titan";
    static String color = "Black";
    static String engine = "Rolls-Royce";
    static int enginePower = 500;

    public static void main(String[] args) {
        Car car = new Car();
        car.go();
    }

    public void go(){
        System.out.printf("Car of %s color with %s engine with %d horsepower is running on %s wheels\n",
                                    color, engine,enginePower,wheels);
    }
}
