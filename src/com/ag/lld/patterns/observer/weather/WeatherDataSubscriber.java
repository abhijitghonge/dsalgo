package com.ag.lld.patterns.observer.weather;

import com.ag.lld.patterns.observer.Subscriber;
import com.ag.lld.patterns.observer.ui.DisplayAgent;
import com.ag.lld.patterns.observer.ui.WeatherUIData;

import java.util.concurrent.Callable;

public class WeatherDataSubscriber extends Subscriber<WeatherDataDetails> {

    private final DisplayAgent display;

    public WeatherDataSubscriber(DisplayAgent display) {
        super();
        this.display = display;
    }


    @Override
    public Runnable getTask(WeatherDataDetails data) {
        return ()->display.display(new WeatherUIData(data.getTemperature(), data.getHumidity(), data.getAirQuality()));
    }
}
