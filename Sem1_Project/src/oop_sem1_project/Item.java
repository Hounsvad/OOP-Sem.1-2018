/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project;

/**
 *
 * @author Hounsvad
 */
public class Item {
    /**
     * The name of the item
     * <p>Should only be one line
     */
    private String itemName;
    /**
     * A description of the item
     * <p>Can be multiple lines 
     */
    private String itemDescription;
    
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
    
}
