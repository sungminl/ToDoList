package controller;

import exceptions.SameNameTaskException;
import exceptions.TooManyThingsToDo;
import model.Item;
import model.RegularItem;
import model.ToDoList;
import model.UrgentItem;
import ui.gui.FormCompleteEvent;
import ui.gui.FormEvent;
import ui.gui.FormRemoveEvent;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    private ToDoList toDoList = new ToDoList();

    // EFFECTS: returns a List of Items
    public List<Item> getItems() {
        return toDoList.getItems();
    }

    // MODIFIES: ToDoList
    // EFFECTS: Passes on Item to add from gui to ToDoList
    public void addItem(FormEvent e) throws SameNameTaskException, TooManyThingsToDo {
        RegularItem regularItem;
        UrgentItem urgentItem;

        String name = e.getName();
        String description = e.getDescription();
        String itemCategory = e.getItemCategory();

        if (itemCategory.equals("Regular Item")) {
            regularItem = new RegularItem(name,description,"Not Completed");
            toDoList.insertItem(regularItem);
        }
        if (itemCategory.equals("Urgent Item")) {
            urgentItem = new UrgentItem(name,description,"FINISH SOON");
            toDoList.insertItem(urgentItem);
        }
    }

    // MODIFIES: ToDoList
    // EFFECTS: Passes on Item to remove from gui to ToDoList
    public void removeItem(FormRemoveEvent e) {
        String name = e.getName();
        toDoList.removeItem(name);
    }

    // MODIFIES: ToDoList
    // EFFECTS: Passes on Item to complete from gui to ToDoList
    public void completeItem(FormCompleteEvent e) {
        String name = e.getName();
        toDoList.completed(name);
    }

    // EFFECTS: Passes on file to save from gui to ToDoList
    public void saveToFile(File file) throws IOException {
        toDoList.saveToFile(file);
    }

    // EFFECTS: Passes on file to load from gui to ToDoList
    public void loadFromFile(File file) throws IOException {
        toDoList.loadFromFile(file);
    }

    // MODIFIES: ToDoList
    // EFFECTS: Passes on instruction to clear all items from gui to ToDoList
    public void clearAllItem() {
        toDoList.clearAll();
    }

}
