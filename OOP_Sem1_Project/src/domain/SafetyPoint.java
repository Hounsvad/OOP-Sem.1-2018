/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Patrick
 */
public class SafetyPoint extends InteractableObject implements Popupable {

    private final Map<Integer, Item> items = new HashMap<>();

    public SafetyPoint(String name, int[] clickableArea, String image, String description) {
        super(name, clickableArea, image, description);
    }

    public Map<Integer, Item> getItems() {
        return this.items;
    }

    @Override
    public boolean isClickable(int[] position) {
        return isInArea(position[0], position[1]);
    }
}
