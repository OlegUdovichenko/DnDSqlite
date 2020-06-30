package controll;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animation.Shake;
import assistant.NewScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import tables.TableCharacter;

public class CharactersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button to_main;

    @FXML
    private TableView<TableCharacter> tableCharacters;

    @FXML
    private TableColumn<TableCharacter, String> tableCharacters_colName;

    @FXML
    private TableColumn<TableCharacter, String> tableCharacters_colClass;

    @FXML
    private TableColumn<TableCharacter, String> tableCharacters_colRace;

    @FXML
    private TableColumn<TableCharacter, String> tableCharacters_colSpecies;

    @FXML
    private TableColumn<TableCharacter, String> tableCharacters_colLevel;

    @FXML
    private TableColumn<TableCharacter, String> tableCharacters_colSpells;

    @FXML
    private TableColumn<TableCharacter, String> tableCharacters_colCantrips;

    @FXML
    private TextField old_name;

    @FXML
    private TextField new_name;

    @FXML
    private Button apply;

    @FXML
    private TextField delete_name;

    @FXML
    private Button delete;

    @FXML
    void butApply(ActionEvent event) throws IOException, SQLException {
        if(Main.con.createStatement().executeQuery("select name from characters where name = '" + old_name.getText()
                + "'").next() && !new_name.getText().equals("")) {

            String update = "update characters set name = '" + new_name.getText() + "' where name = '" + old_name.getText() + "'";
            try {
                PreparedStatement prSt = Main.con.prepareStatement(update);
                prSt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            NewScene n = new NewScene();
            n.newScene(event, "/fxml/characters.fxml");
        }
        else{
            Shake errorAnim = new Shake(old_name);
            Shake errorAnim_1 = new Shake(new_name);
            errorAnim.playAnin();
            errorAnim_1.playAnin();
        }
    }

    @FXML
    void butDelete(ActionEvent event) throws IOException, SQLException {
        if(Main.con.createStatement().executeQuery("select name from characters where name = '" + delete_name.getText()
                + "'").next()) {
            String delete = "delete from characters where name = '" + delete_name.getText() + "'";
            try {
                PreparedStatement prSt = Main.con.prepareStatement(delete);
                prSt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            NewScene n = new NewScene();
            n.newScene(event, "/fxml/characters.fxml");
        }
        else{
            Shake errorAnim = new Shake(delete_name);
            errorAnim.playAnin();
        }

    }



    @FXML
    void butTo_Main(ActionEvent event) throws IOException {
        NewScene n = new NewScene();
        n.newScene(event, "/fxml/sample.fxml");
    }

    ObservableList<TableCharacter> oblist = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        try{
            ResultSet rs = Main.con.createStatement().executeQuery("select * from characters ");

            while (rs.next()){
                oblist.add(new TableCharacter(rs.getString("name"), rs.getString("class"),
                        rs.getString("race"), rs.getString("species"), rs.getString("level"),
                        rs.getString("spellsKnow"), rs.getString("cantripsKnow")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();}

        tableCharacters_colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableCharacters_colClass.setCellValueFactory(new PropertyValueFactory<>("classCh"));
        tableCharacters_colRace.setCellValueFactory(new PropertyValueFactory<>("race"));
        tableCharacters_colSpecies.setCellValueFactory(new PropertyValueFactory<>("species"));
        tableCharacters_colLevel.setCellValueFactory(new PropertyValueFactory<>("level"));
        tableCharacters_colSpells.setCellValueFactory(new PropertyValueFactory<>("spellsKnow"));
        tableCharacters_colCantrips.setCellValueFactory(new PropertyValueFactory<>("cantripsKnow"));


        tableCharacters.setItems(oblist);
    }
}
