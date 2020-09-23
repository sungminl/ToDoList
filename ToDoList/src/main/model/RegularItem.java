package model;

public class RegularItem extends Item {

    public RegularItem(String name, String description, String status) {
        super(name, description, "Not Completed");
    }

    @Override
    // MODIFIES: This
    // EFFECTS: Sets status of Item to completed status of RegularItem
    public void complete() {
        this.status = "Completed";
    }
}
