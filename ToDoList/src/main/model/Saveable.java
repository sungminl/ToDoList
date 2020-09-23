package model;

import java.io.File;
import java.io.IOException;

public interface Saveable {
    // MODIFIES: File
    // EFFECTS: Saves ToDoList onto a chosen file
    void saveToFile(File file) throws IOException;
}
