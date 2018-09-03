package com.example.dmitrii.spring_practice.rockets;

import com.example.dmitrii.spring_practice.rocket_interfaces.*;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

import static com.example.dmitrii.spring_practice.ansi_colors.Colors.ANSI_CYAN;

public class Apollo implements Rocket, InitializingBean, DisposableBean  {

    private FuelType fuelType;
    private FirstStage firstStage;
    private SecondStage secondStage;
    private ThirdStage thirdStage;

    private int serialNumber;
    private boolean hustonWeHaveAProblem;
    private String camouflage;

    public Apollo(int serialNumber, boolean hustonWeHaveAProblem, String camouflage) {
        this.serialNumber = serialNumber;
        this.hustonWeHaveAProblem = hustonWeHaveAProblem;
        this.camouflage = camouflage;
    }

    public Apollo(FuelType fuelType,
                  FirstStage firstStage,
                  SecondStage secondStage,
                  ThirdStage thirdStage,
                  int serialNumber,
                  boolean hustonWeHaveAProblem,
                  String camouflage) {
        super();
        this.fuelType = fuelType;
        this.firstStage = firstStage;
        this.secondStage = secondStage;
        this.thirdStage = thirdStage;
        this.serialNumber = serialNumber;
        this.hustonWeHaveAProblem = hustonWeHaveAProblem;
        this.camouflage = camouflage;
    }

    public Apollo() {
    }

    public Apollo(FuelType fuelType, FirstStage firstStage, SecondStage secondStage, ThirdStage thirdStage) {
        super();
        this.fuelType = fuelType;
        this.firstStage = firstStage;
        this.secondStage = secondStage;
        this.thirdStage = thirdStage;

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

    private void enterOrbit() {
        System.out.println("Successfully entered Earth orbit");
    }

    @Override
    public void moonLanding() {
        System.out.println("Beginning our journey to the Moon" + ANSI_CYAN);
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public FirstStage getFirstStage() {
        return firstStage;
    }

    public void setFirstStage(FirstStage firstStage) {
        this.firstStage = firstStage;
    }

    public SecondStage getSecondStage() {
        return secondStage;
    }

    public void setSecondStage(SecondStage secondStage) {
        this.secondStage = secondStage;
    }

    public ThirdStage getThirdStage() {
        return thirdStage;
    }

    public void setThirdStage(ThirdStage thirdStage) {
        this.thirdStage = thirdStage;
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