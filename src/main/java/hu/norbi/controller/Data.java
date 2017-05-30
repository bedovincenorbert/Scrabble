package hu.norbi.controller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * Az összes játék adatát reprezentáló osztály, amely {@link GameData} -t tartalmaz.
 * 
 * @author bedonorbert
 *
 */
@XmlRootElement(name = "games")
public class Data {
private List<GameData> Game;
/**
 * Visszaadja a játékok adatait taratalmazó listát.
 * 
 * @return A játékok adatai.
 */
@XmlElement(name = "game")
public List<GameData> getGame() {
	return Game;
}

/**
 * 
 * Beállítja egy játék adatait.
 * 
 * @param game egy lista, mely a játék adatait tartalmazza.
 */
public void setGame(List<GameData> game) {
	Game = game;
}



}
