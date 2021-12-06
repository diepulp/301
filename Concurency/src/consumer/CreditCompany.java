/*
* Assignment: Concurrency
* Author: Vladimir Ivanov
* Date: 12/05/21
* File: CreditCompany.java
* */
package consumer;

import sharedqueue.Application;
import sharedqueue.ApplicationQueue;

/**
 * A consumer class for credit applications created by the Applicants class
 * removes an application from the shared data structure and makes a decision
 * based on application data received
 */
public class CreditCompany implements Runnable {
    private ApplicationQueue mySharedQueue;

    /**
     * Constructs a consumer of credit applications
     * @param queue Shared data structure
     */
    public CreditCompany(ApplicationQueue queue) {
        this.mySharedQueue = queue;
    }

    /**
     * Method removes and processes an application from the shared data structure
     * Data is evaluated and an approval or denial decision is made
     */
    @Override
    public void run() {
        long timeStamp = System.currentTimeMillis();
        do {
            Application app = mySharedQueue.removeApplication();
            int score = app.getCreditScore();

            //credit scores are evaluated and the credit limit is assigned
            int range = (score >= 580) && (score <= 669) ? 5000
                    : (score >= 670) && (score <= 739) ? 10000
                    : (score >= 740) && (score <= 799) ? 25000
                    : (score >= 800) ? 50000 : 0;

            if(!(range == 0)){
                app.setApproved(true);
                app.setApprovedLimit(range);
                System.out.println("Application #" + app.getApplicationId() + " with a credit score "
                        + app.getCreditScore() + " is approved for "
                        + range + " (requested: " + app.getRequestedLimit() + " )");
            }else{
                app.setApproved(false);
                System.out.println("Application #" + app.getRequestedLimit() + " with a credit score "
                        + app.getCreditScore() + " was not approved");
            }
        } while (System.currentTimeMillis() - timeStamp <= 10000);
        System.out.println("Consumer is done");
    }
}
