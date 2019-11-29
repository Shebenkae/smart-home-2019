package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class Application {
    public static void main(String... args) throws IOException {
        SmartHomeReader smartHomeReaderGson = new SmartHomeReaderGson("smart-home-1.js");
        SmartHome smartHome = smartHomeReaderGson.readSmartHome();
        checkEvents(smartHome);
    }

    private static Collection<EventProcessor> getEvents() {
        Collection<EventProcessor> eventDealers = new ArrayList<>();
        eventDealers.add(new LightEventProcessor());
        eventDealers.add(new DoorEventProcessor());
        eventDealers.add(new DoorHallEventProcessor());
        return eventDealers;
    }

    private static void checkEvents(SmartHome smartHome) {
        EventSupplier randomEvent = new RandomEvent();
        SensorEvent event = randomEvent.getNextEvent();
        Collection<EventProcessor> events = getEvents();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor eve : events) {
            eve.dealwithEvent(smartHome, event);
            }
            event = randomEvent.getNextEvent();
        }
    }

}