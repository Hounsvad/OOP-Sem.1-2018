/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.items;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pinnacle F
 */
public class SafetyPoint {

    private static final Map<String, Item> CONTENTS = new HashMap<>();

    static {
        CONTENTS.put("map", new Item("Map", "An e-Map",
                "####################################################\n"
                + "#             World of Fire Safety Map             #\n"
                + "####################################################\n"
                + "#               #                #                 #\n"
                + "#    Rob-Tek    #    Hallway     #      Chem       #\n"
                + "#               #                #                 #\n"
                + "####################################################\n"
                + "#               #                #                 #\n"
                + "#      U55      #      Hall      #    Workshop     #\n"
                + "#               #                #                 #\n"
                + "####################################################\n"
                + "                #                #\n"
                + "                #    Entrance    #\n"
                + "                #                #\n"
                + "                ##################\n"
                + "                #                #\n"
                + "                #   Rally Point  #\n"
                + "                #                #\n"
                + "                ##################", Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)));
        CONTENTS.put("fire-extinguisher", new Item("Fire-extinguisher", "A CO2 filled vessel with a release handle", "*SPWOOOOOOSH!* Goes the fire-extinguisher", Arrays.asList(3)));
        CONTENTS.put("eyewash", new Item("Eyewash", "A saline solution in a handy container", "*SPLASH* Goes the eyewash", Arrays.asList(5)));
        CONTENTS.put("defibrilator", new Item("Defibrilator", "A medicaly approved arc-reactor-powered tazer in red and gold colour scheme", "*BZZZZZT* Goes the fancy tazer", Arrays.asList(9)));
        CONTENTS.put("first-aid", new Item("First-aid", "A bag of old socks", "As the socks are stuffed into the wound the patient screams in agony", Arrays.asList(7)));
        CONTENTS.put("e-phone", new Item("E-Phone", "A Nokia E90 Communicator", "As you call 65 50 88 88 you hear \"You are number (*Error overflow*) in the queue...\"", Arrays.asList(10)));
    }

    /**
     *
     * @param input the name of the item to be retrieved
     * @return the item with said name or null
     */
    public static Item getItem(String input) {
        return CONTENTS.get(input.toLowerCase());
    }

    /**
     * Returns the contents of the safetypoint in a multiline string.
     *
     * @return the contents of the safety point
     */
    public static String getContents() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Item> e : CONTENTS.entrySet()) {
            sb.append("- ").append(e.getValue().getItemName()).append(" : ").append(e.getValue().getItemDescription()).append("\n");
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        return sb.toString();
    }

    /**
     *
     * @param itemName to be searched for
     * @return true if the safetypoint contains the item
     */
    public static boolean hasItem(String itemName) {
        return CONTENTS.containsKey(itemName.toLowerCase());
    }
}
