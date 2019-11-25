package ru.sbt.mipt.oop.Actions;

import ru.sbt.mipt.oop.Actions.Action;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;

public class ActionLightOn implements Action {
    private String locid;
    private Light light;
    private String roomName;

    public ActionLightOn(String locid) {
        this.locid = locid;
    }

    @Override
    public void act(Object obj) {
        if (obj instanceof Light) {
            light = (Light) obj;
            if (locid.equals(light.getId())) {
                light.setOn(true);
                System.out.println("Light " + light.getId() + " in room " + roomName + " was turned on.");
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