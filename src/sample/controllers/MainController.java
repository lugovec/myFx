package sample.controllers;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Interfaces.impl.CollectionAdressBook;
import sample.objects.Person;
import sample.start.*;

import java.io.IOException;

public class MainController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView tableAdressBook;

    @FXML
    private Label labelCount;

    @FXML
    private TableColumn<Person, String> columnFio;

    @FXML
    private TableColumn<Person, String>columnPhone;

    CollectionAdressBook adressBookImpl = new CollectionAdressBook();


   @FXML
    private void initialize() {

        //Связываю поля в таблице с полями класса Person
        columnFio.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        //Автоматическая проверка изменений в таблице
        adressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLabel();
            }
        });

        adressBookImpl.fillTestData();
        tableAdressBook.setItems(adressBookImpl.getPersonList());


    }

    private void updateCountLabel() {

        labelCount.setText("Количество записей: " + adressBookImpl.getPersonList().size());
    }

    @FXML
    public void showDialog(ActionEvent actionEvent){

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) return;

        Button clickedButton = (Button) source;

        Person selectedPerson = (Person) tableAdressBook.getSelectionModel().getSelectedItem();

        switch (clickedButton.getId()) {
            case "btnAdd":
                System.out.println("add " + selectedPerson);
                break;
            case "btnEdit":
                System.out.println("edit " + selectedPerson);
                break;
            case "btnDelete":
                System.out.println("delete " + selectedPerson);
                break;
        }

        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/edit.fxml"));
            stage.setTitle("Редактирование записи");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();



        } catch (IOException e) {
            e.printStackTrace();}

        }
    }

/*try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/edit.fxml"));
            stage.setTitle("Редактирование записи");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();



        } catch (IOException e) {
            e.printStackTrace();}*/


