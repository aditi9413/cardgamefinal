package dao;


public class PlayerDAO {
	
private volatile static PlayerDAO obj;
	
	private PlayerDAO()  {

	}

	public static PlayerDAO getInstance() 
	{
		if (obj == null)
		{
			synchronized (PlayerDAO.class)
			{
				if (obj==null)
					obj = new PlayerDAO();
			}
		}
		return obj;
	}

}
