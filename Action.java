package ru.sbt.mipt.oop;

public interface Action <T> {
   void act (T obj, String roomName);
   String getName();
}
