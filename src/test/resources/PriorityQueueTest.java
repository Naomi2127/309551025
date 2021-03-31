import java.util.PriorityQueue;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.api.Assertions.*;



public class PriorityQueueTest {
    public static Stream<Arguments> input() {
        return Stream.of(
                arguments(new int[]{5,7,3,2}, new int[]{2,3,5,7}),
                arguments(new int[]{4,6,1,3}, new int[]{1,3,4,6}),
                arguments(new int[]{1,7,9,4}, new int[]{1,4,7,9}),
                arguments(new int[]{6,1,8,3}, new int[]{1,3,6,8}),
                arguments(new int[]{5,4,6,2}, new int[]{2,4,5,6})
        );
    }

    @ParameterizedTest(name = "#{index} - Test with Argument={0},{1}")
    @MethodSource("input")
    public void ParameterizedTest( int[] random_array, int[] correct_array){
        PriorityQueue test = new PriorityQueue();
        for(int i : random_array){
            test.offer(i);
        }
        for(int i : correct_array){
            assertEquals(i, test.poll());
        }
    }

    @Test
    public void InitialCapacityTest() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1,null);
        });
    }

    @Test
    public void OfferTest() {
        Exception e = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().offer(null);
        });
    }

    @Test
    public void ForEachRemainingTest() {
        Exception e = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().forEach(null);
        });
    }



}


