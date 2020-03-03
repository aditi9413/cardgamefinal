package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random; 
import dao.GameDAO;
import enums.CardSuit;
import enums.CardValue;
import model.Card;
import model.Player;

public class GameService {
	
private volatile static GameService obj;
	
	GameDAO gameDAO =GameDAO.getInstance();
	ScoreService scoreService = ScoreService.getInstance();
    Random rand = new Random(); 

	private GameService()  {
		

	}

	public static GameService getInstance() 
	{
		if (obj == null)
		{
			synchronized (GameService.class)
			{
				if (obj==null)
					obj = new GameService();
			}
		}
		return obj;
	}

	public void showPlayerCards() {
		for(Player player: gameDAO.getAllPlayers()) {
			System.out.println(player);
		}
	}

	public void showDeckCards() {
		System.out.println(gameDAO.getDeck());
	}

	public void startGame() {
		createDeck();
		createPlayerCards();
	}


	public void getWinner() {
		int max =0;
		String max_id = "";
		for(Player player: gameDAO.getAllPlayers()) {
			if(max < scoreService.getScore(player.getCards())){
				max = scoreService.getScore(player.getCards());
				max_id = player.getId();
			}
		}
		System.out.println("Winner "+ max_id);
	}

	public void shuffle() {
		Collections.shuffle(gameDAO.getDeck());
	}
	
	private void createPlayerCards() {
		int num = 52;
		int rand_num = 0;
		List<Card> deck = gameDAO.getDeck();
		for(Player player: gameDAO.getAllPlayers()) {
			List<Card> cards = new ArrayList<>();
			for(int i=0;i<2;i++) {
			rand_num = rand.nextInt(num--);
			cards.add(deck.get(rand_num));
			deck.remove(rand_num);
			}
			player.setCards(cards);
		}
		
	}

	public void createDeck() {
		List<Card> cards = new ArrayList<>();
		for(CardValue cardValue: CardValue.values()) {
			for(CardSuit cardSuit: CardSuit.values()) {
				cards.add(new Card(cardValue, cardSuit));
			}
		}	
		Collections.shuffle(cards);
		gameDAO.setDeck(cards);
		
	}

}
