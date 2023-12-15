package com.ag.lld.patterns.observer;

import com.ag.lld.patterns.observer.ui.DisplayAgent;
import com.ag.lld.patterns.observer.ui.MaxMinTempDisplay;
import com.ag.lld.patterns.observer.ui.UIDashboard;
import com.ag.lld.patterns.observer.weather.MinMaxTempSubscriber;
import com.ag.lld.patterns.observer.weather.WeatherDataDetails;
import com.ag.lld.patterns.observer.weather.WeatherDataTopic;
import com.ag.lld.patterns.observer.weather.WeatherDisplaySubscriber;

public class Main {
    public static void main(String[] args) {
        WeatherDataDetails data = WeatherDataDetails.builder()
                .setTemperature(99.5)
                .setHumidity(87.5)
                .setAirQuality(136).build();

        Topic weatherData = new WeatherDataTopic();
        DisplayAgent dashboard = new UIDashboard();
        DisplayAgent minMaxTemp = new MaxMinTempDisplay();

        weatherData.subscribe(new WeatherDisplaySubscriber(dashboard));
        weatherData.subscribe(new MinMaxTempSubscriber(minMaxTemp));
        weatherData.onChange(data);


        WeatherDataDetails changedData = WeatherDataDetails.builder()
                .setTemperature(75.5)
                .setHumidity(87.5)
                .setAirQuality(136).build();

        weatherData.onChange(changedData);


    }
}
