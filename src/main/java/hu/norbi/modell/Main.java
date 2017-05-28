package hu.norbi.modell;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.norbi.controller.Data;
import hu.norbi.controller.GameData;
import hu.norbi.controller.Vizsgalat;
import hu.norbi.view.Controller;
import hu.norbi.view.HomeController;
import hu.norbi.view.NameController;
import hu.norbi.view.ResultsController;
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
 * Olyan függvény, amely a Main osztályt tartalmazza
 * 
 * @author bedonorbert
 *
 */
public class Main extends Application{
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	private ObservableList<GameData> tmp = FXCollections.observableArrayList();
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	
	/**
	 * 
	 *A kezdőképernyő elkészítése
	 * 
	 * @author bedonorbert
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
	 *Menüsor létrehozása.
	 * 
	 * @author bedonorbert
	 *
	 */
    
    public void initRootLayout() {
        try {
           
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

         
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            Controller controller = loader.getController();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
	 * 
	 *A kezdőképernyő betöltése
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
	 *Visszaad egy ObservableList-et.
	 *
	 *@return egy lista
	 * 
	 * @author bedonorbert
	 *
	 */
    public ObservableList<GameData> getTmp() {
		return tmp;
	}
    
	/**
	 * 
	 * Beállít egy ObservableList-et.
	 * 
	 * @param tmp egy lista.
	 * 
	 * @author bedonorbert
	 *
	 */
	public void setTmp(ObservableList<GameData> tmp) {
		this.tmp = tmp;
	}
	/**
	 * 
	 *Elmenti egy fájlba a játék adatait.
	 * 
	 * @author bedonorbert
	 *
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
	 * 
	 *Betölti a játék adatait.
	 * 
	 * @author bedonorbert
	 *
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
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());

            alert.showAndWait();
        }
    }
    
	/**
	 * 
	 *Elindítja a játék képernyőjét.
	 * 
	 * @author bedonorbert
	 *
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
    
    public Main(){
    	
    }
	/**
	 * 
	 *Betölti a régebbi játékok adatait.
	 * 
	 * @author bedonorbertg
	 *
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
    
	public  List<String> PlayersName() {
		logger.info("Be lett kerve a jatekosok neve\n");
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/fxml/Name.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Names");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			NameController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			
		
			dialogStage.showAndWait();
			
			return controller.getName();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	

    
	public static void main(String[] args) {
		logger.info("A program elindult");
		launch(args);

		
	}

}
