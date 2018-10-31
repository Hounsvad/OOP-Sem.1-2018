package oop_sem1_project;

import java.util.Scanner;

/**
 *
 * 
 */
public class Parser {

    /**
     * The registered {@link CommandWords}.
     */
    private final CommandWords commands = new CommandWords();

    /**
     * The Scanner taking user input from the console/terminal.
     */
    private final Scanner reader = new Scanner(System.in);

    /**
     * @return the next {@link Command} the user calls.
     */
    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = this.reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        return new Command(this.commands.getCommandWord(word1), word2);
    }

    /**
     * Prints a message containing all registered commands.
     */
    public void showCommands() {
        this.commands.showAll();
    }
}
