package ui.gui;

public class Utils {

    // EFFECTS: Returns file extension as a string
    public static String getFileExtension(String name) {
        int pointIndex =  name.lastIndexOf(".");

        if (pointIndex == -1) {
            return null;
        }

        if (pointIndex == name.length() - 1) {
            return null;
        }

        return name.substring(pointIndex + 1);
    }
}
