package com.example.dmitrii.spring_practice.Some_Practice;

/**
 * @author Dmitrii Stepcenco
 * @created 05 September 2018
 **/

public class BMW extends Car implements Runnable{


    public BMW() {
        super();
    }

    public static void main(String[] args) {
        BMW bmw = new BMW();
        bmw.go();

    }

    @Override
    public void go() {
        run();
        System.out.println("New thread finished");
        super.go();
        wheels = "Aluminium";
        color = "White";
        engine = "BMW";
        enginePower = 300;
        super.go();
    }

    @Override
    public void run() {
        System.out.println("New thread started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
