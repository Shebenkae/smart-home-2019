package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.AlarmActive;
import ru.sbt.mipt.oop.alarm.AlarmDanger;

public class StateDecorator implements EventProcessor {
    EventProcessor wrapper;

    public StateDecorator(EventProcessor eventProcessor) {
        this.wrapper = eventProcessor;
    }

    @Override
    public void dealwithEvent(SmartHome home, SensorEvent event) {
        if (home.getAlarm().getAlarmState() instanceof AlarmActive) {
            home.getAlarm().alarmDanger();
            System.out.println("DANGER!!!");
        } else if (home.getAlarm().getAlarmState() instanceof AlarmDanger) {
            System.out.println("DANGER!!!");
        } else {
            wrapper.dealwithEvent(home, event);
        }
    }
}

