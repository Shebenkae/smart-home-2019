package ru.sbt.mipt.oop.buttons;

import ru.sbt.mipt.oop.*;

public class CommandCloseHallDoor implements Command {
    private SmartHome smartHome;

    public CommandCloseHallDoor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void perform() {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall"))
                for (Door door : room.getDoors())
                    door.setOpen(false);
        }
    }
}
