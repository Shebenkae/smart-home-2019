package ru.sbt.mipt.oop;

public interface EventProcessor {
    void dealWithEvent(SmartHome home, SensorEvent event);
}
