package ru.sbt.mipt.oop.alarm;

public class AlarmActive extends AlarmState {

    public AlarmActive(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void activateAlarm(String pass) {
        System.out.println("Alarm was actually activated before");
    }

    @Override
    public void alarmDanger() {
        alarm.alarmDanger();
    }

    @Override
    public void deactivateAlarm(String pass) {
        if (alarm.getCode().equals(pass)) {
            alarm.deactivateAlarm();
        } else {
            alarm.alarmDanger();
        }
    }
}
