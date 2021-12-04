package consumer;

import sharedqueue.Application;

import java.util.concurrent.BlockingQueue;

public class CreditCompany implements Runnable {
    private  BlockingQueue<Application> mySharedQueue;

    public CreditCompany(BlockingQueue<Application> queue) {
        this.mySharedQueue = queue;
    }

    @Override
    public void run() {
        try{
            Application app = mySharedQueue.take();
            System.out.println(Thread.currentThread().getName()
                    + " takes off application " + app);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
