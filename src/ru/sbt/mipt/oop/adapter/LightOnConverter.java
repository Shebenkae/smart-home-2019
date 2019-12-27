package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SensorEvent;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightOnConverter implements CCSensorEventConverter {
    private CCSensorEventConverter nextEventConverter;

    public LightOnConverter(CCSensorEventConverter nextEventConverter){
        this.nextEventConverter = nextEventConverter;
    }

    @Override
    public SensorEvent convert(CCSensorEvent ccSensorEvent) {
        if (ccSensorEvent.getEventType().equals("LightIsOn"))
            return new SensorEvent(LIGHT_ON, ccSensorEvent.getObjectId());
        return nextEventConverter.convert(ccSensorEvent);
    }
}