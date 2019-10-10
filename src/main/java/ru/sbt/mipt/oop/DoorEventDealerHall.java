package ru.sbt.mipt.oop;

public class DoorEventDealerHall implements EventDealer {
    @Override
    public void dealwithEvent(SmartHome home, SensorEvent event) {
        if (event.getType() == SensorEventType.DOOR_CLOSED) {
            for (Room room : home.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(event.getObjectId())) {
                        if (room.getName().equals("hall")) {
                            for (Room homeRoom : home.getRooms()) {
                                for (Light light : homeRoom.getLights()) {
                                    light.setOn(false);
                                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                                    CommandSender sender = new CommandSender();
                                    sender.sendCommand(command);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
