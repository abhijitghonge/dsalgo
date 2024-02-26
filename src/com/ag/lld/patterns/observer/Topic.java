package com.ag.lld.patterns.observer;

import com.ag.lld.patterns.observer.weather.WeatherDataDetails;

public interface Topic<T> {
    boolean subscribe(Subscriber subscriber);
    boolean unsubscribe(Subscriber subscriber);

    void onChange(T data);
}
