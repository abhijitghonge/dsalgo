package com.ag.lld.patterns.observer.pubsub2;


import com.ag.lld.patterns.observer.ui.DisplayAgent;
import com.ag.lld.patterns.observer.ui.WeatherUIData;
import com.ag.lld.patterns.observer.weather.WeatherDataDetails;

public class WeatherDataConsumer {

    private final DisplayAgent display;

    public WeatherDataConsumer(DisplayAgent display, Topic<WeatherDataDetails> weatherDataTopic) {
        this.display = display;
        weatherDataTopic.subscribe(this::update);
    }

    public void update(WeatherDataDetails data){
        display.display(new WeatherUIData(data.getTemperature(), data.getHumidity(), data.getAirQuality()));
    }
}
