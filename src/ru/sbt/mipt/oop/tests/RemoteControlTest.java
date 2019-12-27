package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SmartHomeConfiguration;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlarmActive;
import ru.sbt.mipt.oop.alarm.AlarmDanger;
import ru.sbt.mipt.oop.buttons.RemoteControl;

import static junit.framework.TestCase.assertTrue;

public class RemoteControlTest {
    @Test
    public void TestDangerAlarmState() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfiguration.class);
        Alarm alarm = context.getBean(Alarm.class);
        RemoteControl remoteControl = (RemoteControl) context.getBean("remoteControlRealisation");

        remoteControl.onButtonPressed("1");
        assertTrue(alarm.getAlarmState() instanceof AlarmDanger);
    }
    @Test
    public void TestActivationAlarmState() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfiguration.class);
        Alarm alarm = context.getBean(Alarm.class);
        RemoteControl remoteControl = (RemoteControl) context.getBean("remoteControlRealisation");

        remoteControl.onButtonPressed("C");
        assertTrue(alarm.getAlarmState() instanceof AlarmActive);
    }
    @Test
    public void TestHallDoorClosed() {
        boolean flag = false;
        ApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfiguration.class);
        SmartHome smartHome = context.getBean(SmartHome.class);
        RemoteControl remoteControl = (RemoteControl) context.getBean("remoteControlRealisation");
        remoteControl.onButtonPressed("2");
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("Hall")) {
                for (Door door : room.getDoors()) {
                    if (door.isOpen()) {
                        flag = true;
                    }
                }
            }
        }
        Assert.assertFalse(flag);
    }
}
