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

    private Popup popup;
    private Player player;

    public void inititalize(String playerName) {
        this.player = new Player(playerName, new int[]{100, 100}, "Player", "I am a Player");
        //Room room = new Room("Rally Point", new int[]{0,0}, "RallyPoint", , 0, true)
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
}
