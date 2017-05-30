package hu.norbi.controller;

import java.util.ArrayList;
import java.util.List;

import hu.norbi.modell.Table;

/**
 * 
 * A játék vizsgálását reprezentáló osztály.
 * 
 * @author bedonorbert
 *
 */
public class Investigation {
 private Table tabla;
 private List<Integer> poziciok = new ArrayList<Integer>();
 private boolean firstStep=true;
 
 /**
  * Konstruktor, mely beállítja a játék tábláját.
  * 
 * @param tabla a játék táblája.
 */
public Investigation(Table tabla){
	this.tabla=tabla;
 }


/**
 * Olyan metódus, mely egy szót nagybetűssé alakít.
 * 
 * @param word egy szó.
 * @return A szó nagybetűsként visszaadva.
 */
public String UpCase (String word) {
	String upcase="";
	char tmp;
	for (int i=0;i<word.length(); i++)
	{
		tmp=word.charAt(i);
		if(tmp>'a'&&tmp<'z')
		tmp-=32;
		upcase+=tmp;
		
	}
	 
	  System.out.println(upcase);
	  return upcase;
}


/**
 * Egy metódus, mely megvizsgálja, hogy egy szó lerakható-e a táblára.
 * 
 * @param szo amit szeretnénké lerakni.
 * @param betukeszlet a játékos betűit tartalmazza.
 * @param sor az első betű sorszáma.
 * @param oszlop az eslő betű oszlopszáma.
 * @param irany a szó iránya.
 * @return Egy lista, mely a levonandó betűket tartalmazza, vagy üres vagy null-ra mutat. 
 */
public  List<Integer> vizsgal ( String szo, List<Character> betukeszlet, int sor, int oszlop, String irany){
	poziciok.removeAll(poziciok);

Character temp;
String szavam="";

if ((irany=="Vizszintes")){
	for (int lerak=oszlop; lerak<oszlop+szo.length(); lerak++){
		temp=tabla.getTable(sor, lerak);
		if(!(temp>='A'&&temp<='Z'))  szavam=szavam+szo.substring(lerak-oszlop, lerak-oszlop+1);
		else {
			if(temp!=szo.charAt(lerak-oszlop)) {
				poziciok.add(11);
				return poziciok;
			}
		}
	}
		
	
}

if ((irany=="Függőleges")){
	for (int lerak=sor; lerak<sor+szo.length(); lerak++){
		temp=tabla.getTable(lerak, oszlop);
		if(!(temp>='A'&&temp<='Z'))  szavam=szavam+szo.substring(lerak-sor, lerak-sor+1);
		else {
			if(temp!=szo.charAt(lerak-sor)) {
				poziciok.add(11);
				return poziciok;
			}
		}
	}
		
	
}

	if (!firstStep&&(szavam.length()==szo.length())) {
		poziciok.add(12);
		return poziciok;
	}
	
	if (szavam.length()==0) {
		poziciok.add(13);
		return poziciok;
	}


	for ( int sz=0; sz<szavam.length(); sz++){
		for (int betuk=0; betuk<betukeszlet.size();betuk++)
		{
			if ((szavam.charAt(sz)==betukeszlet.get(betuk))&&(!poziciok.contains(betuk))) {
				poziciok.add(betuk);
				break;
			}
			
		if (betuk==betukeszlet.size()-1) {
			
				poziciok.add(14);
				return poziciok;
			
		}
		
		}
		
	
	
	}
	
	
		if ((irany=="Vizszintes")){
			for (int lerak=oszlop; lerak<oszlop+szo.length(); lerak++)
				tabla.setTable(sor,  lerak, szo.charAt(lerak-oszlop));
			
		}
		
		if ((irany=="Függőleges")){
			for (int lerak=sor; lerak<sor+szo.length(); lerak++)
				tabla.setTable(lerak, oszlop, szo.charAt(lerak-sor));
			
		}
		

		if (firstStep) firstStep=false;	
	return poziciok;
}
 
 
}
