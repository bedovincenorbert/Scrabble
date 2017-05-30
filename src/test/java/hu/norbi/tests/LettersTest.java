package hu.norbi.tests;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.norbi.modell.Letters;



public class LettersTest {

	@Test
	public void Test() throws Exception {
		Letters letters=new Letters();
		letters.setLetterEmpty(5);
			assertEquals(letters.getLetters().size(), 9);
}
	

}
