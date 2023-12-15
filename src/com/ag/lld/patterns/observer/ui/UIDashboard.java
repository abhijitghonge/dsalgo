package com.ag.lld.patterns.observer.ui;

public class UIDashboard implements DisplayAgent{


    @Override
    public void display(WeatherUIData data) {

        System.out.printf("Weather Data Today:%n [%s]%n", data.toString());
    }

}
