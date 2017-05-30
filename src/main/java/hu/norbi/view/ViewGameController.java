package hu.norbi.view;




import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.norbi.controller.GameData;
import hu.norbi.modell.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Egy korábbi játék megtekintéséért felelős osztály.
 * 
 * @author Bedő Norbert
 *
 */
public class ViewGameController {

	private Main mainApp;
	private BorderPane rootLayout;
	@FXML
	private Label FirstPlayer;
	@FXML
	private Label SecondPlayer;
	@FXML
	private Label FirstPoint;
	@FXML
	private Label SecondPoint;
	@FXML
	private GridPane table;

	private void initialize() {

	}
	/**
	 * Beállítja a {@link hu.norbi.modell.Main}-t, a játékosok neveit, 
	 * pontszámjukat, illetve betölti azt a táblát, ahogyan a játék befeződött.
	 * @param mainApp a main.
	 * @param game a kiválasztott játék.
	 */
  public void setMainApp(Main mainApp, int game) {
	  
      this.mainApp = mainApp;
      Label letter;
      GameData gamedata=mainApp.getTmp().get(game);
      String tablestring=gamedata.getTable();
      FirstPlayer.setText(gamedata.getFirstPlayerName());
      SecondPlayer.setText(gamedata.getSecondPlayerName());
      FirstPoint.setText(Integer.toString(gamedata.getFirstPlayerPoint()));
      SecondPoint.setText(Integer.toString(gamedata.getSecondPlayerPoint()));
      for (int i=0;i<gamedata.getTable().length(); i++)
      {
    	    if(tablestring.charAt(i)!='n')
    	    {
    	    letter = new Label(tablestring.substring(i, i+1));	
			table.setConstraints(letter, i/20+1, i%20+1, 1, 1, HPos.CENTER, VPos.CENTER);
			table.getChildren().add(letter);  
    	    }
      }
  }





@FXML
private void Back() {
    
      mainApp.Results();

}

}
