package com.example.dmitrii.spring_practice.rockets;

import com.example.dmitrii.spring_practice.rocket_interfaces.Rocket;
import com.example.dmitrii.spring_practice.rocket_interfaces.RocketConveyor;

/**
 * @author Dmitrii Stepcenco
 * @created 11 September 2018
 **/

public abstract class ApolloConveyor implements RocketConveyor {
    @Override
    public abstract Rocket createRocket();

}
