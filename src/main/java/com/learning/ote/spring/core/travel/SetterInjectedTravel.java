package com.learning.ote.spring.core.travel;

import com.learning.ote.spring.core.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class SetterInjectedTravel {

    //This is the dependency
    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        System.out.println("Using Setter Injection");
    }

    public void startJourney() {
        vehicle.start();
    }

}