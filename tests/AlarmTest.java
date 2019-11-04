package ru.sbt.mipt.oop.tests;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATED;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATED;
import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlarmActive;
import ru.sbt.mipt.oop.alarm.AlarmDeactive;

import java.io.IOException;

public class AlarmTest {
    @Test
    public void testsucces() throws IOException {
        SmartHomeReader smartHomeReader = new SmartHomeReaderGson("C:\\Users\\mi\\Desktop\\smart-home-1.js");
        SmartHome smarthome = smartHomeReader.readSmartHome();
        Alarm alarm = new Alarm("1234");
        smarthome.setAlarm(alarm);
        AlarmEventProcessor eventProcessor = new AlarmEventProcessor();
        SensorEvent test_activate = new SensorEventAlarm(ALARM_ACTIVATED,  "1234");
        SensorEvent test_deactivate = new SensorEventAlarm(ALARM_DEACTIVATED,  "1234");

        eventProcessor.dealwithEvent(smarthome, test_activate);
        Assert.assertTrue(smarthome.getAlarm().getAlarmState() instanceof AlarmActive);

        eventProcessor.dealwithEvent(smarthome, test_deactivate);
        Assert.assertTrue(smarthome.getAlarm().getAlarmState() instanceof AlarmDeactive);

    }
}
