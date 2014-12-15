// This entire file is part of my masterpiece
// ABHISHEK B

package gamePlayer.view;

import gamePlayer.model.PlayerModel;
import gamePlayer.view.keyboardUtility.KeyboardView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

/**
 * This is the controller class for the Ribbon Tab Pane
 * It contains all of the methods that are called from the FXML file
 * via the onAction tag, and interacts directly with the model to
 * make these files.
 * 
 * @author Shreyas B
 * @author Abhishek B
 *
 */

public class MenuBarController implements Initializable{

	private PlayerModel myPlayerModel;
	private KeyboardView myKeyboard;

	@FXML
	private Tab gameSelector;
	
	@FXML
	private Tab gameOptions;
	
	@FXML
	private Tab gamePreferences;

	public void setModel(PlayerModel model){
		myPlayerModel=model;
	}
	
	public void setKeyboard() {
		myKeyboard = new KeyboardView(myPlayerModel.getButtonConditions());
	}
	
	@FXML
	private void loadGameFile(final ActionEvent event){
		myPlayerModel.loadGameFile();
		gameOptions.setDisable(false);
		gamePreferences.setDisable(false);
	}
	
	@FXML
	private void exitFromGamePlayer(final ActionEvent event){
		myPlayerModel.exitFromGamePlayer();
		gameOptions.setDisable(true);
		gamePreferences.setDisable(true);
	}
	
	@FXML
	private void fetchGameFromWeb(final ActionEvent event) {
		// Unimplemented method
	}
	
	@FXML
	private void saveGameToWeb(final ActionEvent event) {
		// Unimplemented method
	}
	
	@FXML
	private void saveGameProgress(final ActionEvent event) {
		myPlayerModel.saveGameProgress();
	}
	
	@FXML
	private void loadGameProgress(final ActionEvent event) {
		myPlayerModel.loadGameProgress();
	}
	
	@FXML
	private void pauseGame(final ActionEvent event){
		myPlayerModel.pauseGame();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		menuBar.setFocusTraversable(true);	
	}
	
	@FXML
	private void keyCombos(final ActionEvent event) {
		myPlayerModel.pauseGame();
		myKeyboard.createKeyboardView();
	}
	
}
