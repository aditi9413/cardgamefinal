package dao;

import db.DB;
import model.Card;
import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameDAO {
	
private volatile static GameDAO obj;
	
	private GameDAO()  {

	}

	public static GameDAO getInstance() 
	{
		if (obj == null)
		{
			synchronized (GameDAO.class)
			{
				if (obj==null)
					obj = new GameDAO();
			}
		}
		return obj;
	}

	public void addPlayer(Player player) {
		DB.playerMap.put(player.getId(), player);
	}

	public void removePlayer(String id) {
		DB.playerMap.remove(id);	
	}

	public List<Player> getAllPlayers() {
		return new ArrayList<>(DB.playerMap.values());
		
	}

	public List<Card> getDeck() {
		return DB.deck;
	}

	public void setDeck(List<Card> cards) {
		DB.deck = cards;
		
	}

}
