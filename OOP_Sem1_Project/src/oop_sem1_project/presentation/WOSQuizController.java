/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.presentation;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Benjamin Staugaard | Benz56
 */
public class WOSQuizController implements Initializable {

    private final int[] correctAnswersIndex = {1, 3, 2, 3, 0};
    private final List<ToggleGroup> toggleGroups = new ArrayList<>();

    @FXML
    private ToggleGroup question1, question2, question3, question4, question5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.toggleGroups.addAll(Arrays.asList(this.question1, this.question2, this.question3, this.question4, this.question5));
    }

    @FXML
    private void onSubmit() {
        int correctAnswers = 0;
        for (int i = 0; i < 5; i++) {
            ToggleGroup toggleGroup = this.toggleGroups.get(i);
            if (toggleGroup.getSelectedToggle() == null) {
                return;
            }
            correctAnswers += toggleGroup.getToggles().indexOf(toggleGroup.getSelectedToggle()) == this.correctAnswersIndex[i] ? 1 : 0;
        }

        System.out.println(correctAnswers);
    }
}
