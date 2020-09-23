import controller.Controller;
import exceptions.SameNameTaskException;
import exceptions.TooManyThingsToDo;
import model.Item;
import model.RegularItem;
import model.ToDoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.gui.FormCompleteEvent;
import ui.gui.FormEvent;
import ui.gui.FormRemoveEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ControllerTest {
    private Controller controller;
    private ToDoList tdl;
    private ArrayList<Item> testList;
    private FormEvent formEvent;
    private RegularItem regularItem1;
    private FormRemoveEvent formRemoveEvent;
    private FormCompleteEvent formCompleteEvent;

    @BeforeEach
    public void setUp() {
        controller = new Controller();
        tdl = new ToDoList();
        testList = new ArrayList<>();
        formEvent = new FormEvent(tdl, "a", "a", "Not Completed");
        formRemoveEvent = new FormRemoveEvent(tdl,"b");
        regularItem1 = new RegularItem("a", "a", "Not Completed");
        formCompleteEvent = new FormCompleteEvent(tdl, "a");
    }

    @Test
    public void testGetItems() throws TooManyThingsToDo, SameNameTaskException {
        assertEquals(testList, controller.getItems());
    }

    @Test
    public void testAddItem() {
        try {
            controller.addItem(formEvent);
        } catch (SameNameTaskException e) {
            fail("shouldn't catch");
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail("shouldn't catch");
        }
    }

    @Test
    public void testRemoveItem() {
        controller.removeItem(formRemoveEvent);
        assertEquals(testList, controller.getItems());
    }

    @Test
    public void testSaveToFile() throws IOException {
        controller.saveToFile(File.createTempFile("testfile", ".txt"));
    }

    @Test
    public void testCompleteItem() {
        controller.completeItem(formCompleteEvent);
        assertEquals(testList, controller.getItems());
    }

    @Test
    public void testClearAllItem() {
        controller.clearAllItem();
        assertEquals(testList, controller.getItems());
    }

}
