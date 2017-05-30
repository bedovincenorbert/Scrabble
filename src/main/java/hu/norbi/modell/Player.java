package hu.norbi.modell;


/**
 * Egy játékost megvalósító osztály, mely tartalmazza a játékos nevét, pontját, betűit ({@link Letters}).
 * 
 * @author bedonorbert
 *
 */
public class Player {
	private String name;
	private int points;
   private Letters betu;
   
	/**
	 * 
	 * Alapértelmezett konstruktor, mely beállítja egy játékos pontját nullára, és legenerálja a játékos betűit({@link Letters}).
	 * 
	 */
	public Player(){
		points=0;
		 betu= new Letters();
		
	}

	
	
	/**
	 * Visszaadja egy játékos betűit({@link Letters}).
	 * 
	 * @return Egy játékos betűit tartalmazó listát ad vissza.
	 */
	public Letters getBetu() {
		return betu;
	}




	/**
	 * Visszaadja egy játékos pontját.
	 * 
	 * @return Egy játékos pontja.
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Beállítja egy játékos pontját.
	 * 
	 * @param points a játékos pontja.
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Egy játékos nevét adja vissza.
	 * 
	 * @return Egy játékos nevét tartalmazó string.
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * Egy játékos nevét állítja be.
	 * 
	 * @param name a játékos neve.
	 */
	public void setName(String name) {
		this.name = name;
	}
   

}