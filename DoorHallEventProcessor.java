package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Actions.Action;
import ru.sbt.mipt.oop.Actions.ActionCloseDoor;
import ru.sbt.mipt.oop.Actions.ActionLightOff;
import ru.sbt.mipt.oop.Actions.ActionTurnOffAllLights;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class DoorHallEventProcessor implements EventProcessor {
    @Override
    public void dealWithEvent(SmartHome home, SensorEvent event) {
        home.execute((object) -> {
            if (event.getType() == DOOR_CLOSED) {
                if (object instanceof Room) {
                    Room room = (Room) object;
                    room.execute(obj -> {
                        if (obj instanceof Door){
                            Door door = (Door) obj;
                            if (door.getId().equals(event.getObjectId())){
                                if (room.getName().equals("hall")) {
                                    Action hallaction = new ActionTurnOffAllLights();
                                    home.execute(hallaction);
                                }
                            }
                        }
                    });
                }
            }
        });
    }
}
