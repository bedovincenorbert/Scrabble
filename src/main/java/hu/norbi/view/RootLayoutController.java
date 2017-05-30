package hu.norbi.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.norbi.modell.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * A játék menüsorának megjelenítéséért felelős osztály.
 * 
 * @author Bedő Norbert
 *
 */
public class RootLayoutController {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	private Main mainApp;
	@FXML
	private MenuItem newGame;
	
	private List<String> players=new ArrayList<String>();
	
	/**
	 * Beállítja a {@link hu.norbi.modell.Main}-t.
	 * @param mainApp a main.
	 * @return a main
	 */
  public RootLayoutController setMainApp(Main mainApp) {
      this.mainApp = mainApp;
      return this;

     
      // Add observable list data to the table
  }

  





@FXML
private void New() {
	
	players=mainApp.PlayersName();	
if (players.size()!=0)
{
	mainApp.Game(players);
}

}

@FXML
private void DeleteFile() {

	File configFile = new File("data.xml");
	configFile.delete();
	
	
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Scrabble");
	alert.setHeaderText("Törlés");
	alert.setContentText("Az eddigi játékok törölve lettek.");
	logger.info("Törölve lettek az eddigi játékok adatai.\n");
	alert.showAndWait();
}

@FXML
private void About() {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Scrabble");
	alert.setHeaderText("Névjegy");
	alert.setContentText("Szerző: Bedő Norbert\nWeboldal: https://github.com/bedonorbert/Scrabble\nDebreceni Egyetem, 2017");
	
	alert.showAndWait();

}
@FXML
private void LetterSetting(){
	mainApp.LetterSetting();
}
@FXML
private void Description(){
	mainApp.Description();
}
@FXML
private void Exit(){
	  logger.info("A program bezárult\n");
	  System.exit(0);
}

@FXML
private void Results() {
	
	mainApp.Results();
}
}
