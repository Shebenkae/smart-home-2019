package ru.sbt.mipt.oop.rc;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.ActionLightOff;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;

public class CommandTurnAllLightsOff implements Command {
    private SmartHome smartHome;

    public CommandTurnAllLightsOff(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void perform() {
        Action<Light> lightAction = new ActionLightOff("all");
        smartHome.execute(lightAction);
    }
}
