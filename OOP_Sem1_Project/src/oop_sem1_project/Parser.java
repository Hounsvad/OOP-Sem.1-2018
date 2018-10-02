package oop_sem1_project;

import java.util.Scanner;

public class Parser {

    private final CommandWords commands = new CommandWords();
    private final Scanner reader = new Scanner(System.in);

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

    public void showCommands() {
        this.commands.showAll();
    }
}
