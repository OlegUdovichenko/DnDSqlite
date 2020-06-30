package sample;

import assistant.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    public static String nameCharacter;
    public static String classCharacter;
    public static String raceCharacter;
    public static String speciesCharacter;
    public static String levelCharacter;
    public static String spellsKnowCharacter;
    public static String cantripsKnowCharacter;

    public static DBConnection dbHandler = new DBConnection();
    public static Connection con = dbHandler.getConnection();


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("D&D");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
