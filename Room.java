package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    public void execute(Action action) {
        if (action.getName().equals("light"))
         {
            for (Light light : lights) {
                action.act(light, name);
            }
        }

        if (action.getName().equals("door")) {
            for (Door door : doors) {
                action.act(door, name);
            }
        }
    }
}