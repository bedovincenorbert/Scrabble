package hu.norbi.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hu.norbi.controller.Data;
import hu.norbi.controller.GameData;

public class DataTest {

	@Test
	public void Test() throws Exception {
		Data data=new Data();
		GameData gameData=new GameData();	
		gameData.setFirstPlayerName("Norbi");
		List<GameData> temp=new ArrayList<GameData>();
		temp.add(gameData);
		data.setGame(temp);
		assertEquals(data.getGame().get(0).getFirstPlayerName(), "Norbi");
}
}
