package hu.norbi.controller;

import java.util.ArrayList;
import java.util.List;

import hu.norbi.modell.Table;

public class Vizsgalat {
 public Table tabla;
 private String szo;
 private int pontszam;
 public List<Integer> poziciok = new ArrayList<Integer>();
 
 public Vizsgalat(Table tabla){
	this.tabla=tabla;
 }
 
 public Vizsgalat(){
	this.tabla=tabla;
 }
 
public String getSzo() {
	return szo;
}
public void setSzo(String szo) {
	this.szo = szo;
	
	
}

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


public  List<Integer> vizsgal ( String szo, List<Character> betukeszlet, int sor, int oszlop, String irany){
	poziciok.removeAll(poziciok);

Character temp;
String szavam="";
if ((irany=="Vizszintes")){
	for (int lerak=oszlop; lerak<oszlop+szo.length(); lerak++){
		temp=tabla.getTable(lerak, oszlop);
		if(!(temp>='A'&&temp<='Z'))  szavam=szavam+szo.substring(lerak-oszlop, lerak-oszlop+1);
		else {
			if(temp!=szo.charAt(lerak-oszlop)) return poziciok;
		}
	}
		
	
}

if ((irany=="Függőleges")){
	for (int lerak=sor; lerak<sor+szo.length(); lerak++){
		temp=tabla.getTable(lerak, oszlop);
		if(!(temp>='A'&&temp<='Z'))  szavam=szavam+szo.substring(lerak-sor, lerak-sor+1);
		else {
			if(temp!=szo.charAt(lerak-sor)) return poziciok;
		}
	}
		
	
}

	for ( int sz=0; sz<szavam.length(); sz++){
		System.out.println("valamiiii");
		for (int betuk=0; betuk<10;betuk++)
		{
			if ((szavam.charAt(sz)==betukeszlet.get(betuk))&&(!poziciok.contains(betuk))) {
				poziciok.add(betuk);
				break;
			}
			
		if (betuk==9) {
			System.out.println("Nem jók a betűk");
			return null;
		}
		
		}
		
	
	
	}
	
	
		if ((irany=="Vizszintes")){
			System.out.println("Vizszintes");
			for (int lerak=oszlop; lerak<oszlop+szo.length(); lerak++)
				tabla.setTable(sor,  lerak, szo.charAt(lerak-oszlop));
			
		}
		
		if ((irany=="Függőleges")){
			for (int lerak=sor; lerak<sor+szo.length(); lerak++)
				tabla.setTable(lerak, oszlop, szo.charAt(lerak-sor));
			
		}
		
	
		
	return poziciok;
}
 
 
}
