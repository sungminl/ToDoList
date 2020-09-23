package model;

public class UrgentItem extends Item {

    public UrgentItem(String name, String description, String status) {
        super(name, description, "FINISH SOON");
    }

    @Override
    // MODIFIES: This
    // EFFECTS: Sets status of Item to completed status of UrgentItem
    public void complete() {
        this.status = "HURRAY YOU FINISHED ON TIME";
    }
}
