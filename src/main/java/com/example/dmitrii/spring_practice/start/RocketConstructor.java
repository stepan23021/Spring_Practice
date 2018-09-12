package com.example.dmitrii.spring_practice.start;

import com.example.dmitrii.spring_practice.gemini.GeminiFuelType;
import com.example.dmitrii.spring_practice.gemini.GeminiSecondStage;
import com.example.dmitrii.spring_practice.rockets.Apollo;
import com.example.dmitrii.spring_practice.saturn.SaturnFirstStage;
import com.example.dmitrii.spring_practice.saturn.SaturnThirdStage;

//@SpringBootApplication

public class RocketConstructor {

    public static void main(String[] args) throws InterruptedException {
        GeminiFuelType fuelType = new GeminiFuelType();
        SaturnFirstStage firstStage = new SaturnFirstStage();
        GeminiSecondStage secondStage = new GeminiSecondStage();
        SaturnThirdStage thirdStage = new SaturnThirdStage();
        Apollo apollo = new Apollo(fuelType,firstStage,secondStage,thirdStage);
        apollo.launch();
        apollo.moonLanding();

    }
}
