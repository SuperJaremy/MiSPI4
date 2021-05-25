package edu.sjar.commands;

import edu.sjar.service.ConsoleManager;
import edu.sjar.service.HistoryStorage;

public class History extends Command {

    public History() {
        name = "history";
        description = "список результатов предыдущих выстрелов";
    }

    @Override
    public boolean execute(ConsoleManager manager) {
        String[] params = manager.getParams();
        if(params.length!=0)
            return false;
        for (HistoryStorage.Result i:
             manager.getHistory().getHistory()) {
            System.out.println(i);
        }
        return true;
    }
}
