package idv.kuma;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class ImmutableQueueTest {


    @Test
    public void Given_Queue_Empty_When_IsEmpty_Then_Exception() {

        Queue<Integer> queue = makeQueue();

        checkEmpty(queue);

    }

    @Test
    public void Given_Queue_Empty_When_Head_Then_Exception() {

        Queue<Integer> queue = makeQueue();

        try {
            queue.head();
        } catch (Exception e) {
            checkExceptionType(e);
        }

    }


    @Test
    public void Given_Queue_Empty_When_Enqueue_1_Then_Return_New_Queue_And_Head_1() {

        Queue<Integer> before = makeQueue();

        Queue<Integer> afterEnqueue = before.enQueue(1);

        checkInstanceAndHead(before, afterEnqueue, 1);

    }


    @Test
    public void Given_Queue_1_When_Enqueue_2_Then_Return_New_Queue_And_Head_1() {

        Queue<Integer> before = makeQueue(1);

        Queue<Integer> afterEnqueue = before.enQueue(2);

        checkInstanceAndHead(before, afterEnqueue, 1);

    }


    @Test
    public void Given_Queue_1_2_When_Enqueue_3_Then_Return_New_Queue_And_Head_1() {

        Queue<Integer> before = makeQueue(1, 2);

        Queue<Integer> afterEnqueue = before.enQueue(3);
        checkInstanceAndHead(before, afterEnqueue, 1);

    }


    @Test
    public void Given_Queue_Empty_When_Dequeue_Then_Throw_Exception() {

        Queue<Integer> before = makeQueue();

        try {
            before.deQueue();
        } catch (Exception e) {
            checkExceptionType(e);
        }

    }


    @Test
    public void Given_Queue_1_When_Dequeue_Then_Empty() {

        Queue<Integer> before = makeQueue(1);

        Queue<Integer> afterDequeue = before.deQueue();

        checkInstance(before, afterDequeue);

        checkEmpty(afterDequeue);

    }


    @Test
    public void Given_Queue_1_2_When_Dequeue_Then_New_Queue_And_Head_1() {

        Queue<Integer> before = makeQueue(1, 2);

        Queue<Integer> afterDequeue = before.deQueue();

        checkInstanceAndHead(before, afterDequeue, 2);
    }

    @Test
    public void Given_Queue_1_2_3_When_Dequeue_Twice_Then_New_Queues_And_Head_2_And_3() {

        Queue<Integer> before = makeQueue(1, 2, 3);

        Queue<Integer> afterDequeueOnce = before.deQueue();

        checkInstanceAndHead(before, afterDequeueOnce, 2);

        Queue<Integer> afterDequeueTwice = afterDequeueOnce.deQueue();

        checkInstanceAndHead(afterDequeueOnce, afterDequeueTwice, 3);

    }

    private void checkExceptionType(Exception e) {
        Assert.assertTrue(e instanceof NoSuchElementException);
    }

    private void checkEmpty(Queue<Integer> afterDequeue) {
        Assert.assertTrue(afterDequeue.isEmpty());
    }


    private Queue<Integer> makeQueue(int... elements) {

        Queue<Integer> queue = new ImmutableQueue<>();

        for (int element : elements) {
            queue = queue.enQueue(element);
        }

        return queue;
    }


    private void checkInstanceAndHead(Queue<Integer> before, Queue<Integer> after, int expectedHead) {
        Assert.assertNotEquals(before, after);
        Assert.assertEquals(Integer.valueOf(expectedHead), after.head());
    }


    private void checkInstance(Queue<Integer> before, Queue<Integer> afterDequeue) {
        Assert.assertNotEquals(before, afterDequeue);
    }


}