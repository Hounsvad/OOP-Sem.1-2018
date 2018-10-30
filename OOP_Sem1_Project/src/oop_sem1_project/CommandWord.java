package oop_sem1_project;

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
