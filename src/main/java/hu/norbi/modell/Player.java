package hu.norbi.modell;

public class Player {
	private String name;
	private int points;
   private Letters betu;
	public Player(){
		points=0;
		 betu= new Letters();
		
	}

	
	
	public Letters getBetu() {
		return betu;
	}



	public void setBetu(Letters betu) {
		this.betu = betu;
	}



	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   

}
