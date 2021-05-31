import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private final SILab2 newOb = new SILab2();
	@Test
    void multipleCondition() {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(-1, 0, 0))));
        assertEquals(ex.getMessage(), "The hours are smaller than the minimum");
		ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(25, 0, 0))));
        assertEquals(ex.getMessage(), "The hours are grater than the maximum");
		ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(0, -1, 0))));
        assertEquals(ex.getMessage(), "The minutes are not valid!");
		ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(0, 60, 0))));
        assertEquals(ex.getMessage(), "The minutes are not valid!");
		ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(0, 0, 60))));
        assertEquals(ex.getMessage(), "The seconds are not valid");
		assertEquals(Arrays.asList(0), newOb.function(Arrays.asList(new Time(0, 0, 0))));
        assertEquals(Arrays.asList(24*3600), newOb.function(Arrays.asList(new Time(24, 0, 0))));
		ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(24, 0, 1))));
        assertEquals(ex.getMessage(), "The time is greater than the maximum");
		ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(24, 1, 0))));
        assertEquals(ex.getMessage(), "The time is greater than the maximum");
		ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(24, 0, 1))));
        assertEquals(ex.getMessage(), "The time is greater than the maximum");
    }

    @Test
    void testEveryBranch {
        RuntimeException ex;
		assertEquals(new ArrayList<Integer>(), newOb.function(new ArrayList<Time>()));
		ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(-1, 0, 0))));
        assertEquals(ex.getMessage(), "The hours are smaller than the minimum");
		ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(25, 0, 0))));
        assertEquals(ex.getMessage(), "The hours are grater than the maximum");
		ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(1, -1, 0))));
        assertEquals(ex.getMessage(), "The minutes are not valid!");
		assertEquals(Arrays.asList(3600), newOb.function(Arrays.asList(new Time(1, 0, 0))));
		ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(1, 0, -1))));
        assertEquals(ex.getMessage(), "The seconds are not valid");
		assertEquals(Arrays.asList(24*3600), newOb.function(Arrays.asList(new Time(24, 0, 0))));
		ex = assertThrows(RuntimeException.class, () -> newOb.function(Arrays.asList(new Time(24, 1, 0))));
        assertEquals(ex.getMessage(), "The time is greater than the maximum");
    }
}