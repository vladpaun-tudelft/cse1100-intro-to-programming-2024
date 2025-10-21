import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    void testToString() {
        Address addr = new Address("mekelweg",5,"2625JD","Delft");
        Equipment e1 = new JackHammer("a jack and a hammer");
        Equipment e2 = new Torch("some fire");
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(e1);
        equipmentList.add(e2);
        Date d = new Date(30,10,2024);
        Job j = new Job(addr,"New Tram Line", equipmentList, d);

        assertEquals("Job{jobNumber=1, location=mekelweg 5 2625JD Delft, description='New Tram Line', requiredEquipment=[Jack hammer: a jack and a hammer, Torch: some fire], plannedDate=30/10/2024}", j.toString());
    }

    @Test
    void testEquals() {
        Address addr = new Address("mekelweg",5,"2625JD","Delft");
        Equipment e1 = new JackHammer("a jack and a hammer");
        Equipment e2 = new Torch("some fire");
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(e1);
        equipmentList.add(e2);
        Date d = new Date(30,10,2024);
        Job j = new Job(addr,"New Tram Line", equipmentList, d);
        Job j2 = new Job(addr,"New Tram Line", equipmentList, d);
        Job j3 = new Job(addr,"Destroy old Tram Line", equipmentList, d);
        assertEquals(j, j);
        assertEquals(j, j2);
        assertNotEquals(j, j3);
        assertNotEquals(j, null);
        assertNotEquals(j, new Object());

    }
}