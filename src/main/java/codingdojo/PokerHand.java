package codingdojo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import codingdojo.Card.Farbe;
import codingdojo.Card.Wert;

public class PokerHand {

	public static enum PokerHandValue {
		HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH
	}

	private final List<Card> cards;
	private PokerHandValue pokerHandValue;

	public PokerHand(Collection<Card> cards) {
		super();

		if (cards == null || cards.size() != 5) {
			throw new IllegalArgumentException(
					"Bitte geben Sie genau 5 Karten an.");
		}

		this.cards = Card.sorted(cards);

		determinePokerHandValue();
	}

	private void determinePokerHandValue() {
		if (isRoyalFlush()) {
			pokerHandValue = PokerHandValue.ROYAL_FLUSH;
		} else if (isStraightFlush()) {
			pokerHandValue = PokerHandValue.STRAIGHT_FLUSH;
		} else if (isFourOfAKind()) {
			pokerHandValue = PokerHandValue.FOUR_OF_A_KIND;
		}
	}

	protected boolean isFourOfAKind() {
		return isTheSame(cards.get(0), cards.get(3))
				|| isTheSame(cards.get(1), cards.get(4));
	}

	private boolean isTheSame(Card first, Card second) {
		return first.getWert() == second.getWert();
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
		return calcValuesFrom(cards).size() == 4;
	}

	public boolean isTwoPair() {
		Map<Wert, Integer> calcValuesFrom = calcValuesFrom(cards);
		int numberOfPairs = 0;
		for (Integer value : calcValuesFrom.values()) {
			if (Integer.valueOf(2).equals(value)) {
				numberOfPairs++;
			}
		}

		return numberOfPairs == 2;
	}

	public int getValue(){
		int value = 0;
		if (isStraightFlush()){
			value += 9000;
			Card highestCard = cards.get(4);
			switch (highestCard.getWert()) {
			case AS:
				value += 14;
				break;
			case KOENIG:
				value += 13;
				break;
			case DAME:
				value += 12;
				break;
			case BUBE:
				value += 11;
				break;
			case ZEHN:
				value += 10;
				break;
			case ZEHN:
				value += 10;
				break;

			default:
				break;
			}
		}else if (isFourOfAKind()){
			value += 8000;
		} else if (isFullHouse()){
			value += 7000;
		}else if (isFlush()){
			value += 6000;
		}else if (isStraight()){
			value += 5000;
		}else if (isThreeOfAKind()){
			value += 4000;
		}else if (isTwoPair()){
			value += 3000;
		}else if (isPair()){
			value += 2000;
		}
		
		return value;
	}
	
	public boolean isThreeOfAKind() {
		Map<Wert, Integer> calcValuesFrom = calcValuesFrom(cards);
		for (Integer value : calcValuesFrom.values()) {
			if (Integer.valueOf(3).equals(value)) {
				return true;
			}
		}
		return false;
	}

	private Map<Wert, Integer> calcValuesFrom(List<Card> cards) {
		HashMap<Wert, Integer> mapWithValues = new HashMap<Wert, Integer>();

		for (Card card : cards) {
			Integer currentValue = mapWithValues.get(card.getWert());
			mapWithValues.put(card.getWert(),
					currentValue == null ? Integer.valueOf(1)
							: currentValue + 1);
		}

		return mapWithValues;
	}

	public boolean isBetter(PokerHand hand) {
		if (isRoyalFlush()) {
			return !hand.isRoyalFlush();
		} else if (isStraightFlush()) {
			// FIXME
			return true;
		}
		return false;
	}

	private boolean isRoyalFlush() {
		return isStraightFlush() && isHighCard(Wert.AS);
	}

	private boolean isHighCard(Wert card) {
		return cards.get(4).getWert() == card;
	}

	public boolean isEqualTo(PokerHand other) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i) != other.cards.get(i)) {
				return false;
			}
		}

		return true;
	}
}
