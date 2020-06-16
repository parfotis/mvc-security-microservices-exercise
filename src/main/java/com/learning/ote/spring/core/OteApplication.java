package com.learning.ote.spring.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.learning.ote.spring.core.travel.*;

@SpringBootApplication
public class OteApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(OteApplication.class, args);

        AutowiredInjectedTravel autowiredInjectedTravel = (AutowiredInjectedTravel) ctx.getBean("autowiredInjectedTravel");
        autowiredInjectedTravel.startJourney();

        ConstructorInjectedTravel constructorInjectedTravel = (ConstructorInjectedTravel) ctx.getBean("constructorInjectedTravel");
        constructorInjectedTravel.startJourney();

        SetterInjectedTravel setterInjectedTravel = (SetterInjectedTravel) ctx.getBean("setterInjectedTravel");
        setterInjectedTravel.startJourney();

    }

}
