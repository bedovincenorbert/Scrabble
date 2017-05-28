package hu.norbi.modell;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 *Betűket tartalmazó osztály
 *
 */
public class Letters {

	 private List<Character> letters= new ArrayList<Character>();

	 Letters(){
		 for( int i=0; i<10; i++)
		 letters.add((char)(Math.random()*26+65));
	 }
	 /**
	  * 
	  *Egy játékos betűit adja vissza.
	  *
	  */
	public List<Character> getLetters() {
		
		return letters;
	}
	
	/**
	 * 
	 *Betűket tartalmazó osztály
	 *
	 */
	
	public Character getLetters(int i) {
		
		return letters.get(i);
	}
	public void setLetters(int i) {
		this.letters.set(i,(char)(Math.random()*26+65));
	}

	

	 
	 
	 
}
