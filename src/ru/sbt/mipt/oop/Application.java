package ru.sbt.mipt.oop;


import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.alarm.Alarm;

import java.io.IOException;


public class Application {
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfiguration.class);
        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
        sensorEventsManager.start();
//        SmartHomeReader smartHomeReaderGson = new SmartHomeReaderGson("C:\\Users\\mi\\Desktop\\smart-home-1.js");
//        SmartHome smartHome = smartHomeReaderGson.readSmartHome();
//        EventSupplier randomEvent = new RandomEvent();
//        smartHome.setAlarm(new Alarm("123"));
//        SensorEvent event = randomEvent.getNextEvent();
//        new EventHandler(smartHome, event).eventHandle();
    }
}