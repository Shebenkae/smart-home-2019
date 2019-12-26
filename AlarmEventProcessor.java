package ru.sbt.mipt.oop;

public class AlarmEventProcessor implements EventProcessor {

    @Override
    public void dealWithEvent(SmartHome home, SensorEvent event){
        if (event instanceof  SensorEventAlarm) {
            if (event.getType().equals(SensorEventType.ALARM_ACTIVATED)) {
                home.getAlarm().getAlarmState().activateAlarm(((SensorEventAlarm) event).getPass());
            }
            if (event.getType().equals(SensorEventType.ALARM_DEACTIVATED)) {
                home.getAlarm().getAlarmState().deactivateAlarm(((SensorEventAlarm) event).getPass());
            }
        }
    }
}
