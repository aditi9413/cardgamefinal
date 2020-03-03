package service;

import java.util.List;

import enums.CardSuit;
import enums.CardValue;
import model.Card;

public class ScoreService {
	
private volatile static ScoreService obj;
	
	private ScoreService()  {

	}

	public static ScoreService getInstance() 
	{
		if (obj == null)
		{
			synchronized (ScoreService.class)
			{
				if (obj==null)
					obj = new ScoreService();
			}
		}
		return obj;
	}

	public int getScore(List<Card> list) {
		if(sameCardValue(list)) {
			return 100;
		}
		if(sameCardSuit(list)) {
			return 99;
		}
		
		return highCard(list);
		
		
	}

	private int highCard(List<Card> list) {
		int highCard =0;
		for(Card card: list) {
			if(card.getCardValue().ordinal()> highCard)
				highCard = card.getCardValue().ordinal();
		}
		return highCard;
	}

	private boolean sameCardSuit(List<Card> list) {
		CardSuit cardSuit = list.get(0).getCardSuit();
		for(Card card: list) {
			if(cardSuit!=card.getCardSuit())
				return false;
		}
		return true;
	}

	private boolean sameCardValue(List<Card> list) {
		CardValue cardValue = list.get(0).getCardValue();
		for(Card card: list) {
			if(cardValue!=card.getCardValue())
				return false;
		}
		return true;
	}
	
	


}
