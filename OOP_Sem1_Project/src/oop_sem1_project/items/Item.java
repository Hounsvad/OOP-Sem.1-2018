/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.items;

/**
 * Item is an item to be used in the game
 * 
 */
public class Item {
    
    /**
     * The name of the item
     * <p>Should only be one line
     */
    private final String itemName;
    
    /**
     * A description of the item
     * <p>Can be multiple lines 
     */
    private final String itemDescription;
    
    /**
     * The message displayed on usage
     */
    private final String usageMessage;
    
    /**
     * Creates an item
     *
     * @param itemName is the name of the item as a string
     * @param itemDescription is the description of the item
     * @throws IllegalArgumentException if the itemName is ""
     * @throws NullPointerException if the the itemName is null
     */ 
    public Item(String itemName, String itemDescription, String usageMessage) {
        if (itemName == null) {
            throw new NullPointerException("The input for itemName must be somthing other than null");
        } else if (itemName.isEmpty()) {
            throw new IllegalArgumentException("The input for itemName must be somthing other than \"\"");
        }
        this.itemName = itemName;
        
        if (itemDescription == null) {
            throw new NullPointerException("The input for itemDescription must be somthing other than null");
        } else if (itemDescription.isEmpty()) {
            throw new IllegalArgumentException("The input for itemDescription must be somthing other than \"\"");
        }
        this.itemDescription = itemDescription;
        
        if (usageMessage == null) {
            throw new NullPointerException("The input for usageMessage must be somthing other than null");
        } else if (usageMessage.isEmpty()) {
            throw new IllegalArgumentException("The input for usageMessage must be somthing other than \"\"");
        }
        this.usageMessage = usageMessage;
    }

    /**
     * @return the item name
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * @return the item description
     */
    public String getItemDescription() {
        return this.itemDescription;
    }
    
    /**
     * Return the items usageMessage
     * 
     * @return usageMessage A message displayed when the item is used
     */
    public String usageMessage(){
        return usageMessage;
    }
    
    /**
     * Checks if the itemName is equal
     * @param input
     * @return true upon equality
     */
    @Override
    public boolean equals(Object input){
        return input instanceof Item && ((Item) input).itemName.equalsIgnoreCase(this.itemName);
    }
}
