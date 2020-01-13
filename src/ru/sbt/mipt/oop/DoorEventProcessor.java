package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Actions.ActionCloseDoor;
import ru.sbt.mipt.oop.Actions.ActionOpenDoor;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {

    @Override
    public void dealWithEvent(SmartHome home, SensorEvent event) {
        if (event.getType() == DOOR_OPEN) {
            Action doorAction = new ActionOpenDoor(event.getObjectId());
            home.execute(doorAction);
        } else if (event.getType() == DOOR_CLOSED) {
            Action doorAction = new ActionCloseDoor(event.getObjectId());
            home.execute(doorAction);
        }
    }
}
