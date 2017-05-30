package hu.norbi.tests;

import hu.norbi.controller.Investigation;
import hu.norbi.modell.Table;

import static org.junit.Assert.*;

import org.junit.Test;
public class UpCaseTest {

	
	@Test
	public void connectAnswerToQuestionTest() throws Exception {
		Table tabla=new Table(20,20);
		Investigation vizsgal=new Investigation(tabla);
	assertEquals(vizsgal.UpCase("nOrBi"), "NORBI");
	
}
	
}
