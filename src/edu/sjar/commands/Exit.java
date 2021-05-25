package edu.sjar.commands;

import edu.sjar.service.ConsoleManager;

public class Exit extends Command{

    public Exit(){
        name="exit";
        description="выйти из программы";
    }

    @Override
    public boolean execute(ConsoleManager manager) {
        String[] params = manager.getParams();
        if(params.length!=0)
            return false;
        manager.setExit(true);
        return true;
    }
}
