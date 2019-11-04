package ru.sbt.mipt.oop;

public class ActionCloseDoor implements Action<Door> {
    private String locid;

    public ActionCloseDoor(String locid) {
        this.locid = locid;
    }

    public String getName(){
        return "door";
    }

    @Override
    public void act(Door obj, String roomName) {
        if (locid.equals(obj.getId())) {
            obj.setOpen(false);
            System.out.println("Door " + obj.getId() + " in room " + roomName + " was closed.");
        }
    }
}
