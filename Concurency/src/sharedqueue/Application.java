package sharedqueue;

import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    //static field
    private static AtomicInteger nextId = new AtomicInteger(10000);

    private int applicationId;
    private int requestedLimit;
    private boolean approved;
    private int approvedLimit;
    private int creditScore;

    //Constructor


    public Application(int requestedLimit, int creditScore) {
        this.requestedLimit = requestedLimit;
        this.creditScore = creditScore;
        applicationId = getNextId();
    }

    public static int getNextId() {
        return nextId.getAndIncrement();
    }

    public int getApplicationId() {
        return applicationId;
    }

    public int getRequestedLimit() {
        return requestedLimit;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }


    public void setRequestedLimit(int requestedLimit) {
        this.requestedLimit = requestedLimit;
    }

    public void setApprovedLimit(int approvedLimit) {
        this.approvedLimit = approvedLimit;
    }

    public int getApprovedLimit() {
        return approvedLimit;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                ", requestedLimit=" + requestedLimit +
                ", approved=" + approved +
                ", approvedLimit=" + approvedLimit +
                ", creditScore=" + creditScore +
                '}';
    }
}
