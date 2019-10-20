package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventDealer {
    @Override
    public void dealwithEvent(SmartHome home, SensorEvent event, Room room, Object obj) {
    if (obj instanceof Light){
        Light light = (Light) obj;
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        onLights(light, room);
                    } else
                    {
                offLights(light, room);}
                }
            }
        }

    private void onLights (Light light, Room room){
        light.setOn(true);
        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
    }
    private void offLights (Light light, Room room){
        light.setOn(false);
        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
    }
}
