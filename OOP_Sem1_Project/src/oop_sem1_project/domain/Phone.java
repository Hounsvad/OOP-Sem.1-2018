/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Oliver
 */
public class Phone implements Popupable
{

    //A domain based variable that contains which screen the phone is at.
    //0: HomeScreen
    //1: Map
    //2: Dialpad
    private int currentScreen = 0;
    private List<int[]> clickableAreas = new ArrayList<>(Arrays.asList(new int[][]{
        //{posX, posY, width, height},
        {0, 0, 20, 20},
        {25, 0, 20, 20},
    }));
    private boolean hasMap = false;
    
    

    @Override
    public boolean isClickable(int[] position)
    {
        for (int[] clickableArea : this.clickableAreas)
        {
            //if the clicks position from the argument is within a clickable area form the clickable areas list
            if (clickableArea[0] + clickableArea[2] > position[0] && position[0] < clickableArea[0] && clickableArea[1] + clickableArea[3] > position[1] && position[1] < clickableArea[1])
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * @return the hasMap
     */
    public boolean hasMap()
    {
        return this.hasMap;
    }

    /**
     * @param hasMap the hasMap to set
     */
    public void setHasMap(boolean hasMap)
    {
        this.hasMap = hasMap;
    }
}
