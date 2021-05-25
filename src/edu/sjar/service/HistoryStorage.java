package edu.sjar.service;

import java.util.ArrayList;
import java.util.List;

public class HistoryStorage {

    private final List<Result> history;

    HistoryStorage() {
        history = new ArrayList<>();
    }

    public void addResult(double x, double y, double r, boolean hit) {
        history.add(new Result(x, y, r, hit));
    }

    public List<Result> getHistory() {
        return history;
    }

    public static class Result {
        private final double x;
        private final double y;
        private final double r;
        private final boolean hit;

        private Result(double x, double y, double r, boolean hit) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.hit = hit;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getR() {
            return r;
        }

        public boolean isHit() {
            return hit;
        }

        public String toString() {
            return x + " " + y + " " + r + ": " + hit;
        }
    }
}
