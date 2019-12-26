package ru.sbt.mipt.oop.buttons;

import ru.sbt.mipt.oop.alarm.Alarm;

public class CommandAlarmDanger implements Command {
    private Alarm alarm;

    public CommandAlarmDanger(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void perform() {
        alarm.alarmDanger();
    }
}
