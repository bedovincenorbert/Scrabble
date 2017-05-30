package hu.norbi.view;




import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.norbi.modell.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * A játék kezdőlapjának vezérélését megvalósító osztály.
 * 
 * @author bedonorbert
 *
 */
public class HomeController {

	private Main mainApp;
	private BorderPane rootLayout;
	
	
	/**
	 * Beállítja a {@link hu.norbi.modell.Main}-t.
	 * @param mainApp a main.
	 */
  public void setMainApp(Main mainApp) {
      this.mainApp = mainApp;

     
      // Add observable list data to the table
  }




@FXML
private void NewGame() {
	  List<String> players=new ArrayList<String>();
	
		players=mainApp.PlayersName();	
	if (players.size()!=0)
	{
		mainApp.Game(players);
	}
      

}

@FXML
private void Results() {
	
      mainApp.Results();

}
}
