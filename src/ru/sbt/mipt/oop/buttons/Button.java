package ru.sbt.mipt.oop.buttons;

public class Button {
    private String code;
    private Command command;

    public Button(String code, Command command) {
        this.code = code;
        this.command = command;
    }

    public String getCode() {
        return code;
    }

    public Command getCommand() {
        return command;
    }

}
