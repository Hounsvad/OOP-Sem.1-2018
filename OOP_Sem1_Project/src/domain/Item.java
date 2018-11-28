/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Patrick
 */
public class Item extends DisplayableUnit {
    
    /**
     * Creates a new Item
     * @param name The name of the item
     * @param position Its position on screen
     * @param image The path to its image
     * @param description The items description
     */
    public Item(String name, int[] position, String image, String description) {
        super(name, position, image, description);
    }
}
