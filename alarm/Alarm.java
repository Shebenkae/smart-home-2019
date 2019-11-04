package ru.sbt.mipt.oop.alarm;

public class Alarm {
    private String code;
    private AlarmState alarmState;
    private boolean isActive;

    public Alarm(String initcode) {
        this.code = initcode;
        isActive = false;
    }

    public AlarmState getAlarmState() {
        return alarmState;
    }

    public String getCode() {
        return code;
    }

    public void activatealarm() {
        isActive = true;
        alarmState = new AlarmActive(this);
    }

    public void deactivatealarm() {
        isActive = false;
        alarmState = new AlarmDeactive(this);
    }

    public void alarmdanger() {
        alarmState = new AlarmDanger(this);
    }
}
