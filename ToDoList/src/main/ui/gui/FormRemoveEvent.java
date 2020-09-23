package ui.gui;

import java.util.EventObject;

public class FormRemoveEvent extends EventObject {
    private String name;

    public FormRemoveEvent(Object source, String name) {
        super(source);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
