package ru.sbt.mipt.oop.tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.io.IOException;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class HallDoorTest {
    @Test
    public void halltest1() throws IOException {
        SmartHomeReader smartHomeReader = new SmartHomeReaderGson("C:\\Users\\mi\\Desktop\\smart-home-1.js");
        SmartHome smartHome = smartHomeReader.readSmartHome();
        EventProcessor eventDealer = new DoorHallEventProcessor();
        SensorEvent event = new SensorEvent(DOOR_CLOSED, "4");
        eventDealer.dealwithEvent(smartHome, event);
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                assert (!light.isOn());
            }
        }
    }
}

