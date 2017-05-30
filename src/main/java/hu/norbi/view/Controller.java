package hu.norbi.view;



import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.norbi.controller.GameData;
import hu.norbi.controller.Investigation;
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



/**
 * A játék megjelenítését kezelő osztály.
 * 
 * @author Bedő Norbert
 *
 */
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
	private boolean firstStep=true;
	private boolean firstPassing=false;
	private boolean secondPassing=false;
	private boolean end=false;
	private GameData data=new GameData();
	private static Logger logger = LoggerFactory.getLogger(Main.class); 
	 Table tabla=new Table (20,20);
	 Player elso=new Player();
	 Player masodik=new Player();
	
	 Investigation vizsgal=new Investigation(tabla);
	 private boolean elsojatekos=true;

	@FXML
     
	private void initialize() {
		 
		 choice.setItems(choicelist);
		 choice.setValue("error");		    
		 betuk.setText(elso.getBetu().getLetters().toString());	
		 pontszam.setText(Integer.toString(elso.getPoints()));
  
	}





	/**
	 * 
	 * A játékok neveit állítja be, illetve az első játékos nevét megjeleníti.
	 * @param players a {@link hu.norbi.modell.Player}-t tartalmazó lista.
	 */
	public void setPlayers(List<String> players) {
		
		 elso.setName(players.get(0));
		  masodik.setName(players.get(1));
		  jatekos.setText(elso.getName());
	}



	/**
	 * Beállítja a {@link hu.norbi.modell.Main}-t.
	 * @param mainApp a main.
	 */
	public void setMainApp(Main mainApp) {
	      this.mainApp = mainApp;
	  }
	

@FXML
private void Passing() {
	if(elsojatekos) {
		if (!firstPassing){
			elsojatekos=false;
			jatekos.setText(masodik.getName());
			
			betuk.setText(masodik.getBetu().getLetters().toString());
			pontszam.setText(Integer.toString(masodik.getPoints()));
			firstPassing=true;
		}
		else {
			end=true;
		}
	}
	else {
		if(!secondPassing){
			elsojatekos=true;
			jatekos.setText(elso.getName());
			betuk.setText(elso.getBetu().getLetters().toString());
			pontszam.setText(Integer.toString(elso.getPoints()));
			secondPassing=true;
		}
		else {
			end=true;
		}
		
	}	
	
	if (end||(firstPassing&&secondPassing)) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Scrabble");
		alert.setHeaderText("A játék végetért");
		if(elso.getPoints()>masodik.getPoints()) {
			alert.setContentText(elso.getName()+" nyerte a játékot!");
			logger.info("A jatek vegetert. "+elso.getName()+" nyerte a jatekot\n");
		}
		else {
				if(elso.getPoints()<masodik.getPoints()) {
					alert.setContentText(masodik.getName()+" nyerte a játékot!");
					logger.info("A jatek vegetert. "+elso.getName()+" nyerte a jatekot\n");
				}
				else {
					alert.setContentText("Döntetlen lett!");

					logger.info("A jatek vegetert. Döntetlen lett.");
				}
			}
		alert.showAndWait();
		mainApp.setMaxLetters(10);
		
		mainApp.Home();
		}
	
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
		
		switch(eredmeny.get(0)){
		case 11: {
			Alert alert = new Alert(AlertType.ERROR);

			alert.setTitle("Nem megfelelő a megadott szó");
			alert.setHeaderText("Kérem adjon meg egy újabb szót");
			alert.setContentText("A szó nem helyezhető el a táblán, mert legalább egy másik betűvel ütközik!");
			
			alert.showAndWait();
			break;
			}
		case 12: {
			Alert alert = new Alert(AlertType.ERROR);

			alert.setTitle("Nem megfelelő a megadott szó");
			alert.setHeaderText("Kérem adjon meg egy újabb szót");
			alert.setContentText("A szó nem helyezhető el a táblán, mert nem érintkezik egyetlen szóval sem!");
			
			alert.showAndWait();
			break;
			}
		case 13: {
			Alert alert = new Alert(AlertType.ERROR);

			alert.setTitle("Nem megfelelő a megadott szó");
			alert.setHeaderText("Kérem adjon meg egy újabb szót");
			alert.setContentText("A szó nem helyezhető el a táblán, mert nem használt fel egyetlen betűt se a betűkészletből!");
			
			alert.showAndWait();
			break;
			}
		case 14: {
			Alert alert = new Alert(AlertType.ERROR);

			alert.setTitle("Nem megfelelő a megadott szó");
			alert.setHeaderText("Kérem adjon meg egy újabb szót");
			alert.setContentText("Nincsenek meg a megfelelő betűk a készletben!");
			
			alert.showAndWait();
			break;
		}
		default: {
			if(elsojatekos) {
				elsojatekos=false;
				firstPassing=false;
			}
			else {
				elsojatekos=true;
				secondPassing=false;
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
	 
		for (int i=eredmeny.size();i>0;i--)
		{   if (mainApp.getMaxLetters()==0) 
			{
				seged.getBetu().setLetterEmpty(i);
			}
			else {
				seged.getBetu().setLetters(eredmeny.get(i-1));
				mainApp.setMaxLetters(mainApp.getMaxLetters()-1);
				if((seged.getBetu().getLetters().size()<10)&&(mainApp.getMaxLetters()>0))
				{
					for (int j=0;j<(10-seged.getBetu().getLetters().size());j++){
						
						if((mainApp.getMaxLetters()>0)){
							seged.getBetu().getLetters().add((char)(Math.random()*26+65));
							mainApp.setMaxLetters(mainApp.getMaxLetters()-1);
						}
					}
						
				}
			}
			
			seged.setPoints(seged.getPoints()+1);
		}
	   seged.getBetu().sortedLetters();
	
	
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
	
	 
	}
		break;
		}
	
	
			
		}
		
		
	
			
			 szo.setText("");
			 sor.setText("");
			 oszlop.setText("");
			 choice.getSelectionModel().clearSelection();
			 
		
			 
			 data.setFirstPlayerName(elso.getName());
			 data.setFirstPlayerPoint(elso.getPoints());
			 data.setSecondPlayerName(masodik.getName());
			 data.setSecondPlayerPoint(masodik.getPoints());
			 data.setTable(tabla.tableSave());
		
		

			 
		        File configFile = new File("data.xml");
		        if (configFile.isFile()&&firstStep)   mainApp.loadData(configFile);
		        if (!firstStep) mainApp.getTmp().remove(mainApp.getTmp().size()-1);
		        else {
		        	firstStep=false;
		        }
			 mainApp.saveData(configFile, data);
			 
			 
			 
			 
}

