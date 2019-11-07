package ru.sbt.mipt.oop.rc;

import ru.sbt.mipt.oop.*;

public class CommandTurnAllLightOff implements Command {
    private SmartHome smartHome;

    public CommandTurnAllLightOff(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void perform() {
        {
            Action<Light> lightAction = new ActionLightOn("all");
            smartHome.execute(lightAction);
        }
    }
}
