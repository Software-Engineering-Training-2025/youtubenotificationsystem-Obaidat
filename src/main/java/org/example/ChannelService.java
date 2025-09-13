package org.example;

import org.example.observer.Observer;
import org.example.subject.Channel;
import org.example.subject.Subject;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ChannelService {

    private final Map<String, Channel> channels = new HashMap<>();

    public boolean createChannel(String name){

        if (name.isBlank() || name.isEmpty() || channels.containsKey(name)){
            return false;
        }
        channels.put(name, new Channel(name));
        return true;
    }

    public boolean deleteChannel(String name){
        if (channels.containsKey(name)){
            channels.remove(name);
            return true;
        }
        return false;
    }

    public boolean subscribe(String channelName, Observer user){
        if (channels.containsKey(channelName) && user != null){
            channels.get(channelName).subscribe(user);
            return true;
        }
        return false;
    }

    public boolean unsubscribe(String channelName, Observer user){
        if (channels.containsKey(channelName) && user != null){
            channels.get(channelName).unsubscribe(user);
            return true;
        }
        return false;
    }

    public boolean upload(String channelName, String videoTitle){
        if (channels.containsKey(channelName) && !videoTitle.isEmpty()){
            channels.get(channelName).uploadVideo(videoTitle);
            return true;
        }
        return false;
    }

    public boolean notifyObservers(String channelName, String notification){
        if (channels.containsKey(channelName) && !notification.isEmpty()){
            channels.get(channelName).notifyObservers(notification);
            return true;
        }
        return false;
    }

    public Set<String> listChannels(){
        return channels.keySet();
    }
}
