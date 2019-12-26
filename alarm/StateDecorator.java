package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class StateDecorator implements EventProcessor {
    EventProcessor wrapper;

    public StateDecorator(EventProcessor eventProcessor) {
        this.wrapper = eventProcessor;
    }

    @Override
    public void dealWithEvent(SmartHome home, SensorEvent event) {
        if (home.getAlarm().getAlarmState() instanceof AlarmActive) {
            home.getAlarm().alarmDanger();
            System.out.println("DANGER!!!");
        } else if (home.getAlarm().getAlarmState() instanceof AlarmDanger) {
            System.out.println("DANGER!!!");
        } else {
            wrapper.dealWithEvent(home, event);
        }
    }
}

