package service;

import dao.GameDAO;
import dao.PlayerDAO;
import model.Player;

public class PlayerService {
	
	GameDAO gameDAO =GameDAO.getInstance();
	PlayerDAO playerDAO =PlayerDAO.getInstance();
	private volatile static PlayerService obj;
	
	private PlayerService()  {

	}

	public static PlayerService getInstance() 
	{
		if (obj == null)
		{
			synchronized (PlayerService.class)
			{
				if (obj==null)
					obj = new PlayerService();
			}
		}
		return obj;
	}

	public void addPlayer(String id) {
		Player player = new Player(id);
		gameDAO.addPlayer(player);
	}

	public void removePlayer(String id) {
		gameDAO.removePlayer(id);
	}


}
