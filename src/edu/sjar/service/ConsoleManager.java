package edu.sjar.service;

import edu.sjar.commands.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleManager {
    private boolean exit;
    private String[] params;
    private final ShotChecker checker;
    private final HistoryStorage history;
    private final HashMap<String, Command> commands;

    public ConsoleManager(){
        checker = new ShotChecker();
        history = new HistoryStorage();
        commands = new HashMap<>();
        params = new String[0];
    }

    public void start(){
        exit = false;
        Shot shot = new Shot();
        Help help = new Help();
        History historyCommand = new History();
        Exit exit1 = new Exit();
        commands.put(historyCommand.toString(), historyCommand);
        commands.put(shot.toString(), shot);
        commands.put(help.toString(), help);
        commands.put(exit1.toString(), exit1);
        help.execute(this);
        Scanner input = new Scanner(System.in);
        while (!exit){
            params = new String[0];
            String line = input.nextLine();
            int space = line.indexOf(" ");
            String command;
            if(space!=-1) {
                command = line.substring(0, line.indexOf(" "));
                if(space<line.length()-1) {
                    String parameters = line.substring(line.indexOf(" ") + 1);
                    params = parameters.split(" ");
                }
            }
            else
                command = line;
            if(commands.containsKey(command)){
                Command exec = commands.get(command);
                if(!exec.execute(this)){
                    printError(command, "Команда не смогла выполниться");
                }
                else{
                    System.out.println("Команда успешно выполнена");
                }
            }
            else{
                printError(command, "Нет такой команды");
            }
        }
    }

    private void printError(String command, String message){
        System.out.println("Ошибка в команде "+command);
        System.out.println(message);
    }

    public void setExit(boolean exit){
        this.exit = exit;
    }

    public String[] getParams(){
        return params;
    }

    public ShotChecker getChecker(){
        return checker;
    }

    public HistoryStorage getHistory(){
        return history;
    }

    public Collection<Command> getCommands(){
        return commands.values();
    }
}
