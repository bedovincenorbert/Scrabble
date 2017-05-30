package hu.norbi.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import hu.norbi.controller.GameData;


public class GameDataTest {

	@Test
	public void Test() throws Exception {
		GameData data=new GameData();	
		data.setFirstPlayerName("Norbi");
		assertEquals(data.getFirstPlayerName(), "Norbi");
}
	@Test
	public void Test1() throws Exception {
		GameData data=new GameData();	
		data.setSecondPlayerName("Norbi");
		assertEquals(data.getSecondPlayerName(), "Norbi");
}
	@Test
	public void Test2() throws Exception {
		GameData data=new GameData();	
		data.setFirstPlayerPoint(10);
		assertEquals(data.getFirstPlayerPoint(), 10);
}
	@Test
	public void Test3() throws Exception {
		GameData data=new GameData();	
		data.setSecondPlayerPoint(20);
		assertEquals(data.getSecondPlayerPoint(), 20);
}
	
	@Test
	public void Test4() throws Exception {
		GameData data=new GameData();	
		data.setTable("ABCDEFG");
		assertEquals(data.getTable(), "ABCDEFG");
}
	
	
}
