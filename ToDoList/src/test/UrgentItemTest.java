import model.UrgentItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrgentItemTest extends ItemTest {

    @BeforeEach
    public void runBefore() {
        item = new UrgentItem("Laundry", "Laundry", "FINISH SOON");
        itemEmpty = new UrgentItem("", "", "");
    }

    @Test
    public void testGetStatus() {
        assertEquals("FINISH SOON", itemEmpty.getStatus());
        assertEquals("FINISH SOON", item.getStatus());
    }

    @Test
    public void testSetStatusFromEmpty() {
        assertEquals("FINISH SOON", itemEmpty.getStatus());
        itemEmpty.setStatus("Hi");
        assertEquals("Hi", itemEmpty.getStatus());
    }

    @Test
    public void testSetStatusFromSomething() {
        assertEquals("FINISH SOON", item.getStatus());
        item.setStatus("Bye");
        assertEquals("Bye", item.getStatus());
    }

    @Test
    public void testComplete() {
        assertEquals("FINISH SOON", item.getStatus());
        item.complete();
        assertEquals("HURRAY YOU FINISHED ON TIME", item.getStatus());
    }
}
