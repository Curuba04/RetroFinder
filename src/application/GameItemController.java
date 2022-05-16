package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameItemController implements Initializable {

	@FXML
	private Label gameNameLabel;

	@FXML
	private Label gamePriceLabel;

	@FXML
	private ImageView imgPath;

	private Game game;

	public void objektErzeugen(Game game) {
		this.game = game;
		gameNameLabel.setText(game.getName());
		gamePriceLabel.setText(game.getPreis() + "€");
		Image image = new Image(getClass().getResourceAsStream(game.getImgPath()));
		imgPath.setImage(image);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
