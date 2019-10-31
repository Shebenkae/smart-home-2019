package ru.sbt.mipt.oop;

public class ActionOpenDoor implements Action<Door> {
    private String locid;

    public ActionOpenDoor(String locid) {
        this.locid = locid;
    }

    @Override
    public void act(Door obj, String roomName) {
        if (locid.equals(obj.getId())) {
            obj.setOpen(true);
            System.out.println("Door " + obj.getId() + " in room " + roomName + " was opened.");
        }
    }

    @Override
    public String getName() {
        return "door";
    }
}
