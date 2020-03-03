package model;

import enums.CardSuit;
import enums.CardValue;

public class Card {

	public Card(CardValue cardValue, CardSuit cardSuit) {
		super();
		this.cardValue = cardValue;
		this.cardSuit = cardSuit;
	}
	@Override
	public String toString() {
		return "Card [cardValue=" + cardValue + ", cardSuit=" + cardSuit + "]";
	}
	private CardValue cardValue;
	public CardValue getCardValue() {
		return cardValue;
	}
	public void setCardValue(CardValue cardValue) {
		this.cardValue = cardValue;
	}
	public CardSuit getCardSuit() {
		return cardSuit;
	}
	public void setCardSuit(CardSuit cardSuit) {
		this.cardSuit = cardSuit;
	}
	private CardSuit cardSuit;
	
	
}
