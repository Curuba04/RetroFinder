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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginFensterController implements Initializable {

	@FXML
	private TextField lfEmail;

	@FXML
	private Button lfLogin;

	@FXML
	private PasswordField lfPassword;

	public static boolean loginStatus = false;
	public static String nutzername;

	@FXML
	void lfLoginActionEvent(ActionEvent event) {
		if (lfEmail.getText() != null && lfPassword.getText() != null && loginStatus == false) {
			loginStatus = true;
			nutzername = lfEmail.getText();

			Node source = (Node) event.getSource();
			Stage oldstage = (Stage) source.getScene().getWindow();
			oldstage.close();

			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
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
