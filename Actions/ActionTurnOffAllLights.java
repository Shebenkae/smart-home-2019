package ru.sbt.mipt.oop.Actions;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;

public class ActionTurnOffAllLights implements Action {
    private Light light;
    private String roomName;

    @Override
    public void act(Object obj) {
        if (obj instanceof Light) {
            light = (Light) obj;
            light.setOn(false);
            System.out.println("Light " + light.getId() + " in room " + roomName + " was turned off.");
        }
        if (obj instanceof Room) {
            getRoomName((Room) obj);
        }
    }
    private String getRoomName(Room room) {
        return roomName = room.getName();
    }
}

