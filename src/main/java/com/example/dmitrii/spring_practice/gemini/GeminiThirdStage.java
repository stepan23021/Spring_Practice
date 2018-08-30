package com.example.dmitrii.spring_practice.gemini;

import com.example.dmitrii.spring_practice.rocket_interfaces.ThirdStage;

public class GeminiThirdStage implements ThirdStage {

    @Override
    public void thirdStageStart() {
        System.out.println("Gemini Third Stage was ignited");
    }

    @Override
    public void thirdStageShutdown(){
        System.out.println("Gemini Third Stage was shut down");
    }
}
