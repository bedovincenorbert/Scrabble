package hu.norbi.tests;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;

import hu.norbi.controller.Investigation;
import hu.norbi.modell.Table;
import static org.junit.Assert.*;

public class InvestigationTest {
	private List<Character> betuk= new ArrayList<Character>();
	private List<Integer> eredmeny=new ArrayList<Integer>();

	@Test
	public void parameterTest2() throws Exception {
		betuk.add('T');
		betuk.add('S');
		betuk.add('A');
		betuk.add('E');
		betuk.add('A');
		betuk.add('T');
		betuk.add('G');
		betuk.add('C');
		betuk.add('S');
		betuk.add('K');
		eredmeny.add(0);
		eredmeny.add(3);
		eredmeny.add(1);
		eredmeny.add(5);
		Table table=new Table(20,20);
		Investigation vizsgal=new Investigation(table);
		List<Integer> eredmeny=new ArrayList<Integer>();
		eredmeny=vizsgal.vizsgal("NOT", betuk, 10, 10, "Vizszintes");
		int i=eredmeny.get(0);
	assertEquals(i, 14);
}
	


}

