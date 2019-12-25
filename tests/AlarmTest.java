package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.alarm.*;

import java.io.IOException;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class AlarmTest {
    @Test
    public void testsucces() throws IOException {
        SmartHomeReader smartHomeReader = new SmartHomeReaderGson("C:\\Users\\mi\\Desktop\\smart-home-1.js");
        SmartHome smarthome = smartHomeReader.readSmartHome();
        Alarm alarm = new Alarm("1234");
        smarthome.setAlarm(alarm);
        AlarmEventProcessor eventProcessor = new AlarmEventProcessor();
        SensorEvent test_activate = new SensorEventAlarm(ALARM_ACTIVATED, "1234");
        SensorEvent test_deactivate = new SensorEventAlarm(ALARM_DEACTIVATED, "1234");
        SensorEvent event = new SensorEvent(DOOR_OPEN, "3");
        eventProcessor.dealwithEvent(smarthome, event);
        eventProcessor.dealwithEvent(smarthome, test_activate);
        Assert.assertTrue(smarthome.getAlarm().getAlarmState() instanceof AlarmActive);

        eventProcessor.dealwithEvent(smarthome, test_deactivate);
        Assert.assertTrue(smarthome.getAlarm().getAlarmState() instanceof AlarmDeactive);

    }


    @Test
    public void testdanger() throws IOException {
        SmartHomeReader smartHomeReader = new SmartHomeReaderGson("C:\\Users\\mi\\Desktop\\smart-home-1.js");
        SmartHome smarthome = smartHomeReader.readSmartHome();
        Alarm alarm = new Alarm("1234");
        smarthome.setAlarm(alarm);
        EventProcessor eventProcessor = new StateDecorator( new AlarmEventProcessor());
        SensorEvent test_activate = new SensorEventAlarm(ALARM_ACTIVATED, "1234");
        SensorEvent test_deactivate = new SensorEventAlarm(ALARM_DEACTIVATED, "12345");
        SensorEvent event1 = new SensorEvent(LIGHT_ON, "2");
        eventProcessor.dealwithEvent(smarthome, test_activate);
        eventProcessor.dealwithEvent(smarthome, test_deactivate);
        Assert.assertTrue(smarthome.getAlarm().getAlarmState() instanceof AlarmDanger);
        eventProcessor.dealwithEvent(smarthome, event1);
        for (Room room: smarthome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event1.getObjectId()))
                   Assert.assertFalse(light.isOn());
            }
        }
    }
}


