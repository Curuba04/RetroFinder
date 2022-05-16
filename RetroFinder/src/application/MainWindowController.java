package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindowController implements Initializable {

	@FXML
	private GridPane hfGridObjekts = new GridPane();
	private List<Game> games;

	@FXML
	private static Button hfLogin;

	@FXML
	private Button hfPlus;

	@FXML
	private Button hfReg;

	@FXML
	private ScrollPane hfScrollItems;
	
	public static void mainProfilDisplay() {
		hfLogin.setText("Hallo " + LoginFensterController.nutzername );
	}

	@FXML
	void hfLoginActionEvent(ActionEvent event) {

		try {
			if(LoginFensterController.loginStatus == false) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginFenster.fxml"));
			Parent root;
			root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Login");
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
			} else {
					Node source = (Node) event.getSource();
					Stage oldstage = (Stage) source.getScene().getWindow();
					oldstage.close();
					try {
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProfilWindow.fxml"));
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@FXML
	void hfPlusActionEvent(ActionEvent event) {
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

	@FXML
	void hfRegActionEvent(ActionEvent event) {

		Node source = (Node) event.getSource();
		Stage oldstage = (Stage) source.getScene().getWindow();
		oldstage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegistrierenWindow.fxml"));
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		games = new ArrayList<>(games());

		int column = 0;
		int row = 1;

		try {
			for (int i = 0 ; i < games.size() ; i++) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("GameItem.fxml"));

				AnchorPane pane = loader.load();


				GameItemController gameItemController = loader.getController();
				gameItemController.objektErzeugen((games.get(i)));

				if (column == 6) {
					column = 0;
					++row;
				}

				hfGridObjekts.add(pane, column++, row);
				GridPane.setMargin(pane, new Insets(10));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Game> games() {
		List<Game> liste = new ArrayList<>();

		for (int i = 0; i<21; i++) {
			Game game = new Game();
			game.setName("Pokemon");
			game.setPreis(399.99);
			game.setImgPath("/img/PokemonStadium2N64.jpeg");
			liste.add(game);
		}
		return liste;
	}


}
