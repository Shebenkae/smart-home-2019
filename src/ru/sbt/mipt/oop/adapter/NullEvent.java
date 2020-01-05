package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SensorEvent;

public class NullEvent implements CCSensorEventConverter {
    @Override
    public SensorEvent convert(CCSensorEvent ccSensorEvent) {
        return null;
    }
}
