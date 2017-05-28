package hu.norbi.view;



import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import hu.norbi.controller.GameData;
import hu.norbi.controller.Vizsgalat;

import hu.norbi.modell.Main;
import hu.norbi.modell.Player;
import hu.norbi.modell.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;


public class Controller {
	ObservableList<String> choicelist=FXCollections.observableArrayList("Vizszintes", "Függőleges");
@FXML
	private TextField elkuldendoszo=new TextField();
	private Main mainApp;

	@FXML
	private Label betuk=new Label();
	@FXML
	private Label pontszam=new Label();
	@FXML
	private Label tablazatelem;
	@FXML
	private Label jatekos;
	@FXML
	private GridPane table;
	@FXML
	private ChoiceBox choice;
	@FXML
	private TextField szo;
	@FXML
	private TextField sor;

	@FXML
	private TextField oszlop;
	private List<String> players=new ArrayList<String>();
	Table tabla=new Table (20,20);
	 Player elso=new Player();
	 Player masodik=new Player();
	
	 Vizsgalat vizsgal=new Vizsgalat(tabla);
	 private boolean elsojatekos=true;

	@FXML
     
	private void initialize() {
  
		 choice.setItems(choicelist);
		 choice.setValue("error");
		 String num;
		 Label number;

				//	ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("A", "B", "C"));

		
	/*	tabla.table[1][1]='C';
	tablazatelem.setText(Character.toString(tabla.table[3][3]));*/
	 //   elso.setCellValueFactory(cellData->cellData.getValue().getOszlop());
	    
	  betuk.setText(elso.getBetu().getLetters().toString());
	
	  pontszam.setText(Integer.toString(elso.getPoints()));
	   // betuk.setText(t->t.getValue().betu.getLetters().toString());

	}




public Controller(){
	
}
	public void setPlayers(List<String> players) {
		this.players = players;
		 elso.setName(players.get(0));
		  masodik.setName(players.get(1));
		  jatekos.setText(elso.getName());
	}



	public void setMainApp(Main mainApp) {
	      this.mainApp = mainApp;
		 
	   	

	      // Add observable list data to the table
	  }
public TextField getElkuldendoszo() {
	return elkuldendoszo;
}



public void setElkuldendoszo(TextField elkuldendoszo) {
	this.elkuldendoszo = elkuldendoszo;
}


@FXML
private void send() {
	Player seged=new Player();
	
	int dontes=0;
	if (elsojatekos) { 
		seged=elso;
		
	}
	else {
		seged=masodik;
	}
	
	List<Integer> eredmeny;
	

	if(isInputValid()) {
		String szavam=szo.getText();
		int sorIndex=Integer.parseInt(sor.getText().toString());
		int oszlopIndex=Integer.parseInt(oszlop.getText().toString());
		eredmeny=vizsgal.vizsgal(szavam, seged.getBetu().getLetters(),sorIndex-1,oszlopIndex-1, choice.getValue().toString());
		if(eredmeny==null) dontes=1;
		else {
			
		if(eredmeny.isEmpty()) dontes=2;
		}
		 
		if ( dontes==0)
		{
			if(elsojatekos) {
				elsojatekos=false;
			}
			else {
				elsojatekos=true;
			}
			if (choice.getValue()=="Vizszintes") {
				for (int i=0;i<szavam.length();i++){
				     char betu=szavam.charAt(i);
									Label number = new Label(szavam.substring(i, i+1));
								
									table.setConstraints(number, i+oszlopIndex, sorIndex, 1, 1, HPos.CENTER, VPos.CENTER);
									table.getChildren().add(number);
				}
			}
				else {
					for (int i=0;i<szavam.length();i++){
					     char betu=szavam.charAt(i);
										Label number = new Label(szavam.substring(i, i+1));
									
										table.setConstraints(number, oszlopIndex, sorIndex+i, 1, 1, HPos.CENTER, VPos.CENTER);
										table.getChildren().add(number);
					}
				}
			
	for (int i=0;i<eredmeny.size();i++)
	{
		seged.getBetu().setLetters(eredmeny.get(i));
		seged.setPoints(seged.getPoints()+1);
	}
	
	
	
	 
	}
		else {
			
			if (dontes==2){
			Alert alert = new Alert(AlertType.ERROR);

			alert.setTitle("Nem megfelelő a megadott szó");
			alert.setHeaderText("Kérem adjon meg egy újabb szót");
			alert.setContentText("A szó nem helyezhető el a táblán, mert ütközik egy másik szóval!");
			
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);

			alert.setTitle("Nem megfelelő a megadott szó");
			alert.setHeaderText("Kérem adjon meg egy újabb szót");
			alert.setContentText("Nincs m!");
			
			alert.showAndWait();
		}
			
			
		}
	}
			if (!elsojatekos) {
				elso=seged;
				
				jatekos.setText(masodik.getName());
				seged=masodik;
				
				betuk.setText(seged.getBetu().getLetters().toString());
				pontszam.setText(Integer.toString(seged.getPoints()));
			} 
			else {
				masodik=seged;
			
				jatekos.setText(elso.getName());
				seged=elso;
				betuk.setText(seged.getBetu().getLetters().toString());
				pontszam.setText(Integer.toString(seged.getPoints()));
			}
			 szo.setText("");
			 sor.setText("");
			 oszlop.setText("");
			 choice.getSelectionModel().clearSelection();
			 
		
			 GameData data=new GameData();
			 data.setFirstPlayerName(elso.getName());
			 data.setFirstPlayerPoint(elso.getPoints());
			 data.setSecondPlayerName(masodik.getName());
			 data.setSecondPlayerPoint(masodik.getPoints());
			
		
			 
			 
			 
	
			 
			 
			 
