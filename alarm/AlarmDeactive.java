package ru.sbt.mipt.oop.alarm;

public class AlarmDeactive extends AlarmState {

    public AlarmDeactive(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void activateAlarm(String pass) {
        alarm.activateAlarm();
    }

    @Override
    public void alarmDanger() {
        alarm.alarmDanger();
    }

    @Override
    public void deactivateAlarm(String pass) {
        System.out.println("Alarm was actually deactivated before");
    }
}
