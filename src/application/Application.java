package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import service.GameService;
import service.PlayerService;
import service.ScoreService;

public class Application {
	private volatile static Application obj;
	static FileInputStream fstream ;
	static BufferedReader br;
	GameService gameService = GameService.getInstance();
  	PlayerService playerService = PlayerService.getInstance();
  	ScoreService scoreService = ScoreService.getInstance();
	
  	private Application() throws FileNotFoundException {
		fstream = new FileInputStream("src/input.txt");
    	br = new BufferedReader(new InputStreamReader(fstream));
    	gameService.createDeck();
	}
 
    public static Application getInstance() throws FileNotFoundException
    {
        if (obj == null)
        {
            synchronized (Application.class)
            {
 	                if (obj==null)
                    obj = new Application();
            }
        }
        return obj;
    }
  	
  	
  	
	private void shuffle() {
		gameService.shuffle();
	}
	
	private void addPlayer(String id) {
		playerService.addPlayer(id);
	}
	
	private void removePlayer(String id) {
		playerService.removePlayer(id);
	}

	private void showPlayerCards() {
		gameService.showPlayerCards();
	}
	
	private void showDeckCards() {
		gameService.showDeckCards();
		
	}
	
	private void startGame() {
		gameService.startGame();
	}
	
	private void winner() {
		gameService.getWinner();
		
	}
	

	
	
	 public void start() throws NumberFormatException, IOException
	    {
	    	String strLine;
			while ((strLine = br.readLine()) != null)   {
				System.out.println(strLine);
				strLine = strLine.replace("(", "");
				strLine = strLine.replace(")", " ");
				String[] data = strLine.split(" |  ");
				
				if(data.length==2&&data[0].equals("ADDPLAYER")){
					addPlayer(data[1]);
				}
				if(data.length==2&&data[0].equals("REMOVEPLAYER")){
					removePlayer(data[1]);
				}
				
				if(data[0].equals("SHUFFLE"))
				{
					shuffle();
				}
				if(data[0].equals("STARTGAME"))
				{
					startGame();	
				}
				if(data[0].equals("PLAYERCARDS"))
				{
					showPlayerCards();
				}
				if(data[0].equals("WINNER"))
				{
					winner();
				}
				if(data[0].equals("DECKCARDS"))
				{
					showDeckCards();	
				}
				
			}}


}
