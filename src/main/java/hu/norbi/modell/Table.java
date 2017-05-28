package hu.norbi.modell;

public class Table {

	
	private int sor, oszlop;
	private char[][] table;


	public int getSor() {
		return sor;
	}
	public void setSor(int sor) {
		this.sor = sor;
	}
	public int getOszlop() {
		return oszlop;
	}
	public void setOszlop(int oszlop) {
		this.oszlop = oszlop;
	}
	public Table(int sor, int oszlop) {
		super();
		
		this.sor = sor;
		this.oszlop = oszlop;
		table=new char[sor][oszlop];	
		
	}
	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}
	public char getTable(int x, int y) {
		return table[x][y];
	}
	public void setTable(int i, int j, Character betu) {
		this.table[i][j]= betu;
	} 
	
	
	
}
