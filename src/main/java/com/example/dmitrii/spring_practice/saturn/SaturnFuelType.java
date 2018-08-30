package com.example.dmitrii.spring_practice.saturn;

import com.example.dmitrii.spring_practice.rocket_interfaces.FuelType;

import static com.example.dmitrii.spring_practice.ansi_colors.Colors.ANSI_RED;
public class SaturnFuelType implements FuelType {

        @Override
        public void fuelingRocket(){
            System.out.println(ANSI_RED + "Apollo was fueled with Kerosene+LOX");
        }

}
