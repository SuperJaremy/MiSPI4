package edu.sjar.service;


public class ShotChecker {

    public boolean check(double x, double y, double r) {
        return checkAreaOne(x, y, r) || checkAreaTwo(x, y, r) || checkAreaThree(x, y, r) || checkAreaFour(x, y, r);
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
}
