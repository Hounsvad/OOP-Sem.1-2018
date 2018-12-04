/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.presentation.rendering;

import java.util.List;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import oop_sem1_project.presentation.WOSController;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class Renderer {

    /**
     * The ImageView of the player. ImageView is used to be able to rotate.
     */
    private final ImageView player = new ImageView(new Image(WOSController.class.getResourceAsStream("images/player.png")));

    /**
     * An instance of the WOSController to access the canvases.
     */
    private final WOSController controller;

    /**
     * Construct a new Renderer.
     *
     * @param controller The instance of the WOSController.
     */
    public Renderer(WOSController controller) {
        this.controller = controller;
    }

    /**
     * Re-draws everything on the canvas based on the received dataList.
     *
     * @param dataList The list that specifies where something should be drawn.
     */
    public void requestGraphicalUpdate(List<String[]> dataList) {
        // Main purpose of the PackeInterpreter is to convert the dataList to something more specific
        // than arbritray abbrevations and random array positions. Aids readability.
        PackeInterpreter dataReader = new PackeInterpreter(dataList);
        GraphicsContext gameCanvas = this.controller.getGameCanvas().getGraphicsContext2D();

        System.out.println(dataReader.getBackground());
        gameCanvas.drawImage(new Image(WOSController.class.getResourceAsStream("images/" + "MainHall" + ".png")), 0, 0);
        this.player.setRotate(dataReader.getPlayerRotation());
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        gameCanvas.drawImage(this.player.snapshot(snapshotParameters, null), dataReader.getPlayerX(), dataReader.getPlayerY());

        if (!dataReader.getCurrentItem().isEmpty()) {
            this.controller.getItemImageView().setImage(new Image(WOSController.class.getResourceAsStream("images/" + dataReader.getCurrentItem() + ".png")));
        }

        this.controller.getTextArea().appendText(dataReader.getMessage().isEmpty() ? "" : dataReader.getMessage());

        if (!dataReader.getPopupImage().isEmpty()) {
            gameCanvas.drawImage(new Image(WOSController.class.getResourceAsStream("images/" + dataReader.getPopupImage() + ".png")), 0, 0);
        }
        
        this.controller.setPhoneNumber(dataReader.getPhoneNumber());
        this.controller.getPhoneTextFlow().setVisible(!dataReader.getPhoneNumber().isEmpty());
    }
}
