package com.example.dmitrii.spring_practice.gemini;

import com.example.dmitrii.spring_practice.rocket_interfaces.FirstStage;

public class GeminiFirstStage implements FirstStage {

    void process(int number, String name){
        System.out.println(number+name);
    }


    @Override
    public void firstStageStart() {
        System.out.println("Gemini First Stage was ignited");
    }

    @Override
    public void firstStageShutDown() {
        System.out.println("Gemini First Stage was shut down");
    }
}
