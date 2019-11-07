package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.io.IOException;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class LightEventTest {
    @Test
    public void Lighttest1()throws IOException {
        SmartHomeReader smartHomeReader = new SmartHomeReaderGson("smart-home-1.js");
        SmartHome smartHome = smartHomeReader.readSmartHome();
        EventProcessor eventDealer = new LightEventProcessor();
        SensorEvent event = new SensorEvent(LIGHT_ON, "3");
                eventDealer.dealwithEvent(smartHome, event);
        for (Room room: smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId()))
                    assert(light.isOn());;
            }
        }
    }

    @Test
    public void Lighttest2()throws IOException {
        SmartHomeReader smartHomeReader = new SmartHomeReaderGson("C:\\Users\\mi\\Desktop\\smart-home-1.js");
        SmartHome smartHome = smartHomeReader.readSmartHome();
        EventProcessor eventDealer = new LightEventProcessor();
        SensorEvent event = new SensorEvent(LIGHT_OFF, "1");
                eventDealer.dealwithEvent(smartHome, event);
        for (Room room: smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId()))
                    assert(!light.isOn() && light.getId().equals("1"));;
            }
        }
    }
}
