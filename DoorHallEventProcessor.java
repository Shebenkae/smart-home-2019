package ru.sbt.mipt.oop;

public class DoorHallEventProcessor implements EventProcessor {
    @Override
    public void dealwithEvent(SmartHome home, SensorEvent event) {
        if (event.getType() == SensorEventType.DOOR_CLOSED && event.getObjectId().equals("4")) {
            Action<Light> hallaction = new ActionLightOff("all");
            home.execute(hallaction);
            Action<Door> doorAction = new ActionCloseDoor(event.getObjectId());
            home.execute(doorAction);
        }
    }
}