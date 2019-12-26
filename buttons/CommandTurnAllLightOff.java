package ru.sbt.mipt.oop.buttons;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.Actions.Action;
import ru.sbt.mipt.oop.Actions.ActionLightOn;
import ru.sbt.mipt.oop.Actions.ActionTurnOffAllLights;

public class CommandTurnAllLightOff implements Command {
    private SmartHome smartHome;

    public CommandTurnAllLightOff(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void perform() {
        {
            Action lightAction = new ActionTurnOffAllLights();
            smartHome.execute(lightAction);
        }
    }
}
