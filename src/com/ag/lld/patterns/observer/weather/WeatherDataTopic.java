package com.ag.lld.patterns.observer.weather;

import com.ag.lld.patterns.observer.Subscriber;
import com.ag.lld.patterns.observer.Topic;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataTopic implements Topic<WeatherDataDetails> {

    private final List<Subscriber> subscriptions;

    public WeatherDataTopic(){
        subscriptions = new ArrayList<>();
    }

    @Override
    public boolean subscribe(Subscriber subscriber) {
        return subscriptions.add(subscriber);
    }

    @Override
    public boolean unsubscribe(Subscriber subscriber) {
        return subscriptions.remove(subscriber);
    }

    @Override
    public void onChange(final WeatherDataDetails data) {
        subscriptions.forEach(subscriber -> subscriber.notify(data));
    }
}
