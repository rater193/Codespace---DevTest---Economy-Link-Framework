
package com.rater193.economylink.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EconEvents {
    private static EconEvents SINGLETON;
    private final Map<EconEventList, ArrayList<Runnable>> registeredEvents = new HashMap<>();

    public EconEvents() {
        SINGLETON = this;
    }

    public static EconEvents Get() {
        return SINGLETON;
    }

    //This method creates a new event
    public void CreateEvent(EconEventList eventName) {
        registeredEvents.put(eventName, new ArrayList<>());
    }

    //This registers a bindable method to an event.
    public void RegisterEvent(EconEventList eventName, Runnable method) {
        if(!registeredEvents.containsKey(eventName)) {
            CreateEvent(eventName);
        }

        registeredEvents.get(eventName).add(method);
    }

    //This unregisters an event
    public void UnregisterEvent(EconEventList eventName) {
        registeredEvents.remove(eventName);
    }

    //This invokes an event by name
    public void InvokeEvent(EconEventList eventName) {
        if(!registeredEvents.containsKey(eventName)) {
            return;
        }

        for(Runnable method : registeredEvents.get(eventName)) {
            method.run();
        }
    }
}