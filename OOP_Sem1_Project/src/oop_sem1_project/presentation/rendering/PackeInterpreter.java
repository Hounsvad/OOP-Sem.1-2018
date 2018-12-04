/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.presentation.rendering;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
class PackeInterpreter {

    /**
     * The dataList to be read.
     */
    private final List<String[]> dataList;

    /**
     * The background to be drawn.
     */
    private String background;

    /**
     * The X and Y coordinate of the player.
     */
    private int playerX, playerY;

    /**
     * The direction the player is facing.
     */
    private int playerRotation;

    /**
     * The current item the player has.
     */
    private String currentItem;

    /**
     * The current displayed phone number.
     */
    private String phoneNumber;

    /**
     * The message to be appended to the text flow.
     */
    private String message;

    /**
     * The current Popup to be displayed.
     */
    private String popupImage;

    /**
     * Constructs a new RenderingDataReader.
     *
     * @param dataList The data list to be converted to something
     * understandable.
     */
    public PackeInterpreter(List<String[]> dataList) {
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
                    this.playerRotation = !Arrays.asList("W", "Up").contains(data[1]) ? !Arrays.asList("S", "Down").contains(data[1]) ? !Arrays.asList("A", "Left").contains(data[1]) ? 90 : -90 : 180 : 0;
                    this.playerX = Integer.parseInt(data[2]);
                    this.playerY = Integer.parseInt(data[3]);
                    break;
                case "ci":
                    this.currentItem = data[1];
                    break;
                case "pn":
                    this.phoneNumber = data[1];
                    break;
                case "tf":
                    this.message = data[1];
                    break;
                case "pu":
                    this.popupImage = data[1];
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
     * @return The rotation of the player based on the direction. (Left, Right,
     * Up, or Down)
     */
    public int getPlayerRotation() {
        return this.playerRotation;
    }

    /**
     * @return The current item the Player has.
     */
    public String getCurrentItem() {
        return this.currentItem;
    }

    /**
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return The message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return The current Popup.
     */
    public String getPopupImage() {
        return popupImage;
    }
}
