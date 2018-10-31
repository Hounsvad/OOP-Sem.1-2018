package oop_sem1_project;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 
 */
public class CommandWords {

    /**
     * HashMap containing all {@link CommandWord} enum types referenced by their
     * toString() value as key.
     */
    private final Map<String, CommandWord> validCommands = new HashMap<>();

    /**
     * Populates the {@link #validCommands} HashMap with all CommandWords.
     */
    public CommandWords() {
        for (CommandWord command : CommandWord.values()) {
            if (command != CommandWord.UNKNOWN) {
                this.validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Gets the {@link CommandWord} mapped to the given argument as key.
     *
     * @param commandWord The {@link CommandWord} to retrieve.
     * @return The {@link CommandWord} mapped to the argument or
     * {@link CommandWord#UNKNOWN} if none is found.
     */
    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = this.validCommands.get(commandWord);
        return command != null ? command : CommandWord.UNKNOWN;
    }

    /**
     * @param commandWord The command to check the existence of.
     * @return True if {@link #validCommands} contains the argument key. False
     * if it doesn't.
     */
    public boolean isCommand(String commandWord) {
        return this.validCommands.containsKey(commandWord);
    }

    /**
     * Prints all the keys/commandWords currently in the {@link #validCommands}
     * HashMap.
     */
    public void showAll() {
        for (String command : this.validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
