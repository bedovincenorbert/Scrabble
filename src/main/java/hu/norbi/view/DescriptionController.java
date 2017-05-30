package hu.norbi.view;



import hu.norbi.modell.Main;
import javafx.fxml.FXML;

/**
 * A játék leírásának megjelenítéséért felelős osztály.
 * @author Bedő Norbert
 *
 */
public class DescriptionController {
	private Main mainApp;

	
	/**
	 * Beállítja a {@link hu.norbi.modell.Main}-t.
	 * @param mainApp a main.
	 */
  public void setMainApp(Main mainApp) {
      this.mainApp = mainApp;	
  }



@FXML
private void Home() {
    
      mainApp.Home();

}


}
