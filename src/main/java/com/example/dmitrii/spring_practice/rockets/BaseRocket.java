package com.example.dmitrii.spring_practice.rockets;

import com.example.dmitrii.spring_practice.rocket_interfaces.*;

/**
 * @author Dmitrii Stepcenco
 * @created 04 September 2018
 **/

public abstract class BaseRocket implements Rocket {

    FuelType fuelType;
    FirstStage firstStage;
    SecondStage secondStage;
    ThirdStage thirdStage;

    public BaseRocket() {
        System.out.println(this + " BaseRocket constructor()");
    }

    public BaseRocket(FuelType fuelType, FirstStage firstStage, SecondStage secondStage, ThirdStage thirdStage) {
        this();
        this.fuelType = fuelType;
        this.firstStage = firstStage;
        this.secondStage = secondStage;
        this.thirdStage = thirdStage;
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
}
