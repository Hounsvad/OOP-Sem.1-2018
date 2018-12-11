/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.domain;

import java.util.Comparator;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class ScoreSorter implements Comparator<String> {

    /**
     * Takes two score strings with the format '[Score] [playerName]'
     * and compares the scores
     * @param o1 Score string 1
     * @param o2 Score string 2
     * @return the comparison between the two
     */
    @Override
    public int compare(String o1, String o2) {
        return Integer.parseInt(o2.split(" ")[0]) - Integer.parseInt(o1.split(" ")[0]);
    }
}
