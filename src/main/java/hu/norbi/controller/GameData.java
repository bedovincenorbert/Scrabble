package hu.norbi.controller;


public class GameData {
	private String FirstPlayerName;
	private int FirstPlayerPoint;
	private String SecondPlayerName;
	private int SecondPlayerPoint;
	private String Table;
	
	public GameData(){
		
	}
	public GameData(String firstPlayerName, int firstPlayerPoint, String secondPlayerName, int secondPlayerPoint,
			String table) {
		super();
		FirstPlayerName = firstPlayerName;
		FirstPlayerPoint = firstPlayerPoint;
		SecondPlayerName = secondPlayerName;
		SecondPlayerPoint = secondPlayerPoint;
		Table = table;
	}

	
	public String getFirstPlayerName() {
		return FirstPlayerName;
	}

	public void setFirstPlayerName(String firstPlayerName) {
		FirstPlayerName = firstPlayerName;
	}

	public int getFirstPlayerPoint() {
		return FirstPlayerPoint;
	}
	
	public void setFirstPlayerPoint(int firstPlayerPoint) {
		FirstPlayerPoint = firstPlayerPoint;
	}

	public String getSecondPlayerName() {
		return SecondPlayerName;
	}
	
	public void setSecondPlayerName(String secondPlayerName) {
		SecondPlayerName = secondPlayerName;
	}

	public int getSecondPlayerPoint() {
		return SecondPlayerPoint;
	}

	public void setSecondPlayerPoint(int secondPlayerPoint) {
		SecondPlayerPoint = secondPlayerPoint;
	}

	public String getTable() {
		return Table;
	}

	public void setTable(String table) {
		Table = table;
	}
	
	


	
	
	
	
}
