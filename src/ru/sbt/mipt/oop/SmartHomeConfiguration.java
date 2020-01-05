package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import ru.sbt.mipt.oop.adapter.*;
import ru.sbt.mipt.oop.alarm.Alarm;

import java.util.Collection;

@Configuration
@Import(ButtonsConfiguration.class)
public class SmartHomeConfiguration {
    @Bean
    public SensorEventsManager sensorEventsManager(EventProcessor eventProcessor, SmartHome smartHome, CCSensorEventConverter eventAdapter) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(new EventProcessorAdapter(eventProcessor, smartHome, eventAdapter));
        return sensorEventsManager;
    }

    @Bean
    public SmartHome smartHome(Alarm alarm) {
        SmartHome smartHome = new SmartHomeReaderGson("C:\\Users\\mi\\Desktop\\smart-home-1.js").readSmartHome();
        smartHome.setAlarm(alarm);
        return smartHome;

    }

    @Bean
    public Alarm alarm() {
        return new Alarm("123");
    }

    @Bean
    @Primary
    public EventProcessor eventProcessor(Collection<EventProcessor> eventProcessors) {
        return new StateDecorator((new HandleEventProcessor(eventProcessors)));
    }

    @Bean
    public EventProcessor lightEventProcessor() {
        return new LightEventProcessor();
    }

    @Bean
    public EventProcessor doorEventProcessor() {
        return new DoorEventProcessor();
    }

    @Bean
    public EventProcessor hallEventProcessor() {
        return new DoorHallEventProcessor();
    }

    @Bean
    public EventProcessor alarmEventProcessor() {
        return new AlarmEventProcessor();
    }

    @Bean
    public CCSensorEventConverter eventAdapter(LightOffConverter lightIsOffAdapter) {
        return new LightOnConverter(lightIsOffAdapter);
    }

    @Bean
    public LightOffConverter lightOffAdapter(DoorOpenConverter doorIsOpenAdapter) {
        return new LightOffConverter(doorIsOpenAdapter);
    }

    @Bean
    public DoorOpenConverter doorOpenAdapter(DoorClosedConverter doorIsClosedAdapter) {
        return new DoorOpenConverter(doorIsClosedAdapter);
    }

    @Bean
    public DoorClosedConverter doorClosedAdapter(NullEvent nullAdapter) {
        return new DoorClosedConverter(nullAdapter);
    }

    @Bean
    public NullEvent nullEvent() {
        return new NullEvent();
    }
}
