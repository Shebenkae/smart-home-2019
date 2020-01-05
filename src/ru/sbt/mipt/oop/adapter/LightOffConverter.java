package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SensorEvent;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;

public class LightOffConverter implements CCSensorEventConverter {
    private CCSensorEventConverter nextEventConverter;

    public LightOffConverter(CCSensorEventConverter nextEventConverter){
        this.nextEventConverter = nextEventConverter;
    }

    @Override
    public SensorEvent convert(CCSensorEvent ccSensorEvent) {
        if (ccSensorEvent.getEventType().equals("LightIsOff"))
            return new SensorEvent(LIGHT_OFF, ccSensorEvent.getObjectId());
        return nextEventConverter.convert(ccSensorEvent);
    }
}