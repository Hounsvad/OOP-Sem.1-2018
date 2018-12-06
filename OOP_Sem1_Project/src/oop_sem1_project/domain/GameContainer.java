/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.ArrayList;
import java.util.List;
import oop_sem1_project.domain.popups.Popup;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class GameContainer {

    private final List<Room> rooms = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();

    private Popup popup;
    private Player player;

    public void inititalize(String playerName) {
        this.player = new Player(playerName, new int[]{100, 100}, "player", "I am a Player");

        Room entrance = new Room("Entrance", new String[]{"RoomTemplate0", "RoomTemplate1", "RoomTemplate2"}, 0, false);
        entrance.addMessage(0, "You decide to wander around a bit");
        entrance.addMessage(1, "Still the same, old, boring entrance");

        Room hall = new Room("Hall", new String[]{"Hall0", "Hall1", "Hall2"}, 0, false);
        hall.addMessage(0, "You notice a \"Safety Point\" in the corner. You should probably check it out.\nYou also notise a faint smell of burning electronics...");
        hall.addMessage(1, "Maybe the \"safety point\" has something useful.");
        hall.addMessage(6, "You hear a bunch of loud noises as if something has gone utterly wrong in the workshop...");
        hall.addMessage(7, "You should probably go check on the workshop there is blood spilling out under the door...");
        hall.addMessage(8, "There is a drastic change in noice level from U55 something is defenetly wrong.");
        hall.addMessage(9, "You should check U55 somthing is wrong in there, no one is that excitet when having a lecture.");
        hall.addMessage(10, "The smell of smoke is choking and you should definitely do something as you see fire everywhere!");
        hall.addMessage(11, "Flee you fool!");

        Room hallway = new Room("Hallway", new String[]{"Hallway0", "Hallway1", "Hallway2"}, 1, false);
        hallway.addMessage(-1000, "As you walk along the empty hallway, the smell of burnt electronics gets stronger.");
        hallway.addMessage(1, "There is still a burning smell in the air. \nYou should find out where its coming from.");
        hallway.addMessage(2, "As you walk in to the hallway you hear a scream coming from the chemestry lab.");
        hallway.addMessage(3, "The screams are still ringing out of the chemestry lab.");
        hallway.addMessage(4, "The hallway appears to be empty.");

        Room robtek = new Room("Rob-tek", new String[]{"RobTek0", "RobTek1", "RobTek2"}, 2, true);
        robtek.addMessage(-1000, "There is honestly no reason to ever be here");
        robtek.addMessage(1, "A burning smell enters your nose. In the corner of the room you see flames shooting out of a one-armed robot.\nOne of the engineers shouts: \"Someone please help! We are trapped behind the fire spewing robot\".");
        robtek.addMessage(2, "They really can't put out this fire on their own");
        robtek.addMessage(3, "Even with the fire gone, it still smells here \nBetter move on");

        Room chemlab = new Room("Chem-lab", new String[]{"ChemLab0", "ChemLab1", "ChemLab2"}, 4, true);
        chemlab.addMessage(-1000, "You walk up to the door of the Chemical lab, a sign on it says: \n \"Stay out, experiment in progress\"");
        chemlab.addMessage(1, "One of the chemists, screams in agony while desperatly rubbing his hands into his eyes \nYou have to help him");
        chemlab.addMessage(2, "The chemist is still screaming \nHe could use some help");
        chemlab.addMessage(3, "The sign still says \"Stay out, experiment in progress\" \n They are hopefully wearing safety glasses now");

        Room workshop = new Room("Workshop", new String[]{"Workshop0", "Workshop1", "Workshop2"}, 6, true);
        workshop.addMessage(-1000, "You enter the workshop \n The air is filled with sawdust \n There is nothing to see here.");
        workshop.addMessage(1, "You notice blood pouring from one of the student's arms. \n\"Tis but a scratch!\" he claims. \nYou should probably help him anyway...");
        workshop.addMessage(2, "The Student is still calm. \nThe blood puddle on the floor seems to get larger with every second");
        workshop.addMessage(3, "The cleaning ladies are trying to get rid of all the blood on the floor \nYou dont want to bother them");

        Room u55 = new Room("U55", new String[]{"U550", "U551", "U552"}, 8, true);
        u55.addMessage(-1000, "Someone is giving a lecture right now, you decide to stay and listen for a while \n \" ...og som i har læst i e-tivitet 4... \" \n You decide not to listen any more and decide to head out of the room.");
        u55.addMessage(1, "In the middle of all the commotion, you notice a student in the back, laying on the floor! Someone is allready doing cpr.");
        u55.addMessage(2, "The student lying on the floor doesn't seem to be responsive and its allready been a little while \nYou should act quick!");
        u55.addMessage(3, "Everyone seems to have calmed down already, some students even fell asleep...");

        Room rallypoint = new Room("Rallypoint", new String[]{"Rallypoint0", "Rallypoint1", "Rallypoint2"}, 11, true);
        rallypoint.addMessage(-1000, "Why would you leave already? The day isn't over");
        rallypoint.addMessage(1, "Everyone gasps at the sight of the TEK building burning to ashes. \nAt least all the students are safe \n\"Wait! Has anyone seen the Rob-tek students?\"");

        rooms.add(hall);
        rooms.add(hallway);
        rooms.add(robtek);
        rooms.add(chemlab);
        rooms.add(workshop);
        rooms.add(u55);
        rooms.add(rallypoint);
        this.player.setCurrentRoom(entrance);
        
        items.add(new Item("fire-extinguisher", "_0000_Brandslukker", "A CO2 filled vessel with a release handle", 0));
        items.add(new Item("defibrilator", "_0001_Øjen", "A ciplock bag full of murky sea water", 1));
        items.add(new Item("first-aid", "_0002_AED", "A medicaly approved arc-reactor-powered tazer in red and gold colour scheme", 2));
        items.add(new Item("eyewash", "_0003_Førstehjælp", "A bag of old socks from lost and found", 3));

    }

    public Popup getPopup() {
        return this.popup;
    }

    public void setPopup(Popup popup) {
        this.popup = popup;
    }

    public Player getPlayer() {
        return this.player;
    }

    public List<Item> getItems() {
        return items;
    }
}
