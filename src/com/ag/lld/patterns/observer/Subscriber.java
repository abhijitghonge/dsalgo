package com.ag.lld.patterns.observer;

import com.ag.lld.patterns.observer.weather.WeatherDataDetails;

public interface Subscriber<T> {

    void notify(T data);
}
