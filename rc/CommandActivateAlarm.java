package ru.sbt.mipt.oop.rc;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.alarm.Alarm;

public class CommandActivateAlarm implements Command {
    private Alarm alarm;
    private String code;

    public CommandActivateAlarm(Alarm alarm, String code) {
        this.alarm = alarm;
        this.code = code;
    }

    @Override
    public void perform() {
        if (alarm.getCode().equals(code))
            alarm.activatealarm();
    }
}
