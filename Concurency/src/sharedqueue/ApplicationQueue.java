package sharedqueue;

import java.util.concurrent.*;

public class ApplicationQueue {
    private BlockingQueue<Application> apps
            = new LinkedBlockingDeque<>();

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

    public int getSize(){
        return apps.size();
    }
}
