package com.example.dmitrii.spring_practice.saturn;

import com.example.dmitrii.spring_practice.rocket_interfaces.ThirdStage;

public class SaturnThirdStage implements ThirdStage {
    @Override
    public void thirdStageStart(){
        System.out.println("Saturn Third Stage was ignited");
    }

    @Override
    public void thirdStageShutdown(){
        System.out.println("Saturn Third Stage was shut down");
    }
}
