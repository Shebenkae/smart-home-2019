package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class EventProccessorCreator {

    public Collection<EventProcessor> getEvents() {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new LightEventProcessor());
        eventProcessors.add(new DoorEventProcessor());
        eventProcessors.add(new DoorHallEventProcessor());
        return eventProcessors;
    }
}
