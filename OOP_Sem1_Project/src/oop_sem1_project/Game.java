package oop_sem1_project;

import oop_sem1_project.command.Parser;
import oop_sem1_project.command.CommandWord;
import oop_sem1_project.command.Command;

/**
 *
 *
 */
public class Game {

    /**
     * The command {@link Parser}.
     */
    private final Parser parser = new Parser();

    /**
     * The player name - currently hardcoded - change to user input
     */
    private final String playerName = "Player1";

    /**
     * The player
     */
    private final Player player = new Player(playerName);

    /**
     * The current {@link Room}.
     */
    private Room currentRoom;

    /**
     * Calls the {@link #createRooms()} method once constructed.
     */
    public Game() {
        createRooms();
    }

    /**
     * Creates all the rooms in the game.
     */
    private void createRooms() {
        Room entrance, hall, hallway, workshop, lab, robtek, u55, rally;

        entrance = new Room("The entrance to the TEK building");
        hall = new Room("The main hall");
        hallway = new Room("A hallway adjacent to the main hall");
        workshop = new Room("A workshop for the mechanical engineering students");
        lab = new Room("A lab for the chemical enginneers");
        robtek = new Room("A room where the robottechnology enginneers reside");
        u55 = new Room("A lecture hall");
        rally = new Room("A rally point incase of emergencies");

        entrance.setExit("north", hall);
        entrance.setExit("south", rally);

        hall.setExit("south", entrance);
        hall.setExit("north", hallway);
        hall.setExit("east", workshop);
        hall.setExit("west", u55);

        hallway.setExit("east", lab);
        hallway.setExit("west", robtek);
        hallway.setExit("south", hall);

        lab.setExit("west", hallway);

        robtek.setExit("east", hallway);

        u55.setExit("east", hall);

        workshop.setExit("west", hall);

        rally.setExit("north", entrance);

        this.currentRoom = entrance;
    }

    /**
     * Starts the game. This method is called in
     * {@link Worldofzuul#main(java.lang.String[]) main}.
     */
    public void play() {
        printWelcome();

        // Main game loop.
        boolean finished = false;
        while (!finished) {
            Command command = this.parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Prints a welcome message on startup.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(this.currentRoom.getLongDescription());
    }

    /**
     * Processes the selected command the Player has inputted.
     *
     * @param command The called {@link Command}.
     * @return True if the Player has called {@link CommandWord#QUIT}. False if
     * any other {@link Command} has been called.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        switch (commandWord) {
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
            case GRAB:
                //To be implementerd
                break;
            case USE:
                //To be implementerd
                break;
            case LOOK:
                //To be implementerd
                break;
            case INVENTORY:
                //To be implementerd
                break;
            case DO:
                //To be implementerd
                break;
            case LISTEN:
                //To be implementerd
                break;
            case WHY:
                //To be implementerd
                break;

            default:
                break;
        }
        return wantToQuit;
    }

    /**
     * Prints a help message if the user has called the
     * {@link CommandWord#HELP help command}.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        this.parser.showCommands();
    }

    /**
     * Goes to the room specified in the {@link Command#secondWord second word}
     * when the {@link CommandWord#GO go command} is called.
     *
     * @param command The called command.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = this.currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            this.currentRoom = nextRoom;
            System.out.println(this.currentRoom.getLongDescription());
        }
    }

    /**
     * Quit the game.
     *
     * @param command The called Command.
     * @return True if the command has a second word. False if it has.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
        }
        return !command.hasSecondWord();
    }
}
