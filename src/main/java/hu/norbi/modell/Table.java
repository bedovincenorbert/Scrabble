package hu.norbi.modell;

/**
 * A játék tábláját megvalósító osztály.
 * 
 * @author bedonorbert
 *
 */
public class Table {

	
	private int sor, oszlop;
	private char[][] table;


	/**
	 * Konstuktor, mely létrehozza a játék tábláját.
	 * @param sor a tábla sorainak száma.
	 * @param oszlop a tábla oszlopainak a száma.
	 */
	public Table(int sor, int oszlop) {
		super();
		
		this.sor = sor;
		this.oszlop = oszlop;
		table=new char[sor][oszlop];	
		
	}

	/**
	 * Egy metódus, mely a {@link Table} egy elemét adja vissza.
	 * @param x a tábla sora.
	 * @param y a tábla oszlopa.
	 * @return egy elem.
	 */
	public char getTable(int x, int y) {
		return table[x][y];
	}
	
	/**
	 * Egy metódus, mely a {@link Table} egy elemét állítja be.
	 * @param i a táblzat sora.
	 * @param j a táblázat oszlopa.
	 * @param betu a beállítandó betű.
	 */
	public void setTable(int i, int j, Character betu) {
		this.table[i][j]= betu;
	} 

	/**
	 * Egy metódus, mely a  {@link Table}-t adja vissza betömörítve.
	 * @return a tábla betömröítve.
	 */
	public String tableSave(){
		String saved="";
		for(int i=0;i<sor; i++)
			for(int j=0;j<oszlop;j++)
			{
				if((table[i][j]>='A')&&(table[i][j]<='Z')){
					saved+=table[i][j]; 
				}
				else {
					saved+="n";
				}
			}
		return saved;
	}
	
	

	
}
