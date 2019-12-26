package ru.sbt.mipt.oop.alarm;

public class AlarmDanger extends AlarmState {

    public AlarmDanger(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void activateAlarm(String pass) {

    }

    @Override
    public void alarmDanger() {

    }

    @Override
    public void deactivateAlarm(String pass) {
    if (alarm.getCode().equals(pass))
        alarm.deactivateAlarm();
    }
}
