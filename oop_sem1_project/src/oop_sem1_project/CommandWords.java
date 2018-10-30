package oop_sem1_project;

import java.util.HashMap;
import java.util.Map;

public class CommandWords {

    private final Map<String, CommandWord> validCommands = new HashMap<>();

    public CommandWords() {
        for (CommandWord command : CommandWord.values()) {
            if (command != CommandWord.UNKNOWN) {
                this.validCommands.put(command.toString(), command);
            }
        }
    }

    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = this.validCommands.get(commandWord);
        return command != null ? command : CommandWord.UNKNOWN;
    }

    public boolean isCommand(String command) {
        return this.validCommands.containsKey(command);
    }

    public void showAll() {
        for (String command : this.validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
