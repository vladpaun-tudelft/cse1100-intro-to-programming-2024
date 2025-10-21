import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void getDay() {
        Date d = new Date(30,1,2006);
        assertEquals(d.getDay(),30);
    }

    @Test
    void getMonth() {
        Date d = new Date(30,1,2006);
        assertEquals(d.getMonth(),1);
    }

    @Test
    void getYear() {
        Date d = new Date(30,1,2006);
        assertEquals(d.getYear(),2006);
    }

    @Test
    void testToString() {
        Date d = new Date(30,1,2006);
        assertEquals(d.toString(),"Date: 30/1/2006");
    }

    @Test
    void testEquals() {
        Date d = new Date(30,1,2006);
        Date d2 = new Date(30,1,2006);
        Date d3 = new Date(30,1,2007);
        assertEquals(d,d);
        assertEquals(d,d2);
        assertNotEquals(d,d3);
        assertNotEquals(d,null);
        assertNotEquals(d,new Object());
    }
}