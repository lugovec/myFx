package sample.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Interfaces.impl.CollectionAdressBook;
import sample.objects.Person;

import static javafx.application.Application.launch;

/**
 * Created by andrey on 16.11.16.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();

        testData();
    }

    private void testData() {
        CollectionAdressBook adressBook = new CollectionAdressBook();

        Person person1 = new Person();
        person1.setFio("test_fio1");
        person1.setPhone("test_phone1");

        Person person2 = new Person();
        person2.setFio("test_fio2");
        person2.setPhone("test_phone2");

        adressBook.add(person1);
        adressBook.add(person2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
