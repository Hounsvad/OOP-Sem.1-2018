/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class DataPacket {

    private final List<String[]> packet = new ArrayList<>();
    private final Player player;

    private String background;
    private List<DisplayableUnit> displayableUnits;

    public DataPacket(String background, Player player) {
        this.background = background;
        this.player = player;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void resetDisplayableUnits() {
        this.displayableUnits = new ArrayList<>();
    }
    
    public void setDisplayableUnits(Collection<InteractableObject> values) {
        this.displayableUnits = new ArrayList<>(values);
    }

    public List<String[]> constructPacket() {
        this.packet.add(new String[]{"bg", this.background});
        this.packet.add(new String[]{"pl", String.valueOf(this.player.getPosition()[0]), String.valueOf(this.player.getPosition()[1])});
        this.packet.add(new String[]{"ci", this.player.getItem().getImage()});
        for (DisplayableUnit displayableUnit : this.displayableUnits) {
            this.packet.add(new String[]{"go", displayableUnit.getImage(), String.valueOf(displayableUnit.getPosition()[0]), String.valueOf(displayableUnit.getPosition()[1])});
        }
        return this.packet;
    }
}
