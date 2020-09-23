package ui.gui;

public class ItemCategory {
    private int id;
    private String text;

    public ItemCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    // EFFECTS: Returns value of text field from this
    public String toString() {
        return text;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
