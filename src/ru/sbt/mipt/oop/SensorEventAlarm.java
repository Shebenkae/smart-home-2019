package ru.sbt.mipt.oop;

public class SensorEventAlarm extends SensorEvent {
    private String pass;
    public SensorEventAlarm(SensorEventType type, String pass) {
        super(type, "-1");
        this.pass = pass;
    }
    public String getPass(){
        return pass;
    }
}
