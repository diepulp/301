package sharedqueue;

import java.util.concurrent.*;

public class ApplicationQueue {
    private static final int MAX = 100;
    private BlockingQueue<Application> apps
            = new ArrayBlockingQueue<>(MAX);//or LinkedBlockingQueue

    public void addApplication(Application app){
        try{
            apps.put(app);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public Application removeApplication(){
        try{
            return apps.take();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }
}
