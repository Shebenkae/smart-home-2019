package ru.sbt.mipt.oop.buttons;

import java.util.ArrayList;

public class RemoteController implements RemoteControl {
    private ArrayList<Button> buttons;
    private String id;

    public RemoteController(String id) {
        this.id = id;
        buttons = new ArrayList<>();
    }


    @Override
    public void onButtonPressed(String buttonCode) {
        Button button = getButton(buttonCode);
        if (button != null) {
            button.getCommand().perform();
        }
    }

    public Button getButton(String buttonCode) {
        for (Button button : buttons) {
            if (button.getCode().equals(buttonCode))
                return button;
        }
        return null;
    }

    public void setButton(String buttonCode, Command command) {
        Button button = getButton(buttonCode);
        if (button != null) {
            buttons.remove(button);
        }
        buttons.add(new Button(buttonCode, command));
    }
}
