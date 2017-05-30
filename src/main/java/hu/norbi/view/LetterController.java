package hu.norbi.view;
import java.util.ArrayList;
import java.util.List;

import hu.norbi.modell.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * A játék lerakható betűinek megváltoztatását megvalósító osztály.
 * 
 * @author Bedő Norbert
 *
 */
public class LetterController {

	@FXML
	private TextField letterSize;
	int maxLetters;
	
	private Stage dialogStage;
	private boolean okClicked = false;
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Beállítja az ablakot, illetve megkapja a jelenlegi maximális betűk számát.
	 * @param dialogStage az ablak.
	 * @param i a maximális betűk száma.
	 */
	public void setDialogStage(Stage dialogStage, int i) {
		this.dialogStage = dialogStage;
		maxLetters=i;
		letterSize.setText(Integer.toString(maxLetters));
		
	}
	
   


	/**
	 * Visszaadja a maximálisan lerakható bettűk számát.
	 * @return a betűk száma.
	 */
	public int getMaxLetters() {
		return maxLetters;
	}


	
	@FXML
	private void send() {
		if(isInputValid()) {
			
			
			maxLetters=Integer.parseInt(letterSize.getText().toString());
			dialogStage.close();
		}
	}
	


	private boolean isInputValid() {
		String errorMessage = "";
		
		if(letterSize.getText() == null || letterSize.getText().length() == 0) {
			errorMessage += "Nem adott meg értéket!\n";
		}
		if(Integer.parseInt(letterSize.getText().toString())<0) {
			errorMessage += "Nulla vagy nullánál nagyobb egész szám adható meg!";
		}

		
		
		if(errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Hiányzó paraméterek");
			alert.setHeaderText("Kérem adja meg a játékosok nevét!");
			alert.setContentText(errorMessage);
			
			alert.showAndWait();
			
			return false;
		}
	}
}
