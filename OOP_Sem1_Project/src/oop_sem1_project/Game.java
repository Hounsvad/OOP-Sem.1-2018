package oop_sem1_project;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import oop_sem1_project.command.Parser;
import oop_sem1_project.command.CommandWord;
import oop_sem1_project.command.Command;
import oop_sem1_project.items.SafetyPoint;
import oop_sem1_project.quiz.MCQuiz;

/**
 *
 *
 * @author Pinnacle F
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

    private Date scoreTimer;

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
        entrance = new Room(
                "at the entrance to the TEK building",
                0,
                new String[]{
                    "You decide to wander around a bit",
                    "Still the same, old, boring entrance"
                },
                "This text should never appear",
                "Cos you need a job",
                0
        );

        hall = new Room(
                "in the main hall",
                0,
                new String[]{
                    "You notice a \"Safety Point\" in the corner. You should probably check it out.\nYou also notise a faint smell of burning electronics...",
                    "Maybe the \"safety point\" has something useful.",
                    "Maybe the \"safety point\" has something useful.",
                    "Maybe the \"safety point\" has something useful.",
                    "Maybe the \"safety point\" has something useful.",
                    "Maybe the \"safety point\" has something useful.",
                    "You hear a bunch of loud noises as if something has gone utterly wrong in the workshop...",
                    "You should probably go check on the workshop there is blood spilling out under the door...",
                    "There is a drastic change in noice level from U55 something is defenetly wrong.",
                    "You should check U55 somthing is wrong in there, no one is that excitet when having a lecture.",
                    "The smell of smoke is choking and you should definitely do something as you see fire everywhere!",
                    "Flee you fool"
                },
                "This text should never appear",
                "You know why",
                1
        );

        hallway = new Room(
                "in a hallway adjacent to the main hall",
                1,
                new String[]{
                    "As you walk along the empty hallway, the smell of burnt electronics gets stronger.",
                    "There is still a burning smell in the air. \nYou should find out where its coming from.",
                    ".1There is still a burning smell in the air. \nYou should find out where its coming from.",
                    "As you walk in to the hallway you hear a scream coming from the chemestry lab.",
                    "The screams are still ringing out of the chemestry lab.",
                    "The hallway appears to be empty."
                },
                "This text should never appear",
                "They did it",
                1
        );

        robtek = new Room(
                "in the room where the robottechnology enginneers reside",
                2,
                new String[]{
                    "A burning smell enters your nose. In the corner of the room you see flames shooting out of a one-armed robot.\nOne of the engineers shouts: \"Someone please help! We are trapped behind the fire spewing robot\".",
                    "They really can't put out this fire on their own",
                    "Even with the fire gone, it still smells here \nBetter move on"
                },
                "There is honestly no reason to ever be here",
                "Fisting robots apparently don't run on 690 volts...",
                1
        );

        lab = new Room(
                "in a lab for the chemical enginneers",
                4,
                new String[]{
                    "One of the chemists, screams in agony while desperatly rubbing his hands into his eyes \nYou have to help him",
                    "The chemist is still screaming \nHe could use some help",
                    "The sign still says \"Stay out, experiment in progress\" \n They are hopefully wearing safety glasses now"
                },
                "You walk up to the door of the Chemical lab, a sign on it says: \n \"Stay out, experiment in progress\"",
                "Apparently boiling NaOH does not belong in eyes...",
                1
        );

        workshop = new Room(
                "at a workshop for the mechanical engineering students",
                6,
                new String[]{
                    "You notice blood pouring from one of the student's arms. \n\"Tis but a scratch!\" he claims. \nYou should probably help him anyway...",
                    "The Student is still calm. \nThe blood puddle on the floor seems to get larger with every second",
                    "The cleaning ladies are trying to get rid of all the blood on the floor \nYou dont want to bother them"
                },
                "You enter the workshop \n The air is filled with sawdust \n There is nothing to see here.",
                "Apparently an electric bonesaw is not used to scratch an itch.\nAnd why is that not in the med-lab???",
                1
        );

        u55 = new Room(
                "at the lecture hall",
                8,
                new String[]{
                    "In the middle of all the commotion, you notice a student in the back, laying on the floor, clutching his chest",
                    "The student lying on the floor doesn't seem to be responsive \nYou should act quick!",
                    "Everyone seems to have calmed down already, some students even fell asleep..."
                },
                "Someone is giving a lecture right now, you decide to stay and listen for a while \n \" ...og som i har læst i e-tivitet 4... \" \n You decide not to listen any more and decide to head out of the room.",
                "Beware of spontaneous tests",
                1
        );
        rally = new Room(
                "at the rally point in case of emergencies",
                11,
                new String[]{
                    "Everyone gasps at the sight of the TEK building burning to ashes. \nAt least all the students are safe \n\"Wait! Has anyone seen the Rob-tek students?\"",
                    "The game should be over by now"
                },
                "Why would you leave already? The day isn't over",
                "Everything is on fire",
                1
        );

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

        scoreTimer = new Date();
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
        System.out.println("Welcome to the World of safety!");
        System.out.println("World of safety is a new, incredibly boring adventure game.");
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
     *         any other {@link Command} has been called.
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
                ClearShell.clear();
                goRoom(command);
                if (this.player.getProgress() == 12) {
                    this.player.setScore(10 - ((int) (System.currentTimeMillis() - scoreTimer.getTime()) / 60000));
                    ClearShell.clear();
                    this.player.setScore(this.player.getScore() * new MCQuiz().start());
                    wantToQuit = true;
                    System.out.println("Congratulations " + player.getName() + ". You achived a score of: " + this.player.getScore() + "/" + 50);
                }
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
            case GRAB:
                if (!command.hasSecondWord() && this.currentRoom.getShortDescription().equals("in the main hall")) {
                    System.out.println("You see the following in the safetypoint:");
                    System.out.println(SafetyPoint.getContents());
                } else {
                    grabItem(command);
                }
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

    /**
     * Takes an item if available and adds it to the inventory of the player.
     *
     * @param command
     */
    private void grabItem(Command command) {
        if (this.currentRoom.getShortDescription().equals("in the main hall") && SafetyPoint.hasItem(command.getSecondWord())) {
            player.getInventory().addItem(SafetyPoint.getItem(command.getSecondWord()));
            System.out.println("You pick up \"" + player.getInventory().getItem().getItemName() + "\" and put it in your inventory.");
        } else {
            System.out.println("You don't see that item.");
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
        } else if (this.player.getInventory().getItem().hasDesiredProgress(this.player.getProgress())) {
            System.out.println(this.player.getInventory().getItem().usageMessage());
            if (!this.player.getInventory().getItem().getItemName().equals("Map")) {
                this.player.increaseProgress();
            }
        } else {
            System.out.println("That does not seem right...");
        }
    }
}
