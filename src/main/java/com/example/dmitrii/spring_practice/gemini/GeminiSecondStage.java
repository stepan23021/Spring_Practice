package com.example.dmitrii.spring_practice.gemini;

import com.example.dmitrii.spring_practice.rocket_interfaces.SecondStage;

public class GeminiSecondStage implements SecondStage{
    @Override
    public void secondStageStart() {
        System.out.println("Gemini Second Stage was ignited");
    }

    @Override
    public void secondStageShutDown() {
        System.out.println("Gemini Second Stage was shut down");
    }
}
