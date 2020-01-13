        package ru.sbt.mipt.oop;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Collection;


public class Application {
    public static void main(String... args) throws IOException {
        SmartHomeReader smartHomeReaderGson = new SmartHomeReaderGson("smart-home-1.js");
        SmartHome smartHome = smartHomeReaderGson.readSmartHome();
        checkEvents(smartHome);
        }
        private static void checkEvents (SmartHome smartHome) {
            SensorEvent event = RandomEvent.getNextSensorEvent();
            EventDealer eventDealerLight = new LightEventDealer();
            EventDealer eventDealerDoor = new DoorEventDealer();
            EventDealer eventdoorhallDealer = new DoorEventDealerHall();
            while (event != null) {
                System.out.println("Got event: " + event);
                eventDealerDoor.dealwithEvent(smartHome, event);
                eventDealerLight.dealwithEvent(smartHome, event);
                eventdoorhallDealer.dealwithEvent(smartHome, event);
                event = RandomEvent.getNextSensorEvent();
            }
        }
}