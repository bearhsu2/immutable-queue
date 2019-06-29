package idv.kuma;

import org.junit.Assert;
import org.junit.Test;

public class ImmutableQueueTest {

    @Test
    public void Given_Queue_Size_1_When_Enqueue_Then_Return_New_Queue_And_New_Queue_Size_1() {

        Queue<String> before = new ImmutableQueue<>();

        Queue<String> after = before.enQueue("Kuma");
        Assert.assertNotEquals(before, after);
        Assert.assertEquals("Kuma", after.head());
    }

    @Test
    public void Given_Queue_Size_1_When_Enqueue_Then_Return_New_Queue_And_New_Queue_Size_2() {

        Queue<String> before = new ImmutableQueue<String>().enQueue("Kuma");

        Queue<String> after = before.enQueue("Mike");
        Assert.assertNotEquals(before, after);
        Assert.assertEquals("Kuma", after.head());

        Queue<String> yetAfter = after.deQueue();
        Assert.assertNotEquals(after, yetAfter);
        Assert.assertEquals("Mike", yetAfter.head());

    }
}