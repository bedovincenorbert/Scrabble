package hu.norbi.controller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "games")
public class Data {
private List<GameData> Game;
@XmlElement(name = "game")

public List<GameData> getGame() {
	return Game;
}

public void setGame(List<GameData> game) {
	Game = game;
}






}
