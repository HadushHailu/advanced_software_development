package org.carframework.service;

import org.carframework.integration.Observer;

import java.util.ArrayList;
import java.util.Collection;

public class Subject {
    private Collection<Observer> observerCollection = new ArrayList<>();

    public void addObserver(Observer observer){
        observerCollection.add(observer);
    }

    public void update(double speed){
        for(Observer observer: observerCollection)
            observer.update(speed);
    }
}
