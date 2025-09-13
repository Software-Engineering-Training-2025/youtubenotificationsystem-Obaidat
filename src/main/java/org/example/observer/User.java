package org.example.observer;

public class User implements Observer {
    private final String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public void update(String message) {
        // TODO: Print a notification message for this user
        System.out.println("Notification for " + this.username + ": " + message);
    }

    public String getUsername() {
        return username;
    }
}
