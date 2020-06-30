package controll;

import java.io.IOException;
import java.net.URL;
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
import tables.TableSpecies;

public class SpeciesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterSpecies;

    @FXML
    private TextField speciesCharacter;

    @FXML
    private Button backToRace;

    @FXML
    private TableView<TableSpecies> tableSpecies;

    @FXML
    private TableColumn<TableSpecies, String> tableSpecies_colSpecies;

    @FXML
    private TableColumn<TableSpecies, String> tableSpecies_colStats;

    @FXML
    private TableColumn<TableSpecies, String> tableSpecies_colFifs;

    @FXML
    void butBackToRace(ActionEvent event) throws IOException {
        NewScene n = new NewScene();
        n.newScene(event, "/fxml/race.fxml");
    }

    @FXML
    void butEnterSpecies(ActionEvent event) throws IOException {
        String sC = speciesCharacter.getText();
        try{
            if(Main.con.createStatement().executeQuery("select name from species where name = '" + sC + "'").next()){
                Main.speciesCharacter = sC;
                NewScene n = new NewScene();
                n.newScene(event, "/fxml/level.fxml");
            }
            else{
                Shake errorAnim = new Shake(speciesCharacter);
                errorAnim.playAnin();
            }
        }
        catch (SQLException e){
            e.printStackTrace();}
    }

    ObservableList<TableSpecies> oblist = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        try{
            ResultSet rs = Main.con.createStatement().executeQuery("select name, stats, fits from species " +
                    "where race = '" + Main.raceCharacter + "'");

            while (rs.next()){
                oblist.add(new TableSpecies(rs.getString("name"), rs.getString("stats"),
                        rs.getString("fits")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();}

        tableSpecies_colSpecies.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableSpecies_colStats.setCellValueFactory(new PropertyValueFactory<>("stats"));
        tableSpecies_colFifs.setCellValueFactory(new PropertyValueFactory<>("fits"));


        tableSpecies.setItems(oblist);

    }
}
