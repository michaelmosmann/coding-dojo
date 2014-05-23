package codingdojo;

import java.util.Collections;
import java.util.List;

import codingdojo.Card.Farbe;

public class PokerHand {

	private final List<Card> cards;

	public PokerHand(List<Card> cards) {
		super();
		Collections.sort(cards);
		this.cards = cards;
	}

	public List<Card> getCards() {
		return cards;
	}

	public boolean isFlush() {
		Farbe farbe = null;
		for (Card card : cards) {
			if (farbe == null) {
				farbe = card.getFarbe();
			} else if (card.getFarbe() != farbe) {
				return false;
			}
		}

		return true;
	}

	public boolean isStreet() {

		int ordinal = -1;
		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			if (ordinal < 0) {
				ordinal = card.getWert().ordinal();
			} else if (card.getWert().ordinal() != ordinal + i) {
				return false;
			}
		}

		return true;
	}
	
	public boolean isStraightFlush() {
		return isStreet() && isFlush();
	}
	
	public boolean isPair() {
		Card[] cards = getCards().toArray(new Card[this.cards.size()]);
		for (int i = 0; i < cards.length - 1; i++) {
			Card card = cards[i];
			for (int j = i+1; j < cards.length; j++) {
				Card card2 = cards[j];
				if (card.getWert() == card2.getWert()) {
					return true;
				}
			}
		}
		return false;
	}
	
}
