package ru.sbt.mipt.oop;

public class AlarmEventProcessor implements EventProcessor {

    @Override
    public void dealwithEvent(SmartHome home, SensorEvent event) {
        if (event.getType().equals(SensorEventType.ALARM_ACTIVATED)) {
            home.getAlarm().getAlarmState().activatealarm(((SensorEventAlarm) event).getPass());
        }
        if (event.getType().equals(SensorEventType.ALARM_DEACTIVATED)) {
            home.getAlarm().getAlarmState().deactivatealarm(((SensorEventAlarm) event).getPass());
        }
    }
}
