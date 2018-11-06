/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two parts: a CommandWord and a string
 * (for example, if the command was "take map", then the two parts
 * are TAKE and "map").
 *
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the CommandWord is UNKNOWN.
 *
 * If the command had only one word, then the second word is <null>.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
package Command;

/**
 *
 * 
 */
public class Command {

    /**
     * This commands {@link CommandWord}
     */
    private final CommandWord commandWord;

    /**
     * An optional second argument/word for the command.
     */
    private final String secondWord;

    /**
     * Constructs a Command Object with only one word.
     *
     * @param commandWord The commandWord.
     */
    public Command(CommandWord commandWord) {
        this(commandWord, "");
    }

    /**
     * Construct a Command Object with potentially two words.
     *
     * @param commandWord The command word.
     * @param secondWord The second command word.
     */
    public Command(CommandWord commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    /**
     * @return the commandWord.
     */
    public CommandWord getCommandWord() {
        return this.commandWord;
    }

    /**
     * @return the secondWord.
     */
    public String getSecondWord() {
        return this.secondWord;
    }

    /**
     * @return whether or not the commandWord is unknown.
     */
    public boolean isUnknown() {
        return this.commandWord == CommandWord.UNKNOWN;
    }

    /**
     * Evaluates if this command has a second word by checking if the second
     * word is either null or the String is empty.
     *
     * @return whether or not this command has a second word.
     */
    public boolean hasSecondWord() {
        return this.secondWord != null && !this.secondWord.isEmpty();
    }
}
