/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.presentation.rendering;

import java.util.List;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
class RenderingDataReader {

    /**
     * The dataList to be read.
     */
    private final List<String[]> dataList;

    /**
     * The background to be drawn.
     */
    private String background;

    /**
     * Whether or not the player should be drawn.
     */
    private boolean drawPlayer;

    /**
     * The X and Y coordinate of the player.
     */
    private int playerX, playerY;

    /**
     * The current item the player has.
     */
    private String currentItem;

    /**
     * A list of all objects that should be drawn.
     */
    private List<GameObject> gameObjects;

    /**
     * Constructs a new RenderingDataReader.
     *
     * @param dataList The data list to be converted to something
     * understandable.
     */
    public RenderingDataReader(List<String[]> dataList) {
        this.dataList = dataList;
        readData();
    }

    /**
     * Reads the data and assigns the correct values to the above attributes.
     */
    private void readData() {
        for (String[] data : this.dataList) {
            switch (data[0]) {
                case "bg":
                    this.background = data[1];
                    break;
                case "pl":
                    this.drawPlayer = true;
                    this.playerX = Integer.parseInt(data[1]);
                    this.playerY = Integer.parseInt(data[2]);
                    break;
                case "ci":
                    this.currentItem = data[1];
                    break;
                case "go":
                    this.gameObjects.add(new GameObject(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
            }
        }
    }

    /**
     * @return The background.
     */
    public String getBackground() {
        return this.background;
    }

    /**
     * @return Whether to draw the Player.
     */
    public boolean drawPlayer() {
        return this.drawPlayer;
    }

    /**
     * @return The X coordinate of the Player.
     */
    public int getPlayerX() {
        return this.playerX;
    }

    /**
     * @return The Y coordinate of the Player.
     */
    public int getPlayerY() {
        return this.playerY;
    }

    /**
     * @return The current item the Player has.
     */
    public String getCurrentItem() {
        return this.currentItem;
    }

    /**
     * @return The List of all GameObjects to be drawn.
     */
    public List<GameObject> getGameObjects() {
        return this.gameObjects;
    }
}
