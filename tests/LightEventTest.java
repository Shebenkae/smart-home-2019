package ru.sbt.mipt.oop.tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.io.IOException;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventTest {
    @Test
    public void Lighttest1()throws IOException {
        SmartHomeReader smartHomeReader = new SmartHomeReaderGson("smart-home-1.js");
        SmartHome smartHome = smartHomeReader.readSmartHome();
        EventDealer eventDealer = new LightEventProcessor();
        SensorEvent event = new SensorEvent(LIGHT_ON, "3");
        for (Room room: smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                eventDealer.dealwithEvent(smartHome, event, room, light);
            }
        }
        for (Room room: smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId()))
                    assert(light.isOn());;
            }
        }
    }
    @Test
    public void Lighttest2()throws IOException {
        SmartHomeReader smartHomeReader = new SmartHomeReaderGson("smart-home-1.js");
        SmartHome smartHome = smartHomeReader.readSmartHome();
        EventDealer eventDealer = new LightEventProcessor();
        SensorEvent event = new SensorEvent(LIGHT_OFF, "11");
        for (Room room: smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                eventDealer.dealwithEvent(smartHome, event, room, light);
            }
        }
        for (Room room: smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId()))
                    assert(!light.isOn() && light.getId().equals("11"));;
            }
        }
    }
}
