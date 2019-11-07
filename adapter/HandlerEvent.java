//package ru.sbt.mipt.oop.adapter;
//
//import com.coolcompany.smarthome.events.CCSensorEvent;
//import ru.sbt.mipt.oop.SmartHome;
//import ru.sbt.mipt.oop.EventProcessor;
//
//
//public class HandlerEvent implements com.coolcompany.smarthome.events.EventHandler {
//    EventProcessor handler;
//    SmartHome smartHome;
//
//    public HandlerEvent(EventProcessor init_handler, SmartHome init_home) {
//        this.handler = init_handler;
//        this.smartHome = init_home;
//    }
//
//    public void handleEvent(CCSensorEvent event) {
//        handler.handleEvent(smartHome, (new EventAdapter(event)).getAdaptEvent());
//    }
//
//}