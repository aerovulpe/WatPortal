package me.aerovulpe.watportal.resources.courses.schedule;

/**
 * Created by Aaron on 11/12/2014.
 */
public class Reserve {
    private String reserveGroup;
    private int enrollmentCapacity;
    private int enrollmentTotal;

    public String getReserveGroup() {
        return reserveGroup;
    }

    public void setReserveGroup(String reserveGroup) {
        this.reserveGroup = reserveGroup;
    }

    public int getEnrollmentCapacity() {
        return enrollmentCapacity;
    }

    public void setEnrollmentCapacity(int enrollmentCapacity) {
        this.enrollmentCapacity = enrollmentCapacity;
    }

    public int getEnrollmentTotal() {
        return enrollmentTotal;
    }

    public void setEnrollmentTotal(int enrollmentTotal) {
        this.enrollmentTotal = enrollmentTotal;
    }
}
