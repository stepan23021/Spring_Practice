package com.example.dmitrii.spring_practice.saturn;

import com.example.dmitrii.spring_practice.rocket_interfaces.FirstStage;

public class SaturnFirstStage implements FirstStage {

    @Override
    public void firstStageStart() {
        System.out.println("Saturn First Stage was ignited");
    }

    @Override
    public void firstStageShutDown() {
        System.out.println("Saturn First Stage was shut down");
    }
}
