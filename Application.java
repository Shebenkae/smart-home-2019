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
            private static Collection<EventDealer> getEvents(){
                Collection<EventDealer> eventDealers = new ArrayList<>();
                eventDealers.add(new LightEventProcessor());
                eventDealers.add(new DoorEventProcessor());
                eventDealers.add(new DoorHallEventProcessor());
                return eventDealers;
            }
        private static void checkEvents (SmartHome smartHome) {
            EventSupplier randomEvent = new RandomEvent();
            SensorEvent event = randomEvent.getNextEvent();
            Collection<EventDealer> events = getEvents();

            while (event != null) {
                System.out.println("Got event: " + event);
                Action action = new Action(smartHome, events, event);
                smartHome.execute(action);
                event = randomEvent.getNextEvent();
            }
        }

}