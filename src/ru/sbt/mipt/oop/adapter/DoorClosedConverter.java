package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SensorEvent;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class DoorClosedConverter implements CCSensorEventConverter {
    private CCSensorEventConverter nextEventConverter;

    public DoorClosedConverter(CCSensorEventConverter nextEventConverter) {
        this.nextEventConverter = nextEventConverter;
    }

    @Override
    public SensorEvent convert(CCSensorEvent ccSensorEvent) {
        if (ccSensorEvent.getEventType().equals("DoorIsClosed") || ccSensorEvent.getEventType().equals("DoorIsLocked"))
            return new SensorEvent(DOOR_CLOSED, ccSensorEvent.getObjectId());
        return nextEventConverter.convert(ccSensorEvent);
    }
}
