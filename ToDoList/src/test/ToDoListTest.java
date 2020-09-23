
import exceptions.SameNameTaskException;
import exceptions.TooManyThingsToDo;
import model.Item;
import model.RegularItem;
import model.ToDoList;
import model.UrgentItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    private ToDoList tdl1;
    private ToDoList tdl2;
    private Item regularItem1;
    private Item regularItem2;
    private Item regularItem3;
    private Item regularItem4;
    private Item urgentItem1;
    private Item urgentItem2;

    public ToDoListTest() throws IOException {
    }

    @BeforeEach
    public void runBefore() throws TooManyThingsToDo, SameNameTaskException {
        tdl1 = new ToDoList();
        tdl2 = new ToDoList();
        regularItem1 = new RegularItem("a", "a", "Not Completed");
        regularItem2 = new RegularItem("b", "b", "Not Completed");
        regularItem3 = new RegularItem("c", "c", "Not Completed");
        regularItem4 = new RegularItem("d", "d", "Not Completed");
        urgentItem1 = new UrgentItem("e", "e", "FINISH SOON");
        urgentItem2 = new UrgentItem("f", "f", "FINISH SOON");
    }

    @Test
    public void testGetItem() throws SameNameTaskException, TooManyThingsToDo {
        tdl1.insertItem(regularItem1);
        assertEquals(tdl1.getItem(0), regularItem1);
    }

    @Test
    public void testGetSize() throws SameNameTaskException, TooManyThingsToDo {
        assertEquals(0, tdl1.getSize());
        tdl1.insertItem(regularItem1);
        assertEquals(1, tdl1.getSize());
        tdl1.insertItem(urgentItem1);
        assertEquals(2, tdl1.getSize());

    }

    @Test
    public void testContains() throws SameNameTaskException, TooManyThingsToDo {
        assertFalse(tdl1.contains(regularItem1));
        tdl1.insertItem(regularItem1);
        assertTrue(tdl1.contains(regularItem1));
        assertFalse(tdl1.contains(regularItem2));
    }

    @Test
    public void testGetItems() throws SameNameTaskException, TooManyThingsToDo {
        assertFalse(tdl1.contains(regularItem1));
        tdl1.insertItem(regularItem1);
        assertTrue(tdl1.contains(regularItem1));
        assertFalse(tdl1.contains(regularItem2));
        tdl1.insertItem(regularItem2);
        assertTrue(tdl1.contains(regularItem2));

        ArrayList<Item> testList = new ArrayList<>();
        testList.add(regularItem1);
        testList.add(regularItem2);

        assertEquals(testList, tdl1.getItems());
    }



    @Test
    public void testInsertItemsAllGood() {
        assertFalse(tdl1.contains(regularItem1));
        try {
            tdl1.insertItem(regularItem1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail("shouldn't catch");
        } catch (SameNameTaskException e) {
            fail("shouldn't catch");
        }
        assertTrue(tdl1.contains(regularItem1));

        assertFalse(tdl1.contains(regularItem2));
        try {
            tdl1.insertItem(regularItem2);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail("shouldn't catch");
        } catch (SameNameTaskException e) {
            fail("shouldn't catch");
        }
        assertTrue(tdl1.contains(regularItem2));


        assertFalse(tdl1.contains(regularItem3));
        try {
            tdl1.insertItem(regularItem3);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail("shouldn't catch");
        } catch (SameNameTaskException e) {
            fail("shouldn't catch");
        }
        assertTrue(tdl1.contains(regularItem3));


        assertFalse(tdl1.contains(urgentItem1));
        try {
            tdl1.insertItem(urgentItem1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail("shouldn't catch");
        } catch (SameNameTaskException e) {
            fail("shouldn't catch");
        }
        assertTrue(tdl1.contains(urgentItem1));

    }

    @Test
    public void testInsertItemsThrowingSameNameException() {
        assertFalse(tdl1.contains(regularItem1));
        try {
            tdl1.insertItem(regularItem1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail("shouldn't catch");
        } catch (SameNameTaskException e) {
            fail("shouldn't catch");
        }

        assertTrue(tdl1.contains(regularItem1));

        try {
            tdl1.insertItem(regularItem1);
            fail("should've thrown'");
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail("shouldn't catch");
        } catch (SameNameTaskException e) {
            // expected
        }
    }

    @Test
    public void testInsertItemsThrowTooManyThingsToDo() {
        assertFalse(tdl1.contains(regularItem1));
        try {
            tdl1.insertItem(regularItem1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail("shouldn't catch");
        } catch (SameNameTaskException e) {
            fail("shouldn't catch");
        }
        assertTrue(tdl1.contains(regularItem1));

        assertFalse(tdl1.contains(regularItem2));
        try {
            tdl1.insertItem(regularItem2);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail("shouldn't catch");
        } catch (SameNameTaskException e) {
            fail("shouldn't catch");
        }
        assertTrue(tdl1.contains(regularItem2));


        assertFalse(tdl1.contains(regularItem3));
        try {
            tdl1.insertItem(regularItem3);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail("shouldn't catch");
        } catch (SameNameTaskException e) {
            fail("shouldn't catch");
        }
        assertTrue(tdl1.contains(regularItem3));


        assertFalse(tdl1.contains(urgentItem1));
        try {
            tdl1.insertItem(urgentItem1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail("shouldn't catch");
        } catch (SameNameTaskException e) {
            fail("shouldn't catch");
        }
        assertTrue(tdl1.contains(urgentItem1));

        assertFalse(tdl1.contains(urgentItem2));
        try {
            tdl1.insertItem(urgentItem2);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail("shouldn't catch");
        } catch (SameNameTaskException e) {
            fail("shouldn't catch");
        }
        assertTrue(tdl1.contains(urgentItem2));

        try {
            tdl1.insertItem(regularItem4);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            // expected
        } catch (SameNameTaskException e) {
            fail("shouldn't catch");
        }
    }


    @Test
    public void testRemoveItem() throws TooManyThingsToDo, SameNameTaskException {
        assertFalse(tdl1.contains(regularItem1));
        tdl1.insertItem(regularItem1);
        assertTrue(tdl1.contains(regularItem1));
        assertFalse(tdl1.contains(regularItem2));
        tdl1.insertItem(regularItem2);
        assertTrue(tdl1.contains(regularItem2));
        assertEquals(2, tdl1.getSize());

        tdl1.removeItem("d");
        assertTrue(tdl1.contains(regularItem1));
        assertTrue(tdl1.contains(regularItem2));
        assertEquals(2, tdl1.getSize());

        tdl1.removeItem("a");
        assertFalse(tdl1.contains(regularItem1));
        assertEquals(1, tdl1.getSize());

        tdl1.removeItem("b");
        assertFalse(tdl1.contains(regularItem2));
        assertEquals(0, tdl1.getSize());
    }

    @Test
    public void testGetUncompletedItems() throws TooManyThingsToDo, SameNameTaskException {
        regularItem3.setStatus("hi");
        assertEquals(0, tdl1.getUncompletedItems());
        tdl1.insertItem(regularItem2);
        tdl1.insertItem(urgentItem1);
        tdl1.insertItem(regularItem3);

        assertEquals(2, tdl1.getUncompletedItems());
    }

    @Test
    public void testSaveToFile() throws IOException, SameNameTaskException, TooManyThingsToDo {
        assertFalse(tdl1.contains(regularItem1));
        tdl1.insertItem(regularItem1);
        assertTrue(tdl1.contains(regularItem1));
        assertFalse(tdl1.contains(regularItem2));
        tdl1.insertItem(regularItem2);
        assertTrue(tdl1.contains(regularItem2));
        assertEquals(2, tdl1.getSize());

        tdl1.saveToFile(File.createTempFile("testfile", ".txt"));
    }

    @Test
    public void testCompleted() throws SameNameTaskException, TooManyThingsToDo {
        assertFalse(tdl1.contains(regularItem1));
        tdl1.insertItem(regularItem1);
        assertTrue(tdl1.contains(regularItem1));
        assertFalse(tdl1.contains(urgentItem1));
        tdl1.insertItem(urgentItem1);
        assertTrue(tdl1.contains(urgentItem1));

        tdl1.completed("a");
        assertEquals("Completed", regularItem1.getStatus());
        tdl1.completed("e");
        assertEquals("HURRAY YOU FINISHED ON TIME", urgentItem1.getStatus());

    }

    @Test
    public void testClearAllFromNotFull() throws SameNameTaskException, TooManyThingsToDo {
        assertFalse(tdl1.contains(regularItem1));
        tdl1.insertItem(regularItem1);
        assertTrue(tdl1.contains(regularItem1));
        assertFalse(tdl1.contains(urgentItem1));
        tdl1.insertItem(urgentItem1);
        assertTrue(tdl1.contains(urgentItem1));
        assertEquals(2, tdl1.getSize());

        tdl1.clearAll();

        assertEquals(0, tdl1.getSize());
    }

    @Test
    public void testClearAllFromFull() throws SameNameTaskException, TooManyThingsToDo {
        tdl1.insertItem(regularItem1);
        tdl1.insertItem(regularItem2);
        tdl1.insertItem(regularItem3);
        tdl1.insertItem(urgentItem1);
        tdl1.insertItem(urgentItem2);

        assertEquals(5, tdl1.getSize());

        tdl1.clearAll();

        assertEquals(0, tdl1.getSize());
    }

}
