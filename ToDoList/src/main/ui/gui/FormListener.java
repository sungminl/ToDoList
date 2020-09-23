package ui.gui;

import exceptions.SameNameTaskException;
import exceptions.TooManyThingsToDo;

import java.util.EventListener;

public interface FormListener extends EventListener {
    void formEventOccurred(FormEvent e) throws TooManyThingsToDo, SameNameTaskException;
}
