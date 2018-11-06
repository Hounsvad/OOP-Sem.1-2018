/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.items;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pinnacle F
 */
public class SafetyPoint {

    private static final Map<String, Item> CONTENTS = new HashMap<>();

    static {
        CONTENTS.put("map", new Item("Map", "An e-Map", "Your eyesight seems bad"));
        CONTENTS.put("fire-extinguisher", new Item("Fire-extinguisher", "A CO2 filled vessel with a release handle", "*SPWOOOOOOSH!* Goes the fire-extinguisher"));
        CONTENTS.put("eyewash", new Item("Eyewash", "A saline solution in a handy container", "*SPLASH* Goes the eyewash"));
        CONTENTS.put("defibrilator", new Item("Defibrilator", "A medicaly approved arc-reactor-powered tazer in red and gold colour scheme", "*BZZZZZT* Goes the fancy tazer"));
        CONTENTS.put("first-aid", new Item("First-aid", "A bag of old socks", "As the socks are stuffed into the wound the patient screams in agony"));
        CONTENTS.put("e-phone", new Item("E-Phone", "A Nokia E90 Communicator", "As you call 65 50 88 88 you hear \"You are number (*Error overflow*) in the cue\""));
    }

    /**
     *
     * @param input the name of the item to be retrieved
     * @return the item with said name or null
     */
    public static Item getItem(String input) {
        return CONTENTS.get(input.toLowerCase());
    }
}
