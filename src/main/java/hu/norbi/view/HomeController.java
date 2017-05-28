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
 * A kezdőlap vezérlé
 * 
 * @author bedonorbert
 *
 */
public class HomeController {

	private Main mainApp;
	private BorderPane rootLayout;
	
	
	
  public void setMainApp(Main mainApp) {
      this.mainApp = mainApp;

     
      // Add observable list data to the table
  }


  public List<String> players=new ArrayList<String>();

@FXML
private void NewGame() {
	
	
		players=mainApp.PlayersName();	
	while(players.size()==0)
	{
		players=mainApp.PlayersName();
	}
      mainApp.Game(players);

}

@FXML
private void Results() {
	
      mainApp.Results();

}
}
