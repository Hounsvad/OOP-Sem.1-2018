/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Benjamin Staugaard | Benz56
 */
public class WOSController implements Initializable {

    @FXML
    private Canvas gameCanvas;
    @FXML
    private Canvas phoneCanvas;
    @FXML
    private Canvas itemCanvas;
    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
