package idv.kuma;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class ImmutableQueueTest {


    @Test
    public void Given_Queue_Empty_When_IsEmpty_Then_Exception() {

        Queue<Integer> queue = makeQueue();

        Assert.assertTrue(queue.isEmpty());

    }

    @Test
    public void Given_Queue_Empty_When_Head_Then_Exception() {

        Queue<Integer> queue = makeQueue();

        try {
            queue.head();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof NoSuchElementException);
        }

    }


    @Test
    public void Given_Queue_Empty_When_Enqueue_1_Then_Return_New_Queue_And_Head_1() {

        Queue<Integer> before = makeQueue();

        Queue<Integer> afterEnqueue = before.enQueue(1);
        Assert.assertNotEquals(before, afterEnqueue);
        Assert.assertEquals(Integer.valueOf(1), afterEnqueue.head());


    }




    private Queue<Integer> makeQueue(int... elements) {

        Queue<Integer> queue = new ImmutableQueue<>();

        for (int element : elements) {
            queue = queue.enQueue(element);
        }

        return queue;
    }




}