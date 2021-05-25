package edu.sjar.commands;

import edu.sjar.service.ConsoleManager;

public abstract class Command {
    protected String name;
    protected String description;

    public abstract boolean execute(ConsoleManager manager);

    @Override
    public String toString() {
        return name;
    }

    public String describe() {
        return name + ": " + description;
    }
}
