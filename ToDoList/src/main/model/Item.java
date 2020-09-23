package model;

import java.io.Serializable;
//import observer.ItemObserver;
import ui.gui.MainFrame;

public abstract class Item implements Serializable { //ItemObserver, Serializable {

    private String name;
    String status;
    private String description;

    public Item(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // MODIFIES: This
    // EFFECTS: Sets status of Item to completed status of
    //          RegularItem or UrgentItem
    public abstract void complete();

//    @Override
//    public void update(Item i) {
//        System.out.println("\t" + this.getName() + " | " + this.getStatus());
//    }

}
