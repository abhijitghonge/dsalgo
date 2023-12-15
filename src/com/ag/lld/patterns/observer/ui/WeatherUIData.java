package com.ag.lld.patterns.observer.ui;

public class WeatherUIData {

    private final double temperature;
    private final double humidity;
    private final int airQuality;


    public WeatherUIData(double temperature, double humidity, int airQuality) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.airQuality = airQuality;
    }

    @Override
    public String toString() {
        return "WeatherUIData{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", airQuality=" + airQuality +
                '}';
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public int getAirQuality() {
        return airQuality;
    }
}
