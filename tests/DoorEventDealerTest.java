package ru.sbt.mipt.oop.tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.io.IOException;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventDealerTest {
   @Test
    public void doortest1() throws IOException {
       SmartHomeReader smartHomeReader = new SmartHomeReaderGson("smart-home-1.js");
       SmartHome smartHome = smartHomeReader.readSmartHome();
       EventDealer eventDealer = new DoorEventProcessor();
       SensorEvent event = new SensorEvent(DOOR_CLOSED, "6");
       for (Room room: smartHome.getRooms()) {
           for (Door door : room.getDoors()) {
               eventDealer.dealwithEvent(smartHome, event, room, door);
           }
       }
       for (Room room: smartHome.getRooms()) {
           for (Door door : room.getDoors()) {
               if (door.getId().equals(event.getObjectId()))
               assert(door.getId().equals("6") && !door.isOpen());;
           }
       }
   }


    @Test
    public void doortest2() throws IOException {
    SmartHomeReader smartHomeReader = new SmartHomeReaderGson("smart-home-1.js");
    SmartHome smartHome = smartHomeReader.readSmartHome();
        EventDealer eventDealer = new DoorEventProcessor();
    SensorEvent event = new SensorEvent(DOOR_OPEN, "3");
        for (Room room: smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                eventDealer.dealwithEvent(smartHome, event, room, door);
            }
        }
        for (Room room: smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId()))
                assert(door.isOpen() || door.getId().equals("3"));;
            }
        }
    }

}
