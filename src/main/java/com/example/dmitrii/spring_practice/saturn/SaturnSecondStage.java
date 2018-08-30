package com.example.dmitrii.spring_practice.saturn;

import com.example.dmitrii.spring_practice.rocket_interfaces.SecondStage;

public class SaturnSecondStage implements SecondStage {
    @Override
    public void secondStageStart(){
        System.out.println("Saturn Second Stage was ignited");
    }

    @Override
    public void secondStageShutDown(){
        System.out.println("Saturn Second Stage was shut down");
    }
}
