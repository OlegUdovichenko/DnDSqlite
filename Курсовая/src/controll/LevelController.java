package controll;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animation.Shake;
import assistant.NewScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;

public class LevelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterLevel;

    @FXML
    private TextField levelCharacter;

    @FXML
    private Button backToSpecies;

    @FXML
    void butBackToSpecies(ActionEvent event)throws IOException {
        try {
            NewScene n = new NewScene();
            if (Main.con.createStatement().executeQuery("select race from species where race = '" + Main.raceCharacter + "'").next()) {
                n.newScene(event, "/fxml/species.fxml");
            }
            else {
                n.newScene(event, "/fxml/race.fxml");
            }
        }
        catch (SQLException e){
            e.printStackTrace();}
    }

    @FXML
    void butEnterLevel(ActionEvent event)throws IOException {

        try{
            Integer level = Integer.parseInt(levelCharacter.getText());
            if(level >= 1 && level <= 20){
                Main.levelCharacter = level.toString();

                ResultSet rsCantrips = Main.con.createStatement().executeQuery("select cantripsKnow from magicAbility " +
                        "where class = '" + Main.classCharacter + "' and level = '" + Main.levelCharacter + "'");
                ResultSet rs = Main.con.createStatement().executeQuery("select spellsKnow from magicAbility " +
                        "where class = '" + Main.classCharacter + "' and level = '" + Main.levelCharacter + "'");

                Main.cantripsKnowCharacter = rsCantrips.getString(1);
                Main.spellsKnowCharacter = rs.getString(1);


                String insert = "insert into characters values('" + Main.nameCharacter + "','" + Main.classCharacter +
                        "','" + Main.raceCharacter + "','" + Main.speciesCharacter + "','" + Main.levelCharacter +
                        "','" + Main.spellsKnowCharacter + "','" + Main.cantripsKnowCharacter + "');";
                try {
                    PreparedStatement prSt = Main.con.prepareStatement(insert);
                    prSt.executeUpdate();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }

                NewScene n = new NewScene();

                if(rsCantrips.next() && rsCantrips.getString(1).chars().allMatch(Character::isDigit)) {
                    n.newScene(event, "/fxml/cantrips.fxml");
                }
                else if(rs.next()){
                    n.newScene(event, "/fxml/spells.fxml");
                }
                else{
                    n.newScene(event, "/fxml/characters.fxml");
                }
            }
            else{
                Shake errorAnim = new Shake(levelCharacter);
                errorAnim.playAnin();
            }
        }
        catch(Exception e){
        }

    }

    @FXML
    void initialize() {
    }
}
