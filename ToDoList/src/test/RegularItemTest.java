import model.RegularItem;
import org.junit.jupiter.api.BeforeEach;

public class RegularItemTest extends ItemTest {

    @BeforeEach
    public void setUp() {
        item = new RegularItem("Laundry", "Laundry", "Not Completed");
        itemEmpty = new RegularItem("", "","");
    }
}
