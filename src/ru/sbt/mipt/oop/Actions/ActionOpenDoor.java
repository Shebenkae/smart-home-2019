package ru.sbt.mipt.oop.Actions;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Room;

public class ActionOpenDoor implements Action {
    private String locid;
    private Door door;
    private String roomName;

    public ActionOpenDoor(String locid) {
        this.locid = locid;
    }

    @Override
    public void act(Object obj) {
        if (obj instanceof Door) {
            door = (Door) obj;
            if (locid.equals(door.getId())) {
                door.setOpen(true);
                System.out.println("Door " + door.getId() + " in room " + roomName + " was opened.");
            }
        }
        if (obj instanceof Room){
            getRoomName((Room) obj);
        }

    }

    private String getRoomName(Room room) {
        return roomName = room.getName();
    }
}