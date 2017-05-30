package hu.norbi.modell;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.norbi.controller.Data;
import hu.norbi.controller.GameData;
import hu.norbi.view.Controller;
import hu.norbi.view.DescriptionController;
import hu.norbi.view.HomeController;
import hu.norbi.view.LetterController;
import hu.norbi.view.NameController;
import hu.norbi.view.ResultsController;
import hu.norbi.view.RootLayoutController;
import hu.norbi.view.ViewGameController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;



/**
 * 
 * A program main függvényét tartalmazó osztály.
 * 
 * @author bedonorbert
 *
 */


public class Main extends Application{
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	private ObservableList<GameData> tmp = FXCollections.observableArrayList();
	private int maxLetters=10;
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	
	/**
	 * 
	 *Olyen metódus, mely a kezdőképernyőt készíti el.
	 * 
	 *
	 */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Scrabble");

        initRootLayout();

        Home();
        
    
    }
	/**
	 * 
	 *Olyen metódus, mely a {@link hu.norbi.view.RootLayoutController}-t készíti el.
	 * 
	 *
	 */
    
    public void initRootLayout() {
        try {
           
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

         
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.show();
            

        
          
   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
	 * 
	 *Olyan metódus, mely a {@link hu.norbi.view.HomeController}-t készíti el.
	 * 
	 * @author bedonorbert
	 *
	 */
    public void Home() {
    	
        try {
         
        	
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/Home.fxml"));
            AnchorPane Overview = (AnchorPane) loader.load();

  
            rootLayout.setCenter(Overview);

            HomeController controller = loader.getController();
			controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
	/**
	 * 
	 *Visszaadja a {@link hu.norbi.controller.Data}-t tartalmazó listát.
	 *
	 *@return egy lista, mely a játékokat tartalmazza.
	 *
	 */
    public ObservableList<GameData> getTmp() {
		return tmp;
	}
    
	/**
	 * 
	 * Beállítja a {@link hu.norbi.controller.Data} listát.
	 * 
	 * @param tmp egy lista az eddigi játékokról.
	 *
	 */
	public void setTmp(ObservableList<GameData> tmp) {
		this.tmp = tmp;
	}
	
	/**
	 * Visszaadja a maximálisan letehető betűk számát.
	 * @return a betűk száma.
	 */
	public int getMaxLetters() {
		return maxLetters;
	}
	/**
	 * Beállítja a maximálasan letehető betűk számát.
	 * @param maxLetters a betűk száma.
	 */
	public void setMaxLetters(int maxLetters) {
		this.maxLetters = maxLetters;
	}
	
	
	
	

	/**
	 * Elmenti a játéokok adatait.
	 * @param file egy fájl.
	 * @param game egy játék adatai.
	 */
	public void saveData(File file, GameData game) {
		logger.info("Adatok mentese\n");
        try {
            JAXBContext context = JAXBContext
                    .newInstance(Data.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

           
            Data wrapper = new Data();
            tmp.add(game);
            wrapper.setGame(tmp);

           
            m.marshal(wrapper, file);

      
         
        } catch (Exception e) { 
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }



	
    /**
     * Betölti az eddigi játokok adatait.
     * 
     * @param file egy fájl.
     */
    public void loadData(File file) {
    	logger.info("Adatok betoltese\n");
        try {
            JAXBContext context = JAXBContext
                    .newInstance(Data.class);
            Unmarshaller um = context.createUnmarshaller();

           
            Data wrapper = (Data) um.unmarshal(file);

            tmp.clear();
            tmp.addAll( wrapper.getGame());

 
        

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText("Hiba a betöltés során");
            alert.setContentText("Nincsenek tárolt játékok");

            alert.showAndWait();
        }
    }
    
	
    
    /**
     * Elindítja a  {@link hu.norbi.view.Controller} -t.
     * 
     * @param players egy lista, mely a játékosok neveit tartalmazza.
     */
    public void Game(List<String> players) {
    	logger.info("Jatek indulasa\n");
        try {
           
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/Game.fxml"));
            AnchorPane OverView = (AnchorPane) loader.load();

          
            rootLayout.setCenter(OverView);


            Controller controller = loader.getController();
		     controller.setPlayers(players);  
			controller.setMainApp(this);
          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 

	
    /**
     * Betölti a {@link hu.norbi.view.ResultsController}-t.
     */
    public void Results() {
    	logger.info("Az eredmenyek megjelenitese\n");
        try {
        
        	 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/Results.fxml"));
            AnchorPane Overview = (AnchorPane) loader.load();


            rootLayout.setCenter(Overview);

            ResultsController controller = loader.getController();
			controller.setMainApp(this);
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
        
    }
    /**
     * Betölti a {@link hu.norbi.view.DescriptionController}-t.
     */
    public void Description() {
    	logger.info("A játék leírásának megtekintése\n");
        try {
        
        	 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/Description.fxml"));
            AnchorPane Overview = (AnchorPane) loader.load();


            rootLayout.setCenter(Overview);

           DescriptionController controller = loader.getController();
			controller.setMainApp(this);
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
        
    }
    /**
     * Betölti a {@link hu.norbi.view.ViewGameController}-t.
     * 
     * @param i a régebbi játékok egy azonosítója.
     */
    public void ResultView(int i) {
    	logger.info("Korábbi játék megjelenítve.\n");
        try {
        
        	 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/ViewGame.fxml"));
            AnchorPane Overview = (AnchorPane) loader.load();


            rootLayout.setCenter(Overview);

            ViewGameController controller = loader.getController();
			controller.setMainApp(this, i);
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
        
    }
    /**
     * Betölti a {@link hu.norbi.view.LetterController}-t.
     */
    public void LetterSetting() {
    	
        try {
        
        	 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/Letter.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Betűk");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

            LetterController controller = loader.getController();
			controller.setDialogStage(dialogStage, maxLetters);
			dialogStage.showAndWait();
			maxLetters=controller.getMaxLetters();
			logger.info("Betűk számai módosítva lettek.\n");
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
        
    }
    /**
     * Betölti a {@link hu.norbi.view.NameController}-t.
     * 
     * @return a játékosok neveit adja vissza vagy null-t, amennyiben az ablak be lett zárva.
     */
	public  List<String> PlayersName() {
		
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/fxml/Name.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Nevek");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			NameController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			logger.info("Be lett kerve a jatekosok neve\n");
		
			dialogStage.showAndWait();
			
			return controller.getName();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	

    	
	/**
	 * A program main függvénye.
	 * 
	 * @param args a parancssorban megadott argomentumok.
	 */
	public static void main(String[] args) {
		logger.info("A program elindult");
	
		launch(args);

		
	}

}
