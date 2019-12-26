package ru.sbt.mipt.oop.buttons;

import ru.sbt.mipt.oop.Actions.Action;
import ru.sbt.mipt.oop.Actions.ActionLightOff;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class CommandTurnAllLightOn implements Command {
    private SmartHome smartHome;

    public CommandTurnAllLightOn(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void perform() {
        for (Room room:smartHome.getRooms()){
            for (Light light: room.getLights()){
                light.setOn(true);
            }
        }
    }
}
