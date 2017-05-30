package hu.norbi.controller;


/**
 * Egy játék adatait reprezentáló osztály.
 * 
 * @author bedonorbert
 *
 */
public class GameData {
	private String FirstPlayerName;
	private int FirstPlayerPoint;
	private String SecondPlayerName;
	private int SecondPlayerPoint;
	private String Table;
	
	/**
	 * Alapértelmezett konstruktor.
	 */
	public GameData(){
		
	}

	
	/**
	 * Visszadja az első {@link hu.norbi.modell.Player} nevét.
	 * 
	 * @return az első játékos neve.
	 */
	public String getFirstPlayerName() {
		return FirstPlayerName;
	}
    
	/**
	 * 
	 * Beállítja az első {@link hu.norbi.modell.Player} nevét.
	 * 
	 * @param firstPlayerName az első játékos neve.
	 */
	public void setFirstPlayerName(String firstPlayerName) {
		FirstPlayerName = firstPlayerName;
	}

	/**
	 * Visszaadja az első {@link hu.norbi.modell.Player} pontját.
	 * 
	 * @return az első játékos pontja.
	 */
	public int getFirstPlayerPoint() {
		return FirstPlayerPoint;
	}
	
	/**
	 * Beállítja az első {@link hu.norbi.modell.Player} pontját állítja.
	 * 
	 * @param firstPlayerPoint az első játékos pontja.
	 */
	public void setFirstPlayerPoint(int firstPlayerPoint) {
		FirstPlayerPoint = firstPlayerPoint;
	}

	/**
	 * Visszaadja a második {@link hu.norbi.modell.Player} pontját.
	 * 
	 * @return a második játékos pontja.
	 */
	public String getSecondPlayerName() {
		return SecondPlayerName;
	}
	
	/**
	 * Beállítja a második {@link hu.norbi.modell.Player} nevét.
	 * 
	 * @param secondPlayerName a második játékos neve.
	 */
	public void setSecondPlayerName(String secondPlayerName) {
		SecondPlayerName = secondPlayerName;
	}

	/**
	 * Visszaadja a második {@link hu.norbi.modell.Player} nevét.
	 * 
	 * @return a második játékos neve.
	 */
	public int getSecondPlayerPoint() {
		return SecondPlayerPoint;
	}

	/**
	 * Beállítja a második {@link hu.norbi.modell.Player} pontját.
	 * 
	 * @param secondPlayerPoint a második játékos pontja.
	 */
	public void setSecondPlayerPoint(int secondPlayerPoint) {
		SecondPlayerPoint = secondPlayerPoint;
	}

	/**
	 * Visszaada a {@link hu.norbi.modell.Table}-t betömörítve.
	 * 
	 * @return a tábla betömörítve.
	 */
	public String getTable() {
		return Table;
	}

	/**
	 * Beállítja a {@link hu.norbi.modell.Table}-t betömörítve.
	 * 
	 * @param table a tábla betömörítve.
	 */
	public void setTable(String table) {
		Table = table;
	}
	
	
}
