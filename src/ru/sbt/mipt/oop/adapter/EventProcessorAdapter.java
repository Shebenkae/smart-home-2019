package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;

public class EventProcessorAdapter implements EventHandler {
    private EventProcessor eventProcessor;
    private SmartHome smartHome;
    private CCSensorEventConverter eventAdapter;

    public EventProcessorAdapter(EventProcessor eventProcessor, SmartHome smartHome, CCSensorEventConverter eventAdapter) {
        this.eventProcessor = eventProcessor;
        this.smartHome = smartHome;
        this.eventAdapter = eventAdapter;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        eventProcessor.dealWithEvent(smartHome, eventAdapter.convert(event));
    }
}