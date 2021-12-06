/*
 * Assignment: Concurrency
 * Author: Vladimir Ivanov
 * Date: 12/05/21
 * File: Application.java
 * */
package sharedqueue;

import java.util.concurrent.atomic.AtomicInteger;

    /**
     * Application Class represents a credit card application
     * it stores all the data for producer and consumer to generate a new application
     * and then process it based on the given application data
     */
public class Application {

    //static field to produce consistent results
    private static AtomicInteger nextId = new AtomicInteger(10000);

    private int applicationId;
    private int requestedLimit;
    private boolean approved;
    private int approvedLimit;
    private int creditScore;

    //Constructor

    /**
     * Constructor creates an application and assigns an id provided by the Atomic Integer
     * @param requestedLimit the requested amount for a give credit application
     * @param creditScore credit score to determine the amount if approved
     */
    public Application(int requestedLimit, int creditScore) {
        this.requestedLimit = requestedLimit;
        this.creditScore = creditScore;
        applicationId = getNextId();
    }

    //Setters and getters for the instance fields
    public int getNextId() {
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

    // returns a string with the application data summary
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
