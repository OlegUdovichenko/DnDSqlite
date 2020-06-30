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
import tables.TableCantrips;


public class CantripsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button viewCantrips;

    @FXML
    private TableView<TableCantrips> tableCantrips;

    @FXML
    private TableColumn<TableCantrips, String> tableCantrips_colClass;

    @FXML
    private TableColumn<TableCantrips, String> tableCantrips_colCantrips;

    @FXML
    void butViewCantrips(ActionEvent event) throws IOException {
        NewScene n = new NewScene();
        n.newScene(event, "/fxml/spells.fxml");
    }

    ObservableList<TableCantrips> oblist = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        try{
            ResultSet rs = Main.con.createStatement().executeQuery("select * from cantrips " +
                    "where class = '" + Main.classCharacter + "'");

            while (rs.next()){
                oblist.add(new TableCantrips(rs.getString("class"), rs.getString("name")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();}

        tableCantrips_colClass.setCellValueFactory(new PropertyValueFactory<>("classCh"));
        tableCantrips_colCantrips.setCellValueFactory(new PropertyValueFactory<>("name"));

        tableCantrips.setItems(oblist);
    }
}
