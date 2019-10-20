package ru.sbt.mipt.oop;

public class DoorHallEventProcessor implements EventDealer {
    @Override
    public void dealwithEvent(SmartHome home, SensorEvent event, Room room, Object obj) {
        if (obj instanceof Door) {
            Door door = (Door) obj;
            if (door.getId().equals(event.getObjectId()) && event.getType() == SensorEventType.DOOR_CLOSED && room.getName().equals("hall")) {
                                    for (Room homeroom: home.getRooms())
                                    for (Light light : homeroom.getLights()) {
                                        light.setOn(false);
                                        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                                        CommandSender sender = new CommandSender();
                                        sender.sendCommand(command);
                                    }
                                }
                            }
                        }
                    }