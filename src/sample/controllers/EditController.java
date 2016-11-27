package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.objects.Person;


public class EditController {

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;


    @FXML
    private TextField txtFIO;

    @FXML
    private TextField txtPhone;

    private Person person;



    public void setPerson(Person person) {

        if(person == null) return;

        this.person = person;
        txtFIO.setText(person.getFio());
        txtPhone.setText(person.getPhone());
    }

    public Person getPerson() {

        return person;
    }



    @FXML
    public void actionClose(javafx.event.ActionEvent actionEvent) {

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }


    /**
     * @param actionEvent
    Догадался через два часа что нужно подключить javafx.event к ActionEvent - было awt какое-то)))*/
    @FXML
    public void actionSave(javafx.event.ActionEvent actionEvent) {

        person.setPhone(txtPhone.getText());
        person.setFio(txtFIO.getText());
        actionClose(actionEvent);
    }



}
