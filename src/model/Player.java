package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	@Override
	public String toString() {
		return "Player [id=" + id + ", cards=" + cards + "]";
	}
	private String id;
	private List<Card> cards = new ArrayList<>();
	
	public Player(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	

}
