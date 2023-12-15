package com.ag.lld.patterns.observer.weather;

import com.ag.lld.patterns.observer.Subscriber;
import com.ag.lld.patterns.observer.ui.DisplayAgent;
import com.ag.lld.patterns.observer.ui.UIDashboard;
import com.ag.lld.patterns.observer.ui.WeatherUIData;

public class MinMaxTempSubscriber implements Subscriber {

    private final DisplayAgent display;

    public MinMaxTempSubscriber(DisplayAgent display) {
        this.display = display;
    }


    @Override
    public void notify(WeatherDataDetails data) {
        WeatherUIData uiData = new WeatherUIData(data.getTemperature(), data.getHumidity(), data.getAirQuality());

        display.display(uiData);
    }
}
