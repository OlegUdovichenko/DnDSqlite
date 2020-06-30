package controll;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import animation.Shake;
import assistant.NewScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterName;

    @FXML
    private TextField nameCharacters;

    @FXML
    private Button characters;

    @FXML
    void butCharacters(ActionEvent event) throws IOException {
        NewScene n = new NewScene();
        n.newScene(event, "/fxml/characters.fxml");
    }

    @FXML
    void butEnterName(ActionEvent event) throws IOException {
        if(nameCharacters.getText().equals("")){
            Shake errorAnim = new Shake(nameCharacters);
            errorAnim.playAnin();
        }
        else{
            Main.nameCharacter = nameCharacters.getText();
            NewScene n = new NewScene();
            n.newScene(event, "/fxml/class.fxml");
        }
    }

    @FXML
    void initialize() {

    }

}
