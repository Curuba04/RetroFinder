package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ProfilWindowController implements Initializable {
	
	@FXML
	private static Label profilLabel;

	@FXML
	public static Button profilButton = new Button();
	
	@FXML
    private Button pfPlus;

	public static void mainProfilDisplay() {
		profilButton.setText("Hallo " + LoginFensterController.nutzername );
	}
	
	@FXML
	void pfPlusActionEvent(ActionEvent event) {
		if (LoginFensterController.loginStatus == true) {
			Node source = (Node) event.getSource();
			Stage oldstage = (Stage) source.getScene().getWindow();
			oldstage.close();

			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ObjektReinstellenWindow.fxml"));
				Parent root;
				root = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("RetroFinder");
				stage.setScene(new Scene(root));
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			Node source = (Node) event.getSource();
			Stage oldstage = (Stage) source.getScene().getWindow();
			oldstage.close();

			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegistrierenLoginWindow.fxml"));
				Parent root;
				root = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("RetroFinder");
				stage.setScene(new Scene(root));
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

}
