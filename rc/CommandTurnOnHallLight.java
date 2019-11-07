package ru.sbt.mipt.oop.rc;

import ru.sbt.mipt.oop.*;

public class CommandTurnOnHallLight implements Command {
    private SmartHome smartHome;

    public CommandTurnOnHallLight(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void perform() {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall"))
                for (Light light : room.getLights())
                    light.setOn(true);
        }
    }
}
