package ru.sbt.mipt.oop;


import ru.sbt.mipt.oop.alarm.Alarm;

import java.io.IOException;


public class Application {
    public static void main(String... args) {
        SmartHomeReader smartHomeReaderGson = new SmartHomeReaderGson("C:\\Users\\mi\\Desktop\\smart-home-1.js");
        SmartHome smartHome = smartHomeReaderGson.readSmartHome();
        EventSupplier randomEvent = new RandomEvent();
        smartHome.setAlarm(new Alarm("123"));
        SensorEvent event = randomEvent.getNextEvent();
        new EventHandler(smartHome, event).eventHandle();
    }
}