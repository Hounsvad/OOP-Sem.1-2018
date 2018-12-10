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
 * The FXML Controller class for the quiz window.
 *
 * @author Benjamin Staugaard | Benz56
 */
public class WOSQuizController implements Initializable {

    /**
     * The indexes of the correct quiz answers. (0-indexed i.e. RadioButton 1 ==
     * index 0)
     */
    private final int[] correctAnswersIndex = {1, 3, 2, 3, 0};

    /**
     * A List containing all of the ToggleGroups for easy "loop-able" answer
     * checking.
     */
    private final List<ToggleGroup> toggleGroups = new ArrayList<>();

    /**
     * The 5 ToggleGroups.
     */
    @FXML
    private ToggleGroup question1, question2, question3, question4, question5;

    /**
     * Initializes the controller class and adds all of the ToggleGroups to the
     * list of ToggleGroups.
     *
     * @param location The location used to resolve relative paths for the root
     * object, or null if the location is not known.
     * @param resources The resources used to localize the root object, or null
     * if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.toggleGroups.addAll(Arrays.asList(this.question1, this.question2, this.question3, this.question4, this.question5));
    }

    /**
     * Fired when the submit button is clicked.
     */
    @FXML
    private void onSubmitEvent() {
        int correctAnswers = 0;
        for (int i = 0; i < 5; i++) {
            ToggleGroup toggleGroup = this.toggleGroups.get(i);
            // Add 1 to the correct answers if a RadioButton is selected and it is the correct one.
            correctAnswers += toggleGroup.getSelectedToggle() != null && toggleGroup.getToggles().indexOf(toggleGroup.getSelectedToggle()) == this.correctAnswersIndex[i] ? 1 : 0;
        }

        System.out.println(correctAnswers);
    }
}
