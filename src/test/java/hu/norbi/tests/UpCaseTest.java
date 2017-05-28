package hu.norbi.tests;

import hu.norbi.controller.Vizsgalat;
import static org.junit.Assert.*;

import org.junit.Test;
public class UpCaseTest {

	
	@Test
	public void connectAnswerToQuestionTest() throws Exception {
		
		Vizsgalat vizsgal=new Vizsgalat();
	assertEquals(vizsgal.UpCase("nOrBi"), "NORBI");
	
}
	
	
}
