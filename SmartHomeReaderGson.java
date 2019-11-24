package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SmartHomeReaderGson implements SmartHomeReader {
    final private String filename;

    public SmartHomeReaderGson(String filename) {
        this.filename = filename;
    }

    public SmartHome readSmartHome(){
        Gson gson = new Gson();
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);
        return smartHome;
    }
}
