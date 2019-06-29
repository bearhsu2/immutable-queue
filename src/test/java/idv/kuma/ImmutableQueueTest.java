package idv.kuma;

import org.junit.Assert;
import org.junit.Test;

public class ImmutableQueueTest {

    @Test
    public void Given_Queue_Empty_When_Enqueue_1_Then_Return_New_Queue_And_Head_1() {

        Queue<Integer> before = new ImmutableQueue<>();

        Queue<Integer> after = before.enQueue(1);
        Assert.assertNotEquals(before, after);
        Assert.assertEquals(Integer.valueOf(1), after.head());
    }


}