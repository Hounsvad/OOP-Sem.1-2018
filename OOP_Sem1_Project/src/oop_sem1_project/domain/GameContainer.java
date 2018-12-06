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
        
        entrance.addInteractableArea("doorNorth", new InteractableArea("doorNorth", new int[]{400,0}, new int[]{100,50}, 50, "door", null));
        entrance.addInteractableArea("doorSouth", new InteractableArea("doorSouth", new int[]{400,450}, new int[]{100,50}, 50, "door", null));

        Room hall = new Room("Hall", new String[]{"Hall0", "Hall1", "Hall2"}, 0, false);
        hall.addMessage(0, "You notice a \"Safety Point\" in the corner. You should probably check it out.\nYou also notise a faint smell of burning electronics...");
        hall.addMessage(1, "Maybe the \"safety point\" has something useful.");
        hall.addMessage(6, "You hear a bunch of loud noises as if something has gone utterly wrong in the workshop...");
        hall.addMessage(7, "You should probably go check on the workshop there is blood spilling out under the door...");
        hall.addMessage(8, "There is a drastic change in noice level from U55 something is defenetly wrong.");
        hall.addMessage(9, "You should check U55 somthing is wrong in there, no one is that excitet when having a lecture.");
        hall.addMessage(10, "The smell of smoke is choking and you should definitely do something as you see fire everywhere!");
        hall.addMessage(11, "Flee you fool!");

        hall.addInteractableArea("doorNorth", new InteractableArea("doorNorth", new int[]{400, 0}, new int[]{100, 50}, 50, "door", null));
        hall.addInteractableArea("doorEast", new InteractableArea("doorEast", new int[]{850, 200}, new int[]{50, 100}, 50, "door", null));
        hall.addInteractableArea("doorSouth", new InteractableArea("doorSouth", new int[]{400, 450}, new int[]{100, 50}, 50, "door", null));
        hall.addInteractableArea("doorWest", new InteractableArea("doorWest", new int[]{0, 200}, new int[]{50, 100}, 50, "door", null));
        hall.addInteractableArea("safetyPoint", new InteractableArea("safetyPoint", new int[]{650, 450}, new int[]{100, 50}, 50, "safetypoint", null));

        Room hallway = new Room("Hallway", new String[]{"Hallway0", "Hallway1", "Hallway2"}, 1, false);
        hallway.addMessage(-1000, "As you walk along the empty hallway, the smell of burnt electronics gets stronger.");
        hallway.addMessage(1, "There is still a burning smell in the air. \nYou should find out where its coming from.");
        hallway.addMessage(2, "As you walk in to the hallway you hear a scream coming from the chemestry lab.");
        hallway.addMessage(3, "The screams are still ringing out of the chemestry lab.");
        hallway.addMessage(4, "The hallway appears to be empty.");

        hallway.addInteractableArea("doorEast", new InteractableArea("doorEast", new int[]{850, 200}, new int[]{50, 100}, 50, "door", null));
        hallway.addInteractableArea("doorSouth", new InteractableArea("doorSouth", new int[]{400, 450}, new int[]{100, 50}, 50, "door", null));
        hallway.addInteractableArea("doorWest", new InteractableArea("doorWest", new int[]{0, 200}, new int[]{50, 100}, 50, "door", null));

        Room robtek = new Room("Rob-tek", new String[]{"RobTek0", "RobTek1", "RobTek2"}, 2, true);
        robtek.addMessage(-1000, "There is honestly no reason to ever be here");
        robtek.addMessage(1, "A burning smell enters your nose. In the corner of the room you see flames shooting out of a one-armed robot.\nOne of the engineers shouts: \"Someone please help! We are trapped behind the fire spewing robot\".");
        robtek.addMessage(2, "They really can't put out this fire on their own");
        robtek.addMessage(3, "Even with the fire gone, it still smells here \nBetter move on");

        robtek.addInteractableArea("doorEast", new InteractableArea("doorEast", new int[]{850, 200}, new int[]{50, 100}, 50, "door", null));
        robtek.addInteractableArea("table", new InteractableArea("table", new int[]{0, 100}, new int[]{250, 100}, 0, "none", null));
        robtek.addInteractableArea("robotFire", new InteractableArea("robotFire", new int[]{250, 0}, new int[]{150, 250}, 50, "emergency", null));

        Room chemlab = new Room("Chem-lab", new String[]{"ChemLab0", "ChemLab1", "ChemLab2"}, 4, true);
        chemlab.addMessage(-1000, "You walk up to the door of the Chemical lab, a sign on it says: \n \"Stay out, experiment in progress\"");
        chemlab.addMessage(1, "One of the chemists, screams in agony while desperatly rubbing his hands into his eyes \nYou have to help him");
        chemlab.addMessage(2, "The chemist is still screaming \nHe could use some help");
        chemlab.addMessage(3, "The sign still says \"Stay out, experiment in progress\" \n They are hopefully wearing safety glasses now");

        chemlab.addInteractableArea("doorWest", new InteractableArea("doorWest", new int[]{0, 200}, new int[]{50, 100}, 50, "door", null));
        chemlab.addInteractableArea("closetWest", new InteractableArea("closetWest", new int[]{0, 0}, new int[]{300, 100}, 0, "none", null));
        chemlab.addInteractableArea("tableWest", new InteractableArea("tableWest", new int[]{200, 100}, new int[]{100, 250}, 0, "none", null));
        chemlab.addInteractableArea("closetEast", new InteractableArea("closetEast", new int[]{0, 200}, new int[]{50, 100}, 0, "none", null));
        chemlab.addInteractableArea("tableEast", new InteractableArea("tableEast", new int[]{0, 200}, new int[]{50, 100}, 0, "none", null));
        chemlab.addInteractableArea("chemStudent", new InteractableArea("chemStudent", new int[]{0, 200}, new int[]{50, 100}, 50, "emergency", null));

        Room workshop = new Room("Workshop", new String[]{"Workshop0", "Workshop1", "Workshop2"}, 6, true);
        workshop.addMessage(-1000, "You enter the workshop \n The air is filled with sawdust \n There is nothing to see here.");
        workshop.addMessage(1, "You notice blood pouring from one of the student's arms. \n\"Tis but a scratch!\" he claims. \nYou should probably help him anyway...");
        workshop.addMessage(2, "The Student is still calm. \nThe blood puddle on the floor seems to get larger with every second");
        workshop.addMessage(3, "The cleaning ladies are trying to get rid of all the blood on the floor \nYou dont want to bother them");

        workshop.addInteractableArea("doorWest", new InteractableArea("doorWest", new int[]{0, 200}, new int[]{50, 100}, 50, "door", null));
        workshop.addInteractableArea("closetWest", new InteractableArea("closetWest", new int[]{0, 0}, new int[]{300, 100}, 0, "none", null));
        workshop.addInteractableArea("closetEast", new InteractableArea("closetEast", new int[]{350, 0}, new int[]{300, 100}, 0, "none", null));
        workshop.addInteractableArea("tableWest", new InteractableArea("tableWest", new int[]{150, 150}, new int[]{100, 250}, 0, "none", null));
        workshop.addInteractableArea("tableCenter", new InteractableArea("tableCenter", new int[]{350, 150}, new int[]{100, 250}, 0, "none", null));
        workshop.addInteractableArea("tableEast", new InteractableArea("tableEast", new int[]{550, 150}, new int[]{100, 250}, 0, "none", null));
        workshop.addInteractableArea("woodPile", new InteractableArea("woodPile", new int[]{800, 0}, new int[]{100, 500}, 0, "none", null));
        workshop.addInteractableArea("workshopStudent", new InteractableArea("workshopStudent", new int[]{650, 300}, new int[]{50, 100}, 50, "emergency", null));

        Room u55 = new Room("U55", new String[]{"U550", "U551", "U552"}, 8, true);
        u55.addMessage(-1000, "Someone is giving a lecture right now, you decide to stay and listen for a while \n \" ...og som i har læst i e-tivitet 4... \" \n You decide not to listen any more and decide to head out of the room.");
        u55.addMessage(1, "In the middle of all the commotion, you notice a student in the back, laying on the floor! Someone is allready doing cpr.");
        u55.addMessage(2, "The student lying on the floor doesn't seem to be responsive and its allready been a little while \nYou should act quick!");
        u55.addMessage(3, "Everyone seems to have calmed down already, some students even fell asleep...");

        u55.addInteractableArea("doorEast", new InteractableArea("doorEast", new int[]{850, 200}, new int[]{50, 100}, 50, "door", null));
        u55.addInteractableArea("tabelNorth1", new InteractableArea("tabelNorth1", new int[]{150, 0}, new int[]{50, 200}, 0, "none", null));
        u55.addInteractableArea("tableNorth2", new InteractableArea("tableNorth2", new int[]{250, 0}, new int[]{50, 200}, 0, "none", null));
        u55.addInteractableArea("tableNorth3", new InteractableArea("tableNorth3", new int[]{350, 0}, new int[]{50, 200}, 0, "none", null));
        u55.addInteractableArea("tableNorth4", new InteractableArea("tableNorth4", new int[]{450, 0}, new int[]{50, 200}, 0, "none", null));
        u55.addInteractableArea("tableNorth5", new InteractableArea("tableNorth5", new int[]{550, 0}, new int[]{50, 200}, 0, "none", null));
        u55.addInteractableArea("tableSouth1", new InteractableArea("tableSouth1", new int[]{150, 250}, new int[]{50, 200}, 0, "none", null));
        u55.addInteractableArea("tableSouth2", new InteractableArea("tableSouth2", new int[]{250, 250}, new int[]{50, 200}, 0, "none", null));
        u55.addInteractableArea("tableSouth3", new InteractableArea("tableSouth3", new int[]{350, 250}, new int[]{50, 200}, 0, "none", null));
        u55.addInteractableArea("tableSouth4", new InteractableArea("tableSouth4", new int[]{450, 250}, new int[]{50, 200}, 0, "none", null));
        u55.addInteractableArea("tableSouth5", new InteractableArea("tableSouth5", new int[]{550, 250}, new int[]{50, 200}, 0, "none", null));
        u55.addInteractableArea("podium", new InteractableArea("podium", new int[]{50, 200}, new int[]{50, 100}, 0, "none", null));
        u55.addInteractableArea("heartAttack", new InteractableArea("heartAttack", new int[]{600, 350}, new int[]{50, 100}, 50, "emergency", null));

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

        items.add(new Item("fire-extinguisher", "_0000_Brandslukker", "A CO2 filled vessel with a release handle", 0, "*SPWOOOOOOSH!* Goes the fire-extinguisher"));
        items.add(new Item("defibrilator", "_0001_Øjen", "A ciplock bag full of murky sea water", 1, "*SPLASH* Goes the eyewash"));
        items.add(new Item("first-aid", "_0002_AED", "A medicaly approved arc-reactor-powered tazer in red and gold colour scheme", 2, "*BZZZZZT* Goes the fancy tazer"));
        items.add(new Item("eyewash", "_0003_Førstehjælp", "A bag of old socks from lost and found", 3, "As the socks are stuffed into the wound the patient screams in agony"));

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
