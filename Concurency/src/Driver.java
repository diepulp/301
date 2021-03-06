import consumer.CreditCompany;
import producer.Applicants;
import sharedqueue.Application;
import sharedqueue.ApplicationQueue;

public class Driver {
    public static void main(String[] args) {
        ApplicationQueue queue = new ApplicationQueue();

        Thread[] producers = new Thread[3];
        Thread[] consumers = new Thread[2];

        // create and start up Producer Threads pass queue to the Producer Thread Constructor
        for (int i = 1; i <= 3 ; i++) {
            producers[i-1] = new Thread(new Applicants(queue), "P"+i );
            producers[i-1].start();
        }

        Thread a1 = new Thread(new Applicants(queue), "p1");
        Thread a2 = new Thread(new Applicants(queue), "p2");
        Thread a3 = new Thread(new Applicants(queue), "p3");
        Thread b = new Thread(new CreditCompany(queue), "c1");
        Thread b1 = new Thread(new CreditCompany(queue), "c2");
        a1.start();
        a2.start();
        a3.start();
        b.start();
        b1.start();
        System.out.println();
        System.out.println(queue.getSize());

    }
}
