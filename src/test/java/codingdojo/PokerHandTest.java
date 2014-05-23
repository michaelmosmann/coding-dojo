package codingdojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import codingdojo.Card.Farbe;
import codingdojo.Card.Wert;

public class PokerHandTest {

	private PokerHandComparator testee;

	@Test
	public void testIsStreetShouldBeTrue() {
		setUp();
		Card card1 = new Card(Farbe.HERZ, Wert.ZWEI);
		Card card2 = new Card(Farbe.HERZ, Wert.DREI);
		PokerHand hand = new PokerHand(createCards(card1, card2, new Card(Farbe.HERZ, Wert.VIER), new Card(Farbe.HERZ, Wert.FÜNF), new Card(Farbe.HERZ, Wert.SECHS)));
		
		assertTrue(hand.isStreet());
	}
	
	@Test
	public void testIsFlushShouldBeTrue() {
		setUp();
		Card card1 = new Card(Farbe.HERZ, Wert.ZWEI);
		Card card2 = new Card(Farbe.HERZ, Wert.DREI);
		PokerHand hand = new PokerHand(createCards(card1, card2, new Card(Farbe.HERZ, Wert.VIER), new Card(Farbe.HERZ, Wert.FÜNF), new Card(Farbe.HERZ, Wert.SECHS)));
		
		assertTrue(hand.isFlush());
	}

	private List<Card> createCards(Card... cards) {
		
		return Arrays.asList(cards);
	}

	@Before
	public void setUp() {
		testee = new PokerHandComparator();
	}

}
