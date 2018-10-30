/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project;

import java.util.Objects;

/**
 *
 * @author Hounsvad
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
    
    public Item(String itemName, String itemDescription){
        if(itemName != null){
            this.itemName = itemName;
        }else if(itemName.equals("")){
            throw new IllegalArgumentException("The input for itemName must be somthing other than \"\"");
        }else{
            throw new NullPointerException("The input for itemName must be somthing other than null");
        }
        
        if(itemDescription != null){
            this.itemDescription = itemDescription;
        }else if(itemDescription.equals("")){
            throw new IllegalArgumentException("The input for itemDescription must be somthing other than \"\"");
        }else{
            throw new NullPointerException("The input for itemName must be somthing other than null");
        }
    }

    /**
     * 
     * @return 
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 
     * @return 
     */
    public String getItemDescription() {
        return itemDescription;
    }
    
    @Override
    public boolean equals(Object input){
        if(input instanceof Item){
            return ((Item) input).itemName.equalsIgnoreCase(this.itemName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.itemName);
        hash = 79 * hash + Objects.hashCode(this.itemDescription);
        return hash;
    }
}
