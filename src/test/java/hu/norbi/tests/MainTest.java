package hu.norbi.tests;
import static org.junit.Assert.assertEquals;



import org.junit.Test;


import hu.norbi.controller.GameData;
import hu.norbi.modell.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainTest {
	@Test
	public void Test() throws Exception {
		Main main=new Main();
		main.setMaxLetters(20);
		assertEquals( main.getMaxLetters(), 20);
	}
	
	@Test
	public void Test2() throws Exception {
		Main main=new Main();
		
		GameData gameData=new GameData();	
		gameData.setFirstPlayerName("Norbi");
		ObservableList<GameData> temp=FXCollections.observableArrayList();
		temp.add(gameData);
		main.setTmp(temp);
		assertEquals( main.getTmp().get(0).getFirstPlayerName(), "Norbi");
	}
}
