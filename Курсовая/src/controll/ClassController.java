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
import tables.TableClass;

public class ClassController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterClass;

    @FXML
    private TextField classCharacter;

    @FXML
    private Button backToName;

    @FXML
    private TableView<TableClass> tableClass;

    @FXML
    private TableColumn<TableClass, String> tableClass_colClass;

    @FXML
    private TableColumn<TableClass, String> tableClass_colHits;

    @FXML
    private TableColumn<TableClass, String> tableClass_colProfessional;

    @FXML
    private TableColumn<TableClass, String> tableClass_colSaves;

    @FXML
    void butBackToName(ActionEvent event) throws IOException {
        NewScene n = new NewScene();
        n.newScene(event, "/fxml/sample.fxml");
    }

    @FXML
    void butEnterClass(ActionEvent event) throws IOException {

        String cC = classCharacter.getText();

        try{
            if(Main.con.createStatement().executeQuery("select name from class where name = '" + cC + "'").next()){
                Main.classCharacter = cC;

                NewScene n = new NewScene();
                n.newScene(event, "/fxml/race.fxml");
            }
            else{
                Shake errorAnim = new Shake(classCharacter);
                errorAnim.playAnin();
            }

        }
        catch (SQLException e){
            e.printStackTrace();}
    }


    ObservableList<TableClass> oblist = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        try{

            ResultSet rs = Main.con.createStatement().executeQuery("select name, diceHits, professional, saves from class");


            while (rs.next()){
                oblist.add(new TableClass(rs.getString("name"), rs.getString("diceHits"),
                        rs.getString("professional"), rs.getString("saves")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();}
        catch (Exception e) {
            e.printStackTrace();
        }

        tableClass_colClass.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableClass_colHits.setCellValueFactory(new PropertyValueFactory<>("diceHits"));
        tableClass_colProfessional.setCellValueFactory(new PropertyValueFactory<>("professional"));
        tableClass_colSaves.setCellValueFactory(new PropertyValueFactory<>("saves"));

        tableClass.setItems(oblist);

    }
}
