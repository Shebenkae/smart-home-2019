package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class EventHandler {
    private SmartHome home;
    private SensorEvent event;

    public EventHandler(SmartHome home, SensorEvent event) {
        this.home = home;
        this.event = event;
    }

    public void eventHandle(){
        Collection<EventProcessor> events = new EventProccessorCreator().getEvents();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor eve : events) {
                eve.dealwithEvent(home, event);
            }
            event = new RandomEvent().getNextEvent();
        }
    }

}