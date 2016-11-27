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
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.Interfaces.impl.CollectionAdressBook;
import sample.objects.Person;
import sample.start.*;
import sample.Interfaces.impl.CollectionAdressBook;

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
    private Stage mainStage;

    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private EditController editController;
    private Stage editStage;

    public void setMainStage(Stage mainStage){
        this.mainStage = mainStage;
    }


   @FXML
   private void initialize() {

       //tableAdressBook.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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

       try {

           fxmlLoader.setLocation(getClass().getResource("../fxml/edit.fxml"));
           fxmlEdit = fxmlLoader.load();
           editController = fxmlLoader.getController();


       } catch (IOException e) {
           e.printStackTrace();
       }

    }

    private void updateCountLabel() {

        labelCount.setText("Количество записей: " + adressBookImpl.getPersonList().size());
    }



    @FXML
    public void actionButtonPressed(ActionEvent actionEvent){

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) return;

        Button clickedButton = (Button) source;

        Person selectedPerson = (Person) tableAdressBook.getSelectionModel().getSelectedItem();

        Window parentWindow = ((Node)actionEvent.getSource()).getScene().getWindow();

        editController.setPerson(selectedPerson);


        switch (clickedButton.getId()) {
            case "btnAdd":
                editController.setPerson(new Person());
                showDialog();
                adressBookImpl.add(editController.getPerson());


                break;

            case "btnEdit":
                showDialog();
                break;

            case "btnDelete":
                adressBookImpl.delete((Person) tableAdressBook.getSelectionModel().getSelectedItem());
                break;
        }


    }

            private void showDialog() {
                if (editStage == null) {
                    editStage = new Stage();
                    editStage.setTitle("Редактирование записи");
                    editStage.setScene(new Scene(fxmlEdit));
                    editStage.initModality(Modality.WINDOW_MODAL);
                    editStage.initOwner(mainStage);
                    editStage.show();
                }
                //editStage.showAndWait();
                editStage.show();
            }

    }


