package hu.norbi.view;
import java.util.ArrayList;
import java.util.List;

import hu.norbi.modell.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NameController {

	@FXML
	private TextField firstPlayer;
	
	@FXML
	private TextField secondPlayer;
	
	private Stage dialogStage;
	private boolean okClicked = false;
	private List<String> name=new ArrayList<String>();
	Player first, second;
	@FXML
	private void initialize() {
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
   
	
	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	public boolean isOk() {
		return okClicked;
	}
	@FXML
	private void Ok() {
		if(isInputValid()) {
			
			
			name.add(firstPlayer.getText().toString());
			name.add(secondPlayer.getText().toString());
			dialogStage.close();
		}
	}
	
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	private boolean isInputValid() {
		String errorMessage = "";
		
		if(firstPlayer.getText() == null || firstPlayer.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if(secondPlayer.getText() == null || secondPlayer.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		
		
		if(errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			
			alert.showAndWait();
			
			return false;
		}
	}
}
