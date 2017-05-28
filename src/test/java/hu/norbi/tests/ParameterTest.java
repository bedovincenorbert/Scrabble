package hu.norbi.tests;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;

import hu.norbi.controller.Vizsgalat;
import hu.norbi.modell.Table;
import static org.junit.Assert.*;

public class ParameterTest {
	private List<Character> betuk= new ArrayList<Character>();
	private List<Integer> eredmeny=new ArrayList<Integer>();
	@Test
	public void parameterTest() throws Exception {
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
		Vizsgalat vizsgal=new Vizsgalat(table);
		
	assertEquals(vizsgal.vizsgal("TEST", betuk, 10, 10, "Vizszintes"), eredmeny);
	assertEquals(vizsgal.vizsgal("NOT", betuk, 1, 1, "Vizszintes"), null);
}

}

