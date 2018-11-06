package oop_sem1_project.command;

/**
 *
 *
 */
public enum CommandWord {

    /**
     * Go command.
     */
    GO("go"),
    /**
     * Quit command.
     */
    QUIT("quit"),
    /**
     * Help command.
     */
    HELP("help"),
    /**
     * Grab command.
     */
    GRAB("grab"),
    /**
     * Use command.
     */
    USE("use"),
    /**
     * Look command.
     */
    LOOK("look"),
    /**
     * Inventory.
     */
    INVENTORY("inventory"),
    /**
     * Why command This command is an easter egg and is not shown
     */
    WHY("why"),
    /**
     * Unknown command.
     */
    UNKNOWN("?");

    /**
     * The selected enum types String field.
     */
    private final String commandString;

    /**
     * Constructor taking the selected enum types String value as argument.
     *
     * @param commandString The enum types defined String value.
     */
    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    /**
     * Overrides the toString() method from Object.
     *
     * @return The selected enum types defined String value.
     */
    @Override
    public String toString() {
        return this.commandString;
    }
}
