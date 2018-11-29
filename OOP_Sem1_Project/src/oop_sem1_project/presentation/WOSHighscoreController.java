/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.presentation;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Benjamin Staugaard | Benz56
 */
public class WOSHighscoreController implements Initializable {

    @FXML
    private ListView<String> scoreListView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void closeButtonClicked(ActionEvent event) {
        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
    }

    public void setScoreList(List<String> highscoreClicked) {
        System.out.println(highscoreClicked);
        this.scoreListView.getItems().addAll(highscoreClicked);
        this.scoreListView.refresh();
    }
}
