package ru.sbt.mipt.oop;

import java.util.Collection;

public class HandleEventProcessor implements EventProcessor {

    private Collection<EventProcessor> processors;

    public HandleEventProcessor(Collection<EventProcessor> eventProcessors) {
        this.processors = eventProcessors;
    }

    @Override
    public void dealWithEvent(SmartHome smartHome, SensorEvent sensorEvent) {
        for (EventProcessor processor : processors) {
            processor.dealWithEvent(smartHome, sensorEvent);
        }

    }
}
