package ru.sbt.mipt.oop.alarm;

public class Alarm {
    private String code;
    private AlarmState alarmState;
    private boolean isActive;

    public Alarm(String initcode) {
        this.code = initcode;
        isActive = false;
        alarmState = new AlarmDeactive(this);
    }

    public AlarmState getAlarmState() {
        return alarmState;
    }

    public String getCode() {
        return code;
    }

    public void activateAlarm() {
        isActive = true;
        alarmState = new AlarmActive(this);
    }

    public void deactivateAlarm() {
        isActive = false;
        alarmState = new AlarmDeactive(this);
    }

    public void alarmDanger() {
        alarmState = new AlarmDanger(this);
    }
}
