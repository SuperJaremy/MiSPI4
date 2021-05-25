package edu.sjar.commands;

import edu.sjar.service.ConsoleManager;

import java.util.Collection;

public class Help extends Command{

    public Help(){
        name = "help";
        description = "справка по командам программы";
    }

    @Override
    public boolean execute(ConsoleManager manager) {
        String[] params = manager.getParams();
        if(params.length!=0)
            return false;
        Collection<Command> commands = manager.getCommands();
        for (Command i:
             commands) {
            System.out.println(i.describe());
        }
        return true;
    }
}
