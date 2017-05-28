package hu.norbi.view;




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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ResultsController {
	@FXML
	private GridPane table;
	private Main mainApp;
	private BorderPane rootLayout;
	private String num;
	private Label number;
	@FXML
	private void initialize() {
		 String num;
		 Label number;


	}
	

  public void setMainApp(Main mainApp) {
      this.mainApp = mainApp;
      File configFile = new File("data.xml");
      mainApp.loadData(configFile);
      
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
 //    number.setFont(System Bold Italic);
  	  table.setConstraints(number,4, 0, 1, 1, HPos.CENTER, VPos.CENTER);
  	  
      table.getChildren().add(number);
      
	     for (int i=1;i<mainApp.getTmp().size()+1;i++)
	      {  number = new Label(Integer.toString(i));
			 table.setConstraints(number,0, i, 1, 1, HPos.CENTER, VPos.CENTER);
		   	 table.getChildren().add(number);
			 number = new Label(mainApp.getTmp().get(0).getFirstPlayerName().toString());
			 table.setConstraints(number,1, i, 1, 1, HPos.CENTER, VPos.CENTER);
			 table.getChildren().add(number);
			 number = new Label(Integer.toString(mainApp.getTmp().get(0).getFirstPlayerPoint()));
			 table.setConstraints(number,2, i, 1, 1, HPos.CENTER, VPos.CENTER);
			 table.getChildren().add(number);
			 number = new Label(mainApp.getTmp().get(0).getSecondPlayerName().toString());
			 table.setConstraints(number,3, i, 1, 1, HPos.CENTER, VPos.CENTER);
			 table.getChildren().add(number);
			 number = new Label(Integer.toString(mainApp.getTmp().get(0).getSecondPlayerPoint()));
			 table.setConstraints(number,4, i, 1, 1, HPos.CENTER, VPos.CENTER);
			 table.getChildren().add(number);
	      }
      // Add observable list data to the table
  }




@FXML
private void Back() {
    
      mainApp.Home();

}


}
