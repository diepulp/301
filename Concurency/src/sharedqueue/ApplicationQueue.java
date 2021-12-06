/*
 * Assignment: Concurrency
 * Author: Vladimir Ivanov
 * Date: 12/05/21
 * File: ApplicationQueue.java
 * */

package sharedqueue;

import java.util.concurrent.*;

/**
 * The ApplicationQueue class represents a shared queue used by the Applicants and the CreditCompany threads.
 * It serves as a buffer for storing producer/consumer data in a thread-safe data structure
 */
public class ApplicationQueue {
    private BlockingQueue<Application> apps
            = new LinkedBlockingDeque<>();

    /**
     * Method adds data to the shared data structure using interface' put method
     * @param app Application class
     */
    public void addApplication(Application app){
        try{
            apps.put(app);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Method removes data from the data structure
     * @return and returns the data (Application in this case)
     */
    public Application removeApplication(){
        try{
            return apps.take();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    public int getSize(){
        return apps.size();
    }
}
