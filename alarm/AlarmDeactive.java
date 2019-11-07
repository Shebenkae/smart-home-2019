package ru.sbt.mipt.oop.alarm;

public class AlarmDeactive extends AlarmState {

    public AlarmDeactive(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void activatealarm(String pass) {
        if (alarm.getCode().equals(pass)) {
            alarm.activatealarm();
        }

    }

    @Override
    public void deactivatealarm(String pass) {
        System.out.println("Alarm was actually deactivated before");
    }
}
