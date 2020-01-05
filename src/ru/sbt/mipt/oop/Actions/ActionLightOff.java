package ru.sbt.mipt.oop.Actions;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;

public class ActionLightOff implements Action {
    private String locid;
    private Light light;
    private String roomName;

    public ActionLightOff(String locid) {
        this.locid = locid;
    }

    @Override
    public void act(Object obj) {
        if (obj instanceof Light) {
            light = (Light) obj;
            if (locid.equals(light.getId())) {
                light.setOn(false);
                System.out.println("Light " + light.getId() + " in room " + roomName + " was turned off.");
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
