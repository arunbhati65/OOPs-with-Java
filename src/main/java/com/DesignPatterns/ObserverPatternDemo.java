package com.DesignPatterns;
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void publishNews(String news) {
        System.out.println("News Published: " + news);
        notifyObservers(news);
    }
}

class NewsSubscriber implements Observer {
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Observer subscriber1 = new NewsSubscriber("Alice");
        Observer subscriber2 = new NewsSubscriber("Bob");

        agency.addObserver(subscriber1);
        agency.addObserver(subscriber2);

        agency.publishNews("Breaking News: Java Observer Pattern!");

        // Remove one observer and publish another news
        agency.removeObserver(subscriber1);
        agency.publishNews("Latest Update: Observer Pattern in Real Life!");
    }
}

