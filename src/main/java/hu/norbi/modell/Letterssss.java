package hu.norbi.modell;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy betűt reprezentáló osztály.
 * 
 * @author bedonorbert
 *
 */
public class Letters {

	 private List<Character> letters= new ArrayList<Character>();
	 private Character temp;
	
	 
	/*
	 * Konstuktor, mely egy {@link Player}-nek legenerálja a 10 betűjét.
	 */
	public Letters(){
		 for( int i=0; i<10; i++)
		 letters.add((char)(Math.random()*26+65));
		 
		sortedLetters();
	 }
	 /**
	  * 
	  *Egy {@link Player} {@link Letters} adja vissza.
	  *
	  *
	  *@return A játékos betűi.
	  */
	public List<Character> getLetters() {
		
		return letters;
	}
	

	/**
	 * Egy metódus, mely a {@link Letters} egy pozíciójára új betűt generál.
	 * 
	 * @param i egy pozíció.
	 */
	public void setLetters(int i) {
		this.letters.set(i,(char)(Math.random()*26+65));
	}
	
	/**
	 * Egy metódus, mely a {@link Letters} egy karakterjét eltávolítja.
	 * @param i az eltálítandó karakter.
	 */
	public void setLetterEmpty(int i) {
		this.letters.remove(i);
		
		
	}

	/**
	 * Egy metódus, mely egy {@link Player} {@link Letters}-t  ABC sorrendbe rendezi.
	 */
	public void sortedLetters(){
		
		 for (int i=0; i<letters.size()-1;i++)
			 for(int j=i+1;j<letters.size();j++)
			 {
				 if (letters.get(i)>letters.get(j))
				 {
					 temp=letters.get(i);
					 letters.set(i, letters.get(j));
					 letters.set(j, temp);
				 }
			 }
		 
	 }

	 
	 
	 
}
