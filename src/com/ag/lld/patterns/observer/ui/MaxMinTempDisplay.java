package com.ag.lld.patterns.observer.ui;

import java.util.Objects;

public class MaxMinTempDisplay implements DisplayAgent{

    private Double maxTemperature;
    private Double minTemprature;


    @Override
    public void display(WeatherUIData data) {
        double temperature =data.getTemperature();
        if(Objects.isNull(maxTemperature)){
            maxTemperature = minTemprature = temperature;
        }else if(temperature > maxTemperature){
            maxTemperature = temperature;
        }else{
            minTemprature = temperature;
        }
        System.out.printf("Maximum/Minimum Temperature Today:%n [%s]%n", this);
    }

    @Override
    public String toString() {
        return "Max/Min{" +
                "Max=" + maxTemperature +
                ", Min=" + minTemprature +
                '}';
    }

    public void setTemperature(Double temperature) {


    }


}
