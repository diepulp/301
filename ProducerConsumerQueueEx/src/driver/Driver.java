package driver;

import consumer.Consumer;
import producer.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Driver {

    public static void main(String[] args) throws InterruptedException {
        Thread[] producers = new Thread[3];

        //create the shared blockingQueue that will be shared among the threads
        BlockingQueue<Order> orders = new LinkedBlockingDeque<>();

        //create and start Producer Threads
        for (int i = 1; i <= 3; i++) {
            producers[i-1] = new Thread(new Producer(orders), "P" + i);
            producers[i-1].start();

            //add a  join to check the queue size
            //make the main wait till the threads are done

        }

        Thread[] consumers = new Thread[2];

        for (int i = 1; i <= 2; i++) {
            //create and start Consumer Threads
            consumers[i-1] = new Thread(new Consumer(orders), "C" + i);
            consumers[i-1].start();
        }

        for(Thread t: producers){
            t.join();
        }
        for(Thread t: consumers){
            t.join();
        }

        System.out.println(orders.size());
    }
}
