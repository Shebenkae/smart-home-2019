package ru.sbt.mipt.oop.alarm;

public abstract class AlarmState {
    public Alarm alarm;

    public AlarmState(Alarm alarm) {
        this.alarm = alarm;
    }

    public abstract void deactivateAlarm(String pass);

    public abstract void activateAlarm(String pass);

    public abstract void alarmDanger();

}
