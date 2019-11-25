package ru.sbt.mipt.oop;

public class ActionLightOff implements Action<Light> {
    private String locid;

    public ActionLightOff(String locid) {
        this.locid = locid;
    }

    @Override
    public void act(Light obj, String roomName) {
        if (locid.equals(obj.getId()) || locid.equals("all")) {
            obj.setOn(false);
            System.out.println("Light " + obj.getId() + " in room " + roomName + " was turned off.");
        }
    }

    @Override
    public String getName() {
        return "light";
    }
}
