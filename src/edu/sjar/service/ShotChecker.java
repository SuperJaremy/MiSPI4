package edu.sjar.service;


import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;


public class ShotChecker extends NotificationBroadcasterSupport implements ShotCheckerMBean {

    private long numberOfPoints = 0;

    private long numberOfPointsInArea = 0;

    private long notificationNumber;

    public boolean check(double x, double y, double r) {
        checkIfVisible(x, y, r);
        numberOfPoints++;
        boolean hit = checkAreaOne(x, y, r) || checkAreaTwo(x, y, r) || checkAreaThree(x, y, r) || checkAreaFour(x, y, r);
        if (hit)
            numberOfPointsInArea++;
        return hit;
    }

    private boolean checkAreaOne(double x, double y, double r) {
        if (x < 0 || y < 0)
            return false;
        return Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2);
    }

    private boolean checkAreaTwo(double x, double y, double r) {
        if (x > 0 || y < 0)
            return false;
        return y <= x / 2 + r / 2;
    }

    private boolean checkAreaThree(double x, double y, double r) {
        if (x > 0 || y > 0)
            return false;
        return y >= -r && x >= -r / 2;
    }

    private boolean checkAreaFour(double x, double y, double r) {
        if (x < 0 || y > 0)
            return false;
        return false;
    }

    private void checkIfVisible(double x, double y, double r) {
        if (x > 1.5 * r || y > 1.5 * r) {
            Notification n = new Notification("Notification", this, notificationNumber++, String.format("Точка с координатами (%f,%f) не помещается на картинку области радиуса %f", x, y, r));
            sendNotification(n);
        }
    }

    @Override
    public long getNumberOfPoints() {
        return numberOfPoints;
    }

    @Override
    public long getNumberOfPointsInArea() {
        return numberOfPointsInArea;
    }
}
