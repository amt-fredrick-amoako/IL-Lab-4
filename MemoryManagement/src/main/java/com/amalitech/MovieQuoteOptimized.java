package com.amalitech;

import net.datafaker.Faker;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MovieQuoteOptimized implements Subject {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private final Faker faker = new Faker();
    private final int MAX_NOTIFICATIONS = 5;

    @Override
    public void attach(Observer observer) {
        System.out.println("Current number of subscribed users: " + observers.size());
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

        observers.forEach(observer -> {
            System.out.println("Notifying user: " + observer);
            observer.update(quote);

            // Detach observer after MAX_NOTIFICATIONS
            if (observer.getNotificationCount() >= MAX_NOTIFICATIONS) {
                detach(observer);
            }
        });
    }

    public void start() {
        // Notify every 5 seconds instead of every second to reduce frequency
        scheduler.scheduleAtFixedRate(this::notifyObservers, 0, 5, TimeUnit.SECONDS);
    }

    public int numberOfSubscribers() {
        return observers.size();
    }
}

