package com.ag.lld.patterns.observer;

import com.ag.lld.patterns.observer.ui.DisplayAgent;
import com.ag.lld.patterns.observer.ui.MaxMinTempDisplay;
import com.ag.lld.patterns.observer.ui.UIDashboard;
import com.ag.lld.patterns.observer.ui.WeatherUIData;
import com.ag.lld.patterns.observer.weather.WeatherDataSubscriber;
import com.ag.lld.patterns.observer.weather.WeatherDataDetails;
import com.ag.lld.patterns.observer.weather.WeatherDataTopic;

public class Main {
    public static void main(String[] args) {
        WeatherDataDetails data = WeatherDataDetails.builder()
                .setTemperature(99.5)
                .setHumidity(87.5)
                .setAirQuality(136).build();

        Topic<WeatherDataDetails> weatherDataTopic = new WeatherDataTopic();
        DisplayAgent dashboard = new UIDashboard();
        DisplayAgent minMaxTemp = new MaxMinTempDisplay();

        weatherDataTopic.subscribe(new WeatherDataSubscriber(dashboard));
        weatherDataTopic.subscribe(new WeatherDataSubscriber(minMaxTemp));
        weatherDataTopic.onChange(data);


        WeatherDataDetails changedData = WeatherDataDetails.builder()
                .setTemperature(75.5)
                .setHumidity(87.5)
                .setAirQuality(136).build();

        weatherDataTopic.onChange(changedData);


    }
}
