package com.example.dmitrii.spring_practice.rockets;

import com.example.dmitrii.spring_practice.rocket_interfaces.*;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;

import static com.example.dmitrii.spring_practice.ansi_colors.Colors.ANSI_CYAN;
import static com.example.dmitrii.spring_practice.ansi_colors.Colors.ANSI_GREEN;
import static com.example.dmitrii.spring_practice.ansi_colors.Colors.ANSI_RESET;

public class Apollo extends BaseRocket implements InitializingBean, DisposableBean, Serializable {



    private int serialNumber;
    private boolean hustonWeHaveAProblem;
    private String camouflage;



    public Apollo(FuelType fuelType,
                  FirstStage firstStage,
                  SecondStage secondStage,
                  ThirdStage thirdStage,
                  int serialNumber,
                  boolean hustonWeHaveAProblem,
                  String camouflage) {
        super(fuelType,firstStage,secondStage,thirdStage);
        this.serialNumber = serialNumber;
        this.hustonWeHaveAProblem = hustonWeHaveAProblem;
        this.camouflage = camouflage;
    }

    public Apollo() {
    }

    public Apollo(int serialNumber,boolean hustonWeHaveAProblem,String camouflage){
        this.serialNumber = serialNumber;
        this.hustonWeHaveAProblem = hustonWeHaveAProblem;
        this.camouflage = camouflage;
    }

    public Apollo(FuelType fuelType, FirstStage firstStage, SecondStage secondStage, ThirdStage thirdStage) {
        super(fuelType,firstStage,secondStage,thirdStage);
    }

    @Override
    public void launch() throws InterruptedException {
        System.out.println("Camouflage " + camouflage);
        Thread.sleep(500);
        System.out.println("Serial Number " + serialNumber);
        Thread.sleep(500);
        fuelType.fuelingRocket();
        Thread.sleep(500);
        firstStage.firstStageStart();
        Thread.sleep(500);
        firstStage.firstStageShutDown();
        if (hustonWeHaveAProblem) {
            Thread.sleep(500);
            System.out.println("Huston, We Have A Problem");
        }
        Thread.sleep(500);
        secondStage.secondStageStart();
        Thread.sleep(500);
        secondStage.secondStageShutDown();
        Thread.sleep(500);
        thirdStage.thirdStageStart();
        Thread.sleep(500);
        thirdStage.thirdStageShutdown();
        Thread.sleep(500);
        enterOrbit();
    }

    @MyCustomAnnotation
    public void igorSay(){
        System.out.println(ANSI_GREEN+"ДИМОН ЛОХ"+ANSI_RESET);
    }

    private void enterOrbit() {
        System.out.println("Successfully entered Earth orbit");
    }

    @Override
    public void moonLanding() {
        System.out.println("Beginning our journey to the Moon" + ANSI_CYAN);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isHustonWeHaveAProblem() {
        return hustonWeHaveAProblem;
    }

    public void setHustonWeHaveAProblem(boolean hustonWeHaveAProblem) {
        this.hustonWeHaveAProblem = hustonWeHaveAProblem;
    }

    public String getCamouflage() {
        return camouflage;
    }

    public void setCamouflage(String camouflage) {
        this.camouflage = camouflage;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this + " - method destroy()");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this + " - method init()");
    }
}