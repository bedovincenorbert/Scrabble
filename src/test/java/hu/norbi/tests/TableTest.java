package hu.norbi.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import hu.norbi.modell.Table;

public class TableTest {
	
		@Test
		public void Test2() throws Exception {
			Table tabla=new Table(2,2);
			tabla.setTable(0, 1, 'C');
			assertEquals(tabla.tableSave(),  "nCnn");
		}
}
