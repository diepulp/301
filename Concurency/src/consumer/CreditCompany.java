package consumer;

import sharedqueue.Application;
import sharedqueue.ApplicationQueue;

import java.util.concurrent.BlockingQueue;

public class CreditCompany implements Runnable {
    private ApplicationQueue mySharedQueue;

    public CreditCompany(ApplicationQueue queue) {
        this.mySharedQueue = queue;
    }

    @Override
    public void run() {
        long timeStamp = System.currentTimeMillis();
        do {
            Application app = mySharedQueue.removeApplication();
            String name = Thread.currentThread().getName();
            int score = app.getCreditScore();
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
        } while (System.currentTimeMillis() - timeStamp <= 5000);
        System.out.println("Consumer is done");
    }
}
