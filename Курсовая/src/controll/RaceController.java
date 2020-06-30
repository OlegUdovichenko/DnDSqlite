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
import tables.TableRace;

public class RaceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterRace;

    @FXML
    private TextField raceCharacter;

    @FXML
    private Button backToClass;

    @FXML
    private TableView<TableRace> tableBestRace;

    @FXML
    private TableColumn<TableRace, String> tableBestRace_colRace;

    @FXML
    private TableColumn<TableRace, String> tableBestRace_colStats;

    @FXML
    private TableColumn<TableRace, String> tableBestRace_colLive;

    @FXML
    private TableColumn<TableRace, String> tableBestRace_colSize;

    @FXML
    private TableColumn<TableRace, String> tableBestRace_colSpeed;

    @FXML
    private TableColumn<TableRace, String> tableBestRace_colDarkvision;

    @FXML
    private TableColumn<TableRace, String> tableBestRace_colLanguage;

    @FXML
    private TableColumn<TableRace, String> tableBestRace_colFits;

    @FXML
    private TableView<TableRace> tableRace;

    @FXML
    private TableColumn<TableRace, String> tableRace_colRace;

    @FXML
    private TableColumn<TableRace, String> tableRace_colStats;

    @FXML
    private TableColumn<TableRace, String> tableRace_colLive;

    @FXML
    private TableColumn<TableRace, String> tableRace_colSize;

    @FXML
    private TableColumn<TableRace, String> tableRace_colSpeed;

    @FXML
    private TableColumn<TableRace, String> tableRace_colDarkvision;

    @FXML
    private TableColumn<TableRace, String> tableRace_colLanguage;

    @FXML
    private TableColumn<TableRace, String> tableRace_colFits;

    @FXML
    void butBackToClass(ActionEvent event)throws IOException {
        NewScene n = new NewScene();
        n.newScene(event, "/fxml/class.fxml");
    }

    @FXML
    void butEnterRace(ActionEvent event) throws IOException {
        String rC = raceCharacter.getText();

        try{
            if(Main.con.createStatement().executeQuery("select name from race where name = '" + rC + "'").next()){
                Main.raceCharacter = rC;
                NewScene n = new NewScene();

                if (Main.con.createStatement().executeQuery("select race from species where race = '" + Main.raceCharacter + "'").next()) {
                    n.newScene(event, "/fxml/species.fxml");
                }
                else{
                    n.newScene(event, "/fxml/level.fxml");
                }
            }
            else{
                Shake errorAnim = new Shake(raceCharacter);
                errorAnim.playAnin();
            }
        }
        catch (SQLException e){
            e.printStackTrace();}
    }


    ObservableList<TableRace> oblist = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        try{
            ResultSet r = Main.con.createStatement().executeQuery("select bestRace from class where name = '" + Main.classCharacter + "'");
            ResultSet rs = Main.con.createStatement().executeQuery("select * from race where name = '"+ r.getString(1) + "'");

            while (rs.next()){
                oblist.add(new TableRace(rs.getString("name"), rs.getString("stats"),
                        rs.getString("lifespan"), rs.getString("size"), rs.getString("speed"),
                        rs.getString("darkvision"), rs.getString("language"), rs.getString("fits")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();}

        tableBestRace_colRace.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableBestRace_colStats.setCellValueFactory(new PropertyValueFactory<>("stats"));
        tableBestRace_colLive.setCellValueFactory(new PropertyValueFactory<>("lifespan"));
        tableBestRace_colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        tableBestRace_colSpeed.setCellValueFactory(new PropertyValueFactory<>("speed"));
        tableBestRace_colDarkvision.setCellValueFactory(new PropertyValueFactory<>("darkvision"));
        tableBestRace_colLanguage.setCellValueFactory(new PropertyValueFactory<>("language"));
        tableBestRace_colFits.setCellValueFactory(new PropertyValueFactory<>("fits"));

        tableBestRace.setItems(oblist);




        try{
            ResultSet rs = Main.con.createStatement().executeQuery("select * from race");

            while (rs.next()){
                oblist.add(new TableRace(rs.getString("name"), rs.getString("stats"),
                        rs.getString("lifespan"), rs.getString("size"), rs.getString("speed"),
                        rs.getString("darkvision"), rs.getString("language"), rs.getString("fits")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();}

        tableRace_colRace.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableRace_colStats.setCellValueFactory(new PropertyValueFactory<>("stats"));
        tableRace_colLive.setCellValueFactory(new PropertyValueFactory<>("lifespan"));
        tableRace_colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        tableRace_colSpeed.setCellValueFactory(new PropertyValueFactory<>("speed"));
        tableRace_colDarkvision.setCellValueFactory(new PropertyValueFactory<>("darkvision"));
        tableRace_colLanguage.setCellValueFactory(new PropertyValueFactory<>("language"));
        tableRace_colFits.setCellValueFactory(new PropertyValueFactory<>("fits"));

        tableRace.setItems(oblist);

    }
}
