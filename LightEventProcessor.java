package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Actions.ActionLightOff;
import ru.sbt.mipt.oop.Actions.ActionLightOn;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor {
    @Override
    public void dealWithEvent(SmartHome home, SensorEvent event) {
        if (event.getType() == LIGHT_ON) {
            Action lightAction = new ActionLightOn(event.getObjectId());
            home.execute(lightAction);
        } else if (event.getType() == LIGHT_OFF) {
            Action lightAction = new ActionLightOff(event.getObjectId());
            home.execute(lightAction);
        }
    }
}