package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SensorEvent;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorOpenConverter implements CCSensorEventConverter {
    private CCSensorEventConverter nextEventConverter;

    public DoorOpenConverter(CCSensorEventConverter nextEventConverter) {
        this.nextEventConverter = nextEventConverter;
    }

    @Override
    public SensorEvent convert(CCSensorEvent ccSensorEvent) {
        if (ccSensorEvent.getEventType().equals("DoorIsOpen") || ccSensorEvent.getEventType().equals("DoorIsUnlocked"))
            return new SensorEvent(DOOR_OPEN, ccSensorEvent.getObjectId());
        return nextEventConverter.convert(ccSensorEvent);
    }
}
