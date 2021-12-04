package producer;

import sharedqueue.Application;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Applicants implements Runnable{
    private BlockingQueue<Application> mySharedQueue;

    public Applicants(BlockingQueue<Application> mySharedQueue) {
        this.mySharedQueue = mySharedQueue;
    }

    /**
     * method of this class will use a random number
     * generator to create the parameters needed for the credit applications.
     * makes use of addApplication() method to place the applications in the
     * data structure. Produces applications for one minute
     */
    @Override
    public void run() {

        //assign a random credit score in the range (300, 850)
        int creditScore = new Random().nextInt(300) + 550;

        //assign a random credit limit in the range (5000, 50000)
        int creditLimit = new Random().nextInt(5000) + 45000;
        //display a msg in the console with a thread name and the id of application

        //'flip a coin' to decide whether to delay the thread before creating another application


        //after the allocated time is lapsed display a message that the thread is finished

    }
    private Boolean coinFlip(){
        return new Random().nextBoolean();
    }


}
