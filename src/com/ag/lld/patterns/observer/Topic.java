package com.ag.lld.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Topic<T> {

    private final List<Subscriber<T>> subscribers;

    public Topic(){
        subscribers = new ArrayList<>();
    }

    public void onChange(T data){
        subscribers.forEach(subscriber-> subscriber.notify(data));
    }

    public boolean subscribe(Subscriber<T> subscriber){
        return subscribers.add(subscriber);
    }
    public boolean unsubscribe(Subscriber<T> subscriber){
        return subscribers.remove(subscriber);
    }


}
