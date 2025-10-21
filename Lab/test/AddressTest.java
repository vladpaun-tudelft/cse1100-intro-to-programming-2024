import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AddressTest {
    @Test
    public void constructorGetterTest() {
        Address address = new Address("van Hasseltlaan", 535, "2625JH", "Delft");
        assertEquals("van Hasseltlaan", address.street());
        assertEquals("2625JH", address.zipCode());
        assertEquals("Delft", address.city());
        assertEquals(535, address.number());
    }

    @Test
    public void toStringTest() {
        Address address = new Address("van Hasseltlaan", 535, "2625JH", "Delft");
        assertEquals("Address: van Hasseltlaan 535 2625JH Delft", address.toString());
    }

    @Test
    public void equalsTest() {
        Address address = new Address("van Hasseltlaan", 535, "2625JH", "Delft");
        Address address1 = new Address("van Hasseltlaan", 535, "2625JH", "Delft");
        Address address2 = new Address(".", 1, "2625JH", ".");
        Address address3 = new Address(".", 535, "", ".");
        assertEquals(address, address);
        assertEquals(address, address1);
        assertNotEquals(address, address2);
        assertNotEquals(address, null);
        assertNotEquals(address, "Address");
        assertNotEquals(address, address3);

    }


}
