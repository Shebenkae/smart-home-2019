package ru.sbt.mipt.oop;


import java.io.IOException;


public class Application {
    public static void main(String... args) {
        SmartHomeReader smartHomeReaderGson = new SmartHomeReaderGson("C:\\Users\\mi\\Desktop\\smart-home-1.js");
        SmartHome smartHome = smartHomeReaderGson.readSmartHome();
        EventSupplier randomEvent = new RandomEvent();
        SensorEvent event = randomEvent.getNextEvent();
        new EventHandler(smartHome, event).eventHandle();
    }
}