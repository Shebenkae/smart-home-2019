package ru.sbt.mipt.oop.Actions;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Room;

public class ActionCloseDoor implements Action {
    private String locid;
    private Door door;
    private String roomName;

    public ActionCloseDoor(String locid) {
        this.locid = locid;
    }

    @Override
    public void act(Object obj) {
        if (obj instanceof Door) {
            door = (Door) obj;
            if (locid.equals(door.getId())) {
                door.setOpen(false);
                System.out.println("Door " + door.getId() + " in room " + roomName + " was closed.");
            }
        }
        if (obj instanceof Room) {
            getRoomName((Room) obj);
        }

    }

    private String getRoomName(Room room) {
        return roomName = room.getName();
    }
}
