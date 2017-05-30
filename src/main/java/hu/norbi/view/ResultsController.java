package hu.norbi.view;




import java.awt.Button;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.sun.javafx.scene.traversal.Hueristic2D;

import hu.norbi.controller.GameData;
import hu.norbi.modell.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * A korábbi játékok megjelenítéséért felelős osztály.
 * @author Bedő Norbert
 *
 */
public class ResultsController {
	@FXML
	private GridPane table;
	private Main mainApp;
	@FXML
	private javafx.scene.control.Button show;
	@FXML
	private ChoiceBox game;
	 ObservableList<String> choicelist=FXCollections.observableArrayList();
	@FXML
	private void initialize() {

	
		game.setItems(choicelist);
		 game.setValue("error");
	}
	
	/**
	 * Beállítja a {@link hu.norbi.modell.Main}-t.
	 * @param mainApp a main.
	 */
  public void setMainApp(Main mainApp) {
      this.mainApp = mainApp;
     

		
		 Label number;
      number = new Label("Játék");
	  table.setConstraints(number,0, 0, 1, 1, HPos.CENTER, VPos.CENTER);
	  table.getChildren().add(number);
	 number = new Label("Első játékos neve");	
	  table.setConstraints(number,1, 0, 1, 1, HPos.CENTER, VPos.CENTER);
    	table.getChildren().add(number);
  	  number = new Label("Első játékos pontja");	
  	  table.setConstraints(number,2, 0, 1, 1, HPos.CENTER, VPos.CENTER);
      table.getChildren().add(number);
      number = new Label("Második játékos neve");	
  	  table.setConstraints(number,3, 0, 1, 1, HPos.CENTER, VPos.CENTER);
      table.getChildren().add(number);
      number = new Label("Második játékos pontja");	
   
  	  table.setConstraints(number,4, 0, 1, 1, HPos.CENTER, VPos.CENTER);
   	  table.getChildren().add(number);
      File configFile = new File("data.xml");
      
      mainApp.loadData(configFile);
      if(configFile.isFile())
	    
      {
	     for (int i=1;i<mainApp.getTmp().size()+1;i++)
	      {  choicelist.add(Integer.toString(i));
	    	 number = new Label(Integer.toString(i));
			 table.setConstraints(number,0, i, 1, 1, HPos.CENTER, VPos.CENTER);
		   	 table.getChildren().add(number);
			 number = new Label(mainApp.getTmp().get(i-1).getFirstPlayerName().toString());
			 table.setConstraints(number,1, i, 1, 1, HPos.CENTER, VPos.CENTER);
			 table.getChildren().add(number);
			 number = new Label(Integer.toString(mainApp.getTmp().get(i-1).getFirstPlayerPoint()));
			 table.setConstraints(number,2, i, 1, 1, HPos.CENTER, VPos.CENTER);
			 table.getChildren().add(number);
			 number = new Label(mainApp.getTmp().get(i-1).getSecondPlayerName().toString());
			 table.setConstraints(number,3, i, 1, 1, HPos.CENTER, VPos.CENTER);
			 table.getChildren().add(number);
			 number = new Label(Integer.toString(mainApp.getTmp().get(i-1).getSecondPlayerPoint()));
			 table.setConstraints(number,4, i, 1, 1, HPos.CENTER, VPos.CENTER);
			 table.getChildren().add(number);
	      }
      }

	     if (!choicelist.isEmpty()) {
	    	 show.setDisable(false);
	    	 game.setDisable(false);
	     }    
  }

  @FXML
 private void Show(){
	  if (isInputValid())
	  {
	  mainApp.ResultView(Integer.parseInt(game.getValue().toString())-1);  
	  }
  }


@FXML
private void Back() {
    
      mainApp.Home();

}


private boolean isInputValid() {
	String errorMessage = "";

	if(game.getValue() =="error") {
		errorMessage += "Nem valasztott megjelenítendő játékot!\n";
	}

	
	if(errorMessage.length() == 0) {
		return true;
	} else {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle("Nem megfelelő a bemenő paraméter");
		alert.setHeaderText("Kérem adjon meg egy paramétert");
		alert.setContentText(errorMessage);
		
		alert.showAndWait();
		
		return false;
	}
	}

}
