package oop_sem1_project;

public class Game {

    /**
     * The command {@link Parser}.
     */
    private final Parser parser = new Parser();

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
        Room outside, theatre, pub, lab, office;

        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        this.currentRoom = outside;
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
