import model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ItemTest {
    Item item;
    Item itemEmpty;

    @Test
    public void testGetName() {
        assertEquals("", itemEmpty.getName());
        assertEquals("Laundry", item.getName());
    }

    @Test
    public void testSetNameFromEmpty() {
        assertEquals("", itemEmpty.getName());
        itemEmpty.setName("Basketball");
        assertEquals("Basketball", itemEmpty.getName());
    }

    @Test
    public void testSetNameFromSomething() {
        assertEquals("Laundry", item.getName());
        item.setName("Soccer");
        assertEquals("Soccer", item.getName());
    }

    @Test
    public void testGetStatus() {
        assertEquals("Not Completed", itemEmpty.getStatus());
        assertEquals("Not Completed", item.getStatus());
    }

    @Test
    public void testSetStatusFromEmpty() {
        assertEquals("Not Completed", itemEmpty.getStatus());
        itemEmpty.setStatus("Completed");
        assertEquals("Completed", itemEmpty.getStatus());
    }

    @Test
    public void testSetStatusFromSomething() {
        assertEquals("Not Completed", item.getStatus());
        item.setStatus("Completed");
        assertEquals("Completed", item.getStatus());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Laundry", item.getDescription());
        assertEquals("", itemEmpty.getDescription());
    }

    @Test
    public void testSetDescriptionFromEmpty() {
        assertEquals("", itemEmpty.getDescription());
        itemEmpty.setDescription("Hi");
        assertEquals("Hi", itemEmpty.getDescription());
    }

    @Test
    public void testSetDescriptionFromSomething() {
        assertEquals("Laundry", item.getDescription());
        item.setDescription("Bye");
        assertEquals("Bye", item.getDescription());
    }

    @Test
    public void testComplete() {
        assertEquals("Not Completed", item.getStatus());
        item.complete();
        assertEquals("Completed", item.getStatus());
    }


}
