package model;

import java.io.File;
import java.io.IOException;

public interface Loadable {
    // MODIFIES: ToDoList
    // EFFECTS: Loads file onto ToDoList
    void loadFromFile(File file) throws IOException;
}
