/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Patrick
 */
public class SafetyPoint extends InteractableObject implements Popupable {
    
    private final Map<Integer,Item> items = new HashMap();
    
    public SafetyPoint(){
        
    }
    
    public Map getItems() {
        return this.items;
    }
}
