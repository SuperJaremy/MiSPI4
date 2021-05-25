package edu.sjar.commands;

import edu.sjar.service.ConsoleManager;
import edu.sjar.service.HistoryStorage;
import edu.sjar.service.ShotChecker;

public class Shot extends Command {

    public Shot() {
        name = "shot";
        description = "выстрелить в область радиуса R по координатам X,Y";
    }

    @Override
    public boolean execute(ConsoleManager manager) {
        String[] params = manager.getParams();
        if (params.length != 3) {
            return false;
        }
        double x;
        double y;
        double r;
        try {
            x = Double.parseDouble(params[0]);
            y = Double.parseDouble(params[1]);
            r = Double.parseDouble(params[2]);
        } catch (NumberFormatException e) {
            return false;
        }
        if(r<=0)
            return false;
        ShotChecker checker = manager.getChecker();
        HistoryStorage storage = manager.getHistory();
        boolean hit = checker.check(x, y, r);
        storage.addResult(x, y, r, hit);
        System.out.println(hit);
        return true;
    }

}