private boolean isInputValid() {
	String errorMessage = "";
	
	if(szo.getText() == null || szo.getText().length() == 0) {
		errorMessage += "Nem adott meg szót!\n";
	}
	if(sor.getText() == null || sor.getText().length() == 0) {
		errorMessage += "Nem adott meg sort!\n";
	}
	else {
		if((Integer.parseInt(sor.getText()))<1) {
			errorMessage += "Nem megfelelő a sorszáma!\n";
		}
		else if ((choice.getValue()=="Függőleges")&&(Integer.parseInt(sor.getText())+szo.getText().length()-1>20))
		{
			errorMessage += "Nem megfeleló a sorszáma!\n";
		}
	}
	if(oszlop.getText() == null || oszlop.getText().length() == 0) {
		errorMessage += "Nem adott meg oszlopot!\n";
	}
	else {
		if((Integer.parseInt(oszlop.getText()))<1) {
			errorMessage += "Nem megfelelő az oszlopszáma!\n";
		}
		else if ((choice.getValue()=="Vizszintes")&&(Integer.parseInt(oszlop.getText())+szo.getText().length()-1>20))
		{
			errorMessage += "Nem megfelelő az oszlopszáma!\n";
		}
	}
	if((choice.getValue()!="Függőleges")&&(choice.getValue()!="Vizszintes")) {
		errorMessage += "Nem adott meg irányt!\n";
	}
	System.out.println("ez: "+betuk.getText());

	if(errorMessage.length() == 0) {
		return true;
	} else {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle("Nem megfelelő bemenő paraméterek");
		alert.setHeaderText("Kérem adjon meg megfelelő értékeket!");
		alert.setContentText(errorMessage);
		
		alert.showAndWait();
		
		return false;
	}
	}



}