		        File configFile = new File("data.xml");
		      if(configFile==null) mainApp.loadData(configFile);
		        
			 mainApp.saveData(configFile, data);
			 
			 
			 
			 
}

public boolean isInputValid() {
	String errorMessage = "";
	
	if(szo.getText() == null || szo.getText().length() == 0) {
		errorMessage += "Nem adott meg sz�t!\n";
	}
	if(sor.getText() == null || sor.getText().length() == 0) {
		errorMessage += "Nem adott meg sort!\n";
	}
	else {
		if((Integer.parseInt(sor.getText()))<1) {
			errorMessage += "Nem megfelel� a sorsz�ma!\n";
		}
		else if ((choice.getValue()=="F�gg�leges")&&(Integer.parseInt(sor.getText())+szo.getText().length()-1>20))
		{
			errorMessage += "Nem megfelel� a sorsz�ma!\n";
		}
	}
	if(oszlop.getText() == null || oszlop.getText().length() == 0) {
		errorMessage += "Nem adott meg oszlopot\n";
	}
	else {
		if((Integer.parseInt(oszlop.getText()))<1) {
			errorMessage += "Nem megfelel� az oszlopsz�ma!\n";
		}
		else if ((choice.getValue()=="Vizszintes")&&(Integer.parseInt(oszlop.getText())+szo.getText().length()-1>20))
		{
			errorMessage += "Nem megfelel� az oszlopsz�ma!\n";
		}
	}
	if(choice.getValue() =="error") {
		errorMessage += "Nem adott meg ir�nyt!\n";
	}
	System.out.println("ez: "+betuk.getText());
	
	/*if(postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
		errorMessage += "No valid postal code!\n";
	} else {
		try {
			Integer.parseInt(postalCodeField.getText());
		} catch (NumberFormatException e) {
			errorMessage += "No valid postal code (must be integer)!\n";
		}*/
	if(errorMessage.length() == 0) {
		return true;
	} else {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle("Nem megfelel� bemen� param�terek");
		alert.setHeaderText("K�rem adjon meg megfelel� �rt�keket");
		alert.setContentText(errorMessage);
		
		alert.showAndWait();
		
		return false;
	}
	}



}
