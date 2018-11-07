package oop_sem1_project;

import java.util.Arrays;
import oop_sem1_project.command.Parser;
import oop_sem1_project.command.CommandWord;
import oop_sem1_project.command.Command;
import oop_sem1_project.items.SafetyPoint;

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
        //public Room(String description, int desiredProgress, List<String> messages, String deniedMessage, String why)
        entrance = new Room("at the entrance to the TEK building", 0, new String[]{"Welcome", " ", ""}, "You are not supposed to be here yet", "");
        hall = new Room("in the main hall", 1, new String[]{"Welcome", " ", ""}, "You are not supposed to be here yet", "");
        hallway = new Room("in a hallway adjacent to the main hall", 2, new String[]{"Welcome", " ", ""}, "You are not supposed to be here yet", "");
        workshop = new Room("at a workshop for the mechanical engineering students", 3, new String[]{"Welcome", " ", ""}, "You are not supposed to be here yet", "A student cut himself on a table saw.");
        lab = new Room("at a lab for the chemical enginneers", 4, new String[]{"Welcome", " ", ""}, "You are not supposed to be here yet", "A student was really clumsy and poured boiling NaOH in his eye.");
        robtek = new Room("at the room where the robottechnology enginneers reside", 5, new String[]{"Welcome", " ", ""}, "You are not supposed to be here yet", "A robot went out of control and started a fire.");
        u55 = new Room("at the lecture hall", 6, new String[]{"Welcome", " ", ""}, "You are not supposed to be here yet", "The lecture was so boring that one of the students got a heart attack.");
        rally = new Room("at the rally point incase of emergencies", 7, new String[]{"Welcome", " ", ""}, "You are not supposed to be here yet", "You successfully escaped.");

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
                grabItem(command);
                break;
            case USE:
                useItem(command);
                break;
            case INVENTORY:
                System.out.println(this.player.getInventory().getItem().toString());
                break;
            case WHY:
                System.out.println(this.currentRoom.getWhy());
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

    private void grabItem(Command command) {
        if(this.currentRoom.getShortDescription().equals("in the main hall")){
            player.getInventory().addItem(SafetyPoint.getItem(command.getSecondWord()));
        }
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
            System.out.println(this.currentRoom.getMessage(player));
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
    
    private void useItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Use what?");
            return;
        }
        else if (!this.player.getInventory().hasItem(command.getSecondWord())) {
            System.out.println("You don't have that item.");
            return;
        }
        else if(this.player.getInventory().getItem() != null && this.player.getInventory().getItem().hasDesiredProgress(this.player.getProgress())) {
            System.out.println(this.player.getInventory().getItem().usageMessage());
            this.player.increaseProgress();
            System.out.println(this.currentRoom.getMessage(this.player));
        }
        
        
    }
}
