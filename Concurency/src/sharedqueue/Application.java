package sharedqueue;

import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    //static field
    private static AtomicInteger genId = new AtomicInteger(1);

    private int applicationId;
    private int requestedLimit;
    private boolean approved;
    private int approvedLimit;
    private int creditScore;
    private static int nextId;



    //Constructor
    public Application(int creditScore, int requestedLimit){
        this.creditScore = creditScore;
        this.requestedLimit = requestedLimit;
        this.nextId = getNextId();

    }


    public static int getNextId() {
        return genId.getAndIncrement();
    }

    public static void setNextId(AtomicInteger nextId) {
        Application.genId = nextId;
    }
    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getRequestedLimit() {
        return requestedLimit;
    }

    public void setRequestedLimit(int requestedLimit) {
        this.requestedLimit = requestedLimit;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getApprovedLimit() {
        return approvedLimit;
    }

    public void setApprovedLimit(int approvedLimit) {
        this.approvedLimit = approvedLimit;
    }
}
