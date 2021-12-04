package consumer;
import driver.Order;

import java.util.concurrent.BlockingQueue;

//Consumer has to be a thread
public class Consumer implements Runnable {
    private BlockingQueue<Order> queue;

    public Consumer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Order order = queue.take();
            System.out.println(Thread.currentThread().getName() + " takes off order " + order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //takes an order off the ds

}
