/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Oliver
 */
public abstract class DisplayableUnit {

    private final String name;
    private final String image;
    private final String description;
    private int[] position;

    /**
     *
     * @param name Name of unit
     * @param position Position in an int-array
     * @param image Location of sprite-image in String-format
     * @param description Description of unit
     */
    public DisplayableUnit(String name, int[] position, String image, String description) {
        this.name = name;
        this.position = position;
        this.image = image;
        this.description = description;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the position
     */
    public int[] getPosition() {
        return this.position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int[] position) {
        this.position = position;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return this.image;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }
}
