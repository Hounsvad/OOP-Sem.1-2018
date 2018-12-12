/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.List;

/**
 *
 * Contract detailing methods needed for communication between the presentation and domain layer
 * 
 */
public interface InteractionHandler {

    /**
     * Method to initiate the game
     * @param playerName is the name the player entered
     * @return Initial data packet
     */
    List<String[]> start(String playerName);

    /**
     * Method to retrieve highscores from the data layer
     * @return List of highscores and player names
     */
    List<String> getStoredHighscores();

    /**
     * Method to update the game and retrieve new states based on a keypress
     * @param keyPressed as a string representing the key pressed
     * @return Updated data packet
     */
    List<String[]> update(String keyPressed);

    /**
     * Method to update the game and retrieve new states based on a mouse click
     * @param clickedNode The "canvas" clicked
     * @param position The coordinates of the point clicked
     * @return Updated data packet
     */
    List<String[]> update(String clickedNode, int[] position);

    /**
     * Calculates, saves and returns the score based on the number of correct answers 
     * @param correctQuizAnswers Number of correct answers
     * @return The score
     */
    public int storeHighscore(int correctQuizAnswers);
}
