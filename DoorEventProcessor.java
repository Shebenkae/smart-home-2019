package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventDealer {
    @Override
    public void dealwithEvent(SmartHome home, SensorEvent event, Room room, Object obj) {
        if (obj instanceof Door) {
            Door door = (Door) obj;
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        opendoor(door, room);
                    } else
                        closedoor(door, room);
            }
        }
    }
    private void opendoor (Door door, Room room){
        door.setOpen(true);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
    }
    private void closedoor (Door door, Room room){
        door.setOpen(false);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
    }
}
