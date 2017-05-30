package hu.norbi.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import hu.norbi.modell.Player;


public class PlayerTest {

	@Test
	public void Test() throws Exception {
		Player player=new Player();
		player.setName("Norbi");
		assertEquals(player.getName() ,"Norbi" );
	}
	@Test
	public void Test2() throws Exception {
		Player player=new Player();
		player.setPoints(15);
		assertEquals( player.getPoints(), 15);
	}
	
	@Test
	public void Test3() throws Exception {
		Player player=new Player();
		assertEquals( player.getBetu().getLetters().size(), 10);
	}
}
