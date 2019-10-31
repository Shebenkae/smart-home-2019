package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor {
    @Override
    public void dealwithEvent(SmartHome home, SensorEvent event) {
        if (event.getType() == LIGHT_ON) {
            Action<Light> lightAction = new ActionLightOn(event.getObjectId());
            home.execute(lightAction);
        } else if (event.getType() == LIGHT_OFF) {
            Action<Light> lightAction = new ActionLightOff(event.getObjectId());
            home.execute(lightAction);
        }
    }
}