package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;

public class EditController {

    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancel;


    public void actionClouse(ActionEvent actionEvent) {

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
