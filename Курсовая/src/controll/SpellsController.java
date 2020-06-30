package controll;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import assistant.NewScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import tables.TableSpells;

public class SpellsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button viewSpells;

    @FXML
    private TableView<TableSpells> tableSpells;

    @FXML
    private TableColumn<TableSpells, String> tableSpalls_colClass;

    @FXML
    private TableColumn<TableSpells, String> tableSpalls_colSpalls;

    @FXML
    private TableColumn<TableSpells, String> tableSpalls_colLevel;

    @FXML
    void butViewSpells(ActionEvent event) throws IOException {
        NewScene n = new NewScene();
        n.newScene(event, "/fxml/characters.fxml");
    }

    ObservableList<TableSpells> oblist = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        try{
            ResultSet r = Main.con.createStatement().executeQuery("select maxSlellLevel from magicAbility " +
                    "where class = '" + Main.classCharacter + "' and level = '" + Main.levelCharacter + "'");
            String maxSlellLevel = r.getString(1);
            ResultSet rs = Main.con.createStatement().executeQuery("select * from spells " +
                    "where class = '" + Main.classCharacter + "' and spellLevel <= " + maxSlellLevel + " order by spellLevel asc");

            while (rs.next()){
                oblist.add(new TableSpells(rs.getString("class"), rs.getString("spellLevel"),
                        rs.getString("name")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();}

        tableSpalls_colClass.setCellValueFactory(new PropertyValueFactory<>("classCh"));
        tableSpalls_colSpalls.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableSpalls_colLevel.setCellValueFactory(new PropertyValueFactory<>("spellLevel"));


        tableSpells.setItems(oblist);
    }
}
