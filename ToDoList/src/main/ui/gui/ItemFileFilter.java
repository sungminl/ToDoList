package ui.gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ItemFileFilter extends FileFilter {

    // EFFECTS: If file has accepted extension or is a directory,
    // return true. Else return false
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String name = f.getName();
        String extension = Utils.getFileExtension(name);

        if (extension == null) {
            return false;
        }
        if (extension.equals("txt")) {
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Item database files (*txt)";
    }
}
