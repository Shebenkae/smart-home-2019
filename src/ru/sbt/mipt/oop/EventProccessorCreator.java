package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class EventProccessorCreator {

    public Collection<EventProcessor> getEvents() {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new StateDecorator(new LightEventProcessor()));
        eventProcessors.add(new StateDecorator(new DoorEventProcessor()));
        eventProcessors.add(new StateDecorator(new DoorHallEventProcessor()));
        eventProcessors.add(new AlarmEventProcessor());
        return eventProcessors;
    }
}
