package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {

    @Override

    public void dealwithEvent(SmartHome home, SensorEvent event) {
        if (event.getType() == DOOR_OPEN) {
            Action<Door> doorAction = new ActionOpenDoor(event.getObjectId());
            home.execute(doorAction);
        } else if (event.getType() == DOOR_CLOSED) {
            Action<Door> doorAction = new ActionCloseDoor(event.getObjectId());
            home.execute(doorAction);
        }
    }
}
