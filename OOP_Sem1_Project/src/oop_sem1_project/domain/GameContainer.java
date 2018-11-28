/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import oop_sem1_project.domain.popups.Popup;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class GameContainer {

    private Popup popup;
    private Player player;

    public GameContainer() {
    }

    public void inititalize(String playerName) {
        this.player = new Player(playerName, new int[]{100, 100}, "Player", "I am a Player");

    }

    public Popup getPopup() {
        return this.popup;
    }

    public void setPopup(Popup popup) {
        this.popup = popup;
    }

}
