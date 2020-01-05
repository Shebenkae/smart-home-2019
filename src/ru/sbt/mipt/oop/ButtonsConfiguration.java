package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.buttons.*;
import ru.sbt.mipt.oop.alarm.*;

@Configuration
public class ButtonsConfiguration {
    @Bean
    RemoteControl remoteControlRealisation(CommandTurnAllLightOn commandTurnAllLightOn,
                                           CommandTurnAllLightOff commandTurnAllLightOff,
                                           CommandActivateAlarm commandActivateAlarm,
                                           CommandTurnOnHallLight hallLightOn,
                                           RemoteControlRegistry remoteControlRegistry,
                                           CommandAlarmDanger commandAlarmDanger,
                                           CommandCloseHallDoor commandCloseHallDoor) {
        RemoteController remoteControl = new RemoteController("1");
        remoteControl.setButton("A", commandTurnAllLightOff);
        remoteControl.setButton("B", commandTurnAllLightOn);
        remoteControl.setButton("C", commandActivateAlarm);
        remoteControl.setButton("D", hallLightOn);
        remoteControl.setButton("1", commandAlarmDanger);
        remoteControl.setButton("2", commandCloseHallDoor);
        remoteControlRegistry.registerRemoteControl(remoteControl, "1");
        return remoteControl;
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry() {
        return new RemoteControlRegistry();
    }

    @Bean
    CommandTurnAllLightOff commandTurnAllLightOff(SmartHome smartHome) {
        return new CommandTurnAllLightOff(smartHome);
    }

    @Bean
    CommandTurnAllLightOn commandTurnAllLightOn(SmartHome smartHome) {
        return new CommandTurnAllLightOn(smartHome);
    }

    @Bean
    CommandCloseHallDoor commandCloseHallDoor(SmartHome smartHome) {
        return new CommandCloseHallDoor(smartHome);
    }

    @Bean
    CommandTurnOnHallLight hallLightOn(SmartHome smartHome) {
        return new CommandTurnOnHallLight(smartHome);
    }

    @Bean
    CommandActivateAlarm commandActivateAlarm(Alarm alarm) {
        return new CommandActivateAlarm(alarm, "123");
    }

    @Bean
    CommandAlarmDanger commandAlarmDanger(Alarm alarm) {
        return new CommandAlarmDanger(alarm);
    }
}
