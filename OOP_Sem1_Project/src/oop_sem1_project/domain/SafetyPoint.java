/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.HashMap;
import java.util.Map;
import oop_sem1_project.domain.popups.Popup;

/**
 *
 * @author Patrick
 */
public class SafetyPoint extends Popup {

    private final Map<Integer, Item> items = new HashMap<>();

    public SafetyPoint(InteractionHandlerImpl interactionHandler, String name, String image) {
        super(interactionHandler, name, image);
    }

    public Map<Integer, Item> getItems() {
        return this.items;
    }

    @Override
    public void onClick(int[] clickedPosition) {
    }
}
