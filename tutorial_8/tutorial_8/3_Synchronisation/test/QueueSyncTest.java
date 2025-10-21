import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class QueueSyncTest {

    private Queue queue;

    @BeforeEach
    void setUp() throws Exception {
        this.queue = new Queue();
        Field requests = Queue.class.getDeclaredField("requests");
        requests.setAccessible(true);
        requests.set(this.queue, new SlowQueue());
    }

    @RepeatedTest(10)
    @DisplayName("First student enqueues first")
    public void enqueue() throws Exception {
        Request request1 = new Request("This is a question", "Room 1");
        Request request2 = new Request("This is another question", "Room 1");

        Thread t1 = Thread.ofVirtual().unstarted(() -> queue.enqueue(request1));
        Thread t2 = Thread.ofVirtual().unstarted(() -> queue.enqueue(request2));

        t1.start();
        try {
            Thread.sleep(5L);
        } catch (Exception ignored) {}
        t2.start();

        t1.join();
        t2.join();
        assertEquals(request1, queue.getNext());
    }

    @RepeatedTest(10)
    @DisplayName("Cannot get the same request")
    public void getNext() throws Exception {
        Request request1 = new Request("This is a question", "Room 1");
        Request request2 = new Request("This is another question", "Room 1");
        queue.enqueue(request1);
        queue.enqueue(request2);

        class GetNext implements Runnable {
            public Request request;
            @Override
            public void run() {
                this.request = queue.getNext();
            }
        }

        GetNext next1 = new GetNext();
        GetNext next2 = new GetNext();

        Thread t1 = Thread.ofVirtual().unstarted(next1);
        Thread t2 = Thread.ofVirtual().unstarted(next2);

        t1.start();
        try {
            Thread.sleep(5L);
        } catch (Exception ignored) {}
        t2.start();

        t1.join();
        t2.join();
        assertNotEquals(next1.request, next2.request);
    }

    @RepeatedTest(10)
    @DisplayName("Enqueue then get next")
    public void enqueueDequeue() throws Exception {
        Request request = new Request("This is a question", "Room 1");

        Thread t1 = Thread.ofVirtual().unstarted(() -> queue.enqueue(request));
        class NoThrow implements Runnable {
            public boolean threw = false;
            @Override
            public void run() {
                try {
                    queue.getNext();
                } catch (IndexOutOfBoundsException ignored) {
                    threw = true;
                }
            }
        }
        NoThrow noThrow = new NoThrow();
        Thread t2 = Thread.ofVirtual().unstarted(noThrow);

        t1.start();
        try {
            Thread.sleep(5L);
        } catch (Exception ignored) {}
        t2.start();

        t1.join();
        t2.join();

        assertFalse(noThrow.threw);
    }

    private static class SlowQueue extends ArrayList<Request> {
        private static final Random rand = new Random();
        @Override
        public boolean add(Request request) {
            try {
                Thread.sleep(rand.nextInt(10, 100));
            } catch (Exception ignored) {}
            return super.add(request);
        }
        @Override
        public Request remove(int index) {
            Request value = get(index);
            try {
                Thread.sleep(rand.nextInt(10, 100));
            } catch (Exception ignored) {}
            super.remove(index);
            return value;
        }
    }

}
