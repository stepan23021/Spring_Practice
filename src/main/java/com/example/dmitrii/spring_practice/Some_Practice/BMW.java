package com.example.dmitrii.spring_practice.Some_Practice;

/**
 * @author Dmitrii Stepcenco
 * @created 05 September 2018
 **/

public class BMW extends Car {
    public BMW(){
        super();
    }

    public static void main(String[] args) {
        for (int i = 0; i<2;i++){
            BMW bmw = new BMW();
            bmw.go();
        }
    }

    @Override
    public void go() {
        super.go();
        wheels = "Aluminium";
        color = "White";
        engine = "BMW";
        enginePower = 300;
        super.go();
    }
}
