/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.List;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public interface InteractionHandler {

    List<String[]> start(String playerName);

    List<String> getStoredHighscores();

    List<String[]> update(String keyPressed);

    List<String[]> update(String clickedNode, int[] position);
}
