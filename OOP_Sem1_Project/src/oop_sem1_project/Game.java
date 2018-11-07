package oop_sem1_project;

import java.util.Arrays;
import java.util.Scanner;
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
     * The player
     */
    private Player player;

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
        entrance = new Room("at the entrance to the TEK building", 0, new String[]{"You decide to wander around a bit", "Still the same, old, boring entrance", "Still the same, old, boring entrance"}, "This text should never appear", "Who knows");
        hall = new Room("in the main hall", 1, new String[]{"You notice a \"Safety Point\" in the corner. You should probably check it out", "maybe the \"safety point\" has something useful", "maybe the \"safety point\" has something useful"}, "This text should never appear", "Who knows");
        hallway = new Room("in a hallway adjacent to the main hall", 2, new String[]{"As you walk along the empty hallway, you notice a smell of burnt robot", "There is still a burning smell in the air \nYou should find out where its coming from", "The hallway appears to be empty"}, "This text should never appear", "Who knows");
        robtek = new Room("in the room where the robottechnology enginneers reside", 3, new String[]{"A burning smell enters your nose. In the corner of the room you see flames shooting out of a one-armed robot.\nOne of the engineers shouts: \"Someone please help! We are useless\"","They really can't put out this fire on their own", "Even with the fire gone, it still smells here \nBetter move on"}, "There is honestly no reason to ever be here", "Who knows");
        lab = new Room("in a lab for the chemical enginneers", 4, new String[]{"One of the chemists, screams in agony while desperatly rubbing his hands into his left eye \nYou have to help him","The chemist is still screaming \nHe could use some help", "The sign still says \"Stay out, experiment in progress\" \n They are hopefully wearing safety glasses now"}, "You walk up to the door of the Chemical lab, a sign on it says: \n \"Stay out, experiment in progress\"", "Who knows");
        workshop = new Room("at a workshop for the mechanical engineering students", 5, new String[]{"You notice blood dripping from one of the students arm. \n\"Tis but a scratch!\" he claims. \nYou should probably help him anyway","The Student is still calm \nThe blood puddle on the floor seems to get larger with every second", "The cleaning ladies are trying to get rid of all the blood on the floor \nYou dont want to bother them"}, "You enter the workshop \n The air is filled with sawdust \n There is nothing to see here.", "Who knows");
        u55 = new Room("at the lecture hall", 6, new String[]{"In the middle of all the commotion, you notice a student in the back, laying on the floor, clutching his chest", "The student lying on the floor doesn't seem to be responsive \nYou should act quick!", "Everyone seems to have calmed down already, some students even fell asleep"}, "Someone is giving a lecture right now, you decide to stay and listen for a while \n \" ...og som i har læst i e-tivitet 4... \" \n You instantly walk out of the room", "Who knows");
        rally = new Room("at the rally point in case of emergencies", 7, new String[]{"Everyone gasps at the sight of the TEK building burning to ashes. \nAt least all the students are safe \n\"Wait! Has anyone seen the Rob-tek students?\"", "The game should be over by now"}, "Why would you leave already? The day isn't over", "Who knows");

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
        System.out.println("What is your name?");
        this.player = new Player(new Scanner(System.in).next());
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
        if (this.currentRoom.getShortDescription().equals("in the main hall")) {
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
        } else if (!this.player.getInventory().hasItem(command.getSecondWord())) {
            System.out.println("You don't have that item.");
        } else if (this.player.getInventory().getItem() != null && this.player.getInventory().getItem().hasDesiredProgress(this.player.getProgress())) {
            System.out.println(this.player.getInventory().getItem().usageMessage());
            this.player.increaseProgress();
            System.out.println(this.currentRoom.getMessage(this.player));
        }
    }
}
