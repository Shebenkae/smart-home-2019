package ru.sbt.mipt.oop;

public class ActionLightOn implements Action<Light> {
    private String locid;

    public ActionLightOn(String locid) {
        this.locid = locid;
    }

    @Override
    public void act(Light obj, String roomName) {
        if (locid.equals(obj.getId())) {
            obj.setOn(true);
            System.out.println("Light " + obj.getId() + " in room " + roomName + " was turned on.");
        }
    }

    @Override
    public String getName() {
        return "light";
    }
}
