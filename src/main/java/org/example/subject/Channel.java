package org.example.subject;

import org.example.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject{

    private final String name;
    private final List<Observer> subscribers = new ArrayList<>();

    public Channel(String name) {
        this.name = name;
    }

    public void uploadVideo(String title){
        this.notifyObservers(this.name + "uploaded a new video: " + title);
    }

    @Override
    public void subscribe(Observer observer) {
        if (observer != null) {
            subscribers.add(observer);
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
        if (observer != null){
            subscribers.remove(observer);
        }
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : subscribers){
            observer.update(message);
        }
    }

    public String getName() {
        return name;
    }
}
