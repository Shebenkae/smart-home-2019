package ru.sbt.mipt.oop.alarm;

public class AlarmActive extends AlarmState {

    public AlarmActive(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void activatealarm(String pass) {
        System.out.println("Alarm was actually activated before");
    }

    @Override
    public void deactivatealarm(String pass) {
        if (alarm.getCode().equals(pass)) {
        alarm.deactivatealarm();
        }
        else {
            alarm.alarmdanger();
        }
    }
}
