package ru.sbt.mipt.oop.alarm;

public abstract class AlarmState {
    public Alarm alarm;

    public AlarmState(Alarm alarm) {
        this.alarm = alarm;
    }

    public abstract void deactivatealarm(String pass);

    public abstract void activatealarm(String pass);

}
