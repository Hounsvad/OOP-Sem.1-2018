/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.rendering;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
class GameObject {

    /**
     * The name of the GameObject's image.
     */
    private final String image;

    /**
     * The x coordinate of the GameObject.
     */
    private final int x;

    /**
     * The y coordinate of the GameObject.
     */
    private final int y;

    /**
     * Construct a new GameObject.
     *
     * @param image The image.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public GameObject(String image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    /**
     * @return The image name.
     */
    public String getImage() {
        return this.image;
    }

    /**
     * @return The x coordinate.
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return The y coordinate.
     */
    public int getY() {
        return this.y;
    }
}
