package ru.sbt.mipt.oop;

import java.util.Collection;

public class Action {
    private SmartHome smartHome;
    private Collection<EventDealer> eventDealers;
    private SensorEvent event;

    public Action(SmartHome smartHome, Collection<EventDealer> eventDealers, SensorEvent event) {
        this.smartHome = smartHome;
        this.eventDealers = eventDealers;
        this.event = event;
    }

    public void act (Room room, Object obj){
        for (EventDealer eventDealer:eventDealers){
            eventDealer.dealwithEvent(smartHome, event, room, obj);
        }
    }
}
