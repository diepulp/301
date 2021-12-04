package producer;
import driver.Order;
import java.util.concurrent.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    //save the queue reference as an instance field
    private BlockingQueue<Order> queue;

    public Producer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        //make the thread run for a certain period of time
        //timestamp start
        long timeStart = System.currentTimeMillis();
        try {
            do {
                //add orders
                Order order = new Order(name,"Shit you dont need", 1);
                queue.put(order);
            } while (System.currentTimeMillis() - timeStart <= 3000);
        } catch (InterruptedException e) {
            System.out.println("Producer is interrupted");
        }
        System.out.println(name + " This thread is finished");
    }

    //store the

}
