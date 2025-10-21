import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamBasicsTest {

    @Test
    void even() {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        int[] even = {2,4,6,8,10};
        assertTrue(Arrays.equals(even, StreamBasics.even(numbers)));
    }

    @Test
    void squareAll() {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        int[] squares = {1,4,9,16,25,36,49,64,81,100};
        assertTrue(Arrays.equals(squares, StreamBasics.squareAll(numbers)));
    }
}