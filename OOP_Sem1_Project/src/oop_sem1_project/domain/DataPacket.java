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
public class DataPacket {

    private final Player player;
    private final StringBuilder phoneNumber = new StringBuilder();

    private List<String[]> packet = new ArrayList<>();
    private String background;
    private String playerDirection = "Up";
    private String textField = "";
    private Popup popup;

    public DataPacket(String background, Player player) {
        this.background = background;
        this.player = player;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setPlayerDirection(String keyPressed) {
        this.playerDirection = keyPressed;
    }

    public StringBuilder getPhoneNumber() {
        return phoneNumber;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public void setPopup(Popup popup) {
        this.popup = popup;
    }

    public List<String[]> constructPacket() {
        this.packet = new ArrayList<>();
        this.packet.add(new String[]{"bg", this.background});
        this.packet.add(new String[]{"pl", this.playerDirection, String.valueOf(this.player.getPosition()[0]), String.valueOf(this.player.getPosition()[1])});
        this.packet.add(new String[]{"ci", this.player.getItem() == null ? "" : this.player.getItem().getImage()});
        this.packet.add(new String[]{"pn", this.phoneNumber.toString()});
        this.packet.add(new String[]{"tf", this.textField});
        this.packet.add(new String[]{"pu", this.popup == null ? "" : this.popup.getImage()});
        return this.packet;
    }
}
