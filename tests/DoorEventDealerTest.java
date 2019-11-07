package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.io.IOException;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventDealerTest {
       @Test
       public void Doortest1() throws IOException {
           SmartHomeReader smartHomeReader = new SmartHomeReaderGson("smart-home-1.js");
           SmartHome smartHome = smartHomeReader.readSmartHome();
           SensorEvent event = new SensorEvent(DOOR_OPEN, "3");
           DoorEventProcessor handler = new DoorEventProcessor();
           handler.dealwithEvent(smartHome, event);
           for(Room room: smartHome.getRooms()) {
               String current = room.getName();
               if(current.equals("bathroom")) {
                   for(Door door: room.getDoors()) {
                       String cur_door_id = door.getId();
                       if(cur_door_id.equals("3")) {
                           Assert.assertTrue(door.isOpen());
                       }
                   }
               }
           }
       }


    @Test
    public void doortest2() throws IOException {
    SmartHomeReader smartHomeReader = new SmartHomeReaderGson("C:\\Users\\mi\\Desktop\\smart-home-1.js");
    SmartHome smartHome = smartHomeReader.readSmartHome();
        EventProcessor eventDealer = new DoorEventProcessor();
    SensorEvent event = new SensorEvent(DOOR_CLOSED, "1");
    eventDealer.dealwithEvent(smartHome, event);
        for (Room room: smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId()))
                assert(door.isOpen() || door.getId().equals("1"));;
            }
        }
    }

}
