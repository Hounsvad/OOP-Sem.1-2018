/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

/**
 *
 * @author Oliver
 */
public abstract class DisplayableUnit
{

    private String name;
    private int[] position;
    private String image;
    private String description;
    
    /**
     * 
     * @param name Name of unit
     * @param position Position in an int-array
     * @param image Location of sprite-image in String-format
     * @param description Description of unit
     */
    public DisplayableUnit(String name, int[] position, String image, String description)
    {
        this.name = name;
        this.position = position;
        this.image = image;
        this.description = description;
    }
    
    
    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the position
     */
    public int[] getPosition()
    {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int[] position)
    {
        this.position = position;
    }

    /**
     * @return the image
     */
    public String getImage()
    {
        return image;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }
    
}
