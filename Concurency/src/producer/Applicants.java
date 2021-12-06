/*
 * Assignment: Concurrency
 * Author: Vladimir Ivanov
 * Date: 12/05/21
 * File: Applicants.java
 * */
package producer;

import sharedqueue.Application;
import sharedqueue.ApplicationQueue;

import java.util.Random;


public class Applicants implements Runnable {
    private ApplicationQueue mySharedQueue;

    /**
     * Constructor method creates a producer of Applicants
     * @param mySharedQueue Shared data structure
     */
    public Applicants(ApplicationQueue mySharedQueue) {
        this.mySharedQueue = mySharedQueue;
    }

    public static final Random RAND = new Random();

    /**
     * method of this class will use a random number
     * generator to create the parameters needed for the credit applications.
     * makes use of addApplication() method to place the applications in the
     * data structure. Produces applications for one minute
     */
    @Override
    public void run() {

        //assign a random credit score in the range (300, 850)
        int creditScore = RAND.nextInt(300) + 550;

        //assign a random credit limit in the range (5000, 50000)
        int creditLimit = RAND.nextInt(5000) + 45000;
        int sleep = RAND.nextInt(100) + 1100;

        try {
            long timeStamp = System.currentTimeMillis();
            do {
                //create an application
                Application app = new Application(creditLimit, creditScore);
                mySharedQueue.addApplication(app);

                //'flip a coin' to decide whether to delay the thread before creating another application
                if (coinFlip()) {
                    Thread.sleep(sleep);
                    System.out.println("The producer is sleeping for " + sleep + "ms");
                }

                //display a msg in the console with a thread name and the id of application
                System.out.println(Thread.currentThread().getName()
                        + " created application #"
                        + app.getApplicationId() + " with a requested limit of " + app.getRequestedLimit());
            } while (System.currentTimeMillis() - timeStamp <= 60000);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted and is sleeping for " + sleep);
        }
        //after the allocated time is lapsed display a message that the thread is finished
        System.out.println("Producer is done producing applications " + mySharedQueue.getSize());

    }

    //helper method to generate a condition for thread time-out
    private Boolean coinFlip() {
        return new Random().nextBoolean();
    }


}//end of Applicants.java
