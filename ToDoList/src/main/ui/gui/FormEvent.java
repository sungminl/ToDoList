package ui.gui;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;
    private String description;
    private String itemCategory;

    public FormEvent(Object source, String name, String description, String itemCategory) {
        super(source);

        this.name = name;
        this.description = description;
        this.itemCategory = itemCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemCategory() {
        return itemCategory;
    }
}
