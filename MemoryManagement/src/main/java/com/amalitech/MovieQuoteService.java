package com.amalitech;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MovieQuoteService implements Subject {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final List<Observer> observers = new ArrayList<>();
    private final Faker faker = new Faker();

    @Override
    public void attach(Observer observer) {
        System.out.println("Current number of subscribes users: " + observers.size());
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        String quote = faker.movie().quote();
        System.out.println("New quote: " + quote);
        for (Observer observer : observers) {
            System.out.println("Notifying user: " + observer);
            observer.update(quote);
        }
    }

    public void start() {
        scheduler.scheduleAtFixedRate(this::notifyObservers, 0, 1, TimeUnit.SECONDS);
    }

    public int numberOfSubscribers() {
        return observers.size();
    }
}
