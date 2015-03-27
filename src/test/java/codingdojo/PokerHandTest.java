package codingdojo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import codingdojo.Card.Farbe;
import codingdojo.Card.Wert;

import com.google.common.collect.ImmutableList;

public class PokerHandTest {

	private PokerHandComparator testee;

	@Test
	public void testIsStreetShouldBeTrue() {
		setUp();
		Card card1 = new Card(Farbe.HERZ, Wert.ZWEI);
		Card card2 = new Card(Farbe.HERZ, Wert.DREI);
		PokerHand hand = new PokerHand(createCards(card1, card2, new Card(
				Farbe.HERZ, Wert.VIER), new Card(Farbe.HERZ, Wert.FÜNF),
				new Card(Farbe.HERZ, Wert.SECHS)));

		assertTrue(hand.isStreet());
	}

	@Test
	public void testIsFlushShouldBeTrue() {
		setUp();
		Card card1 = new Card(Farbe.HERZ, Wert.ZWEI);
		Card card2 = new Card(Farbe.HERZ, Wert.DREI);
		PokerHand hand = new PokerHand(createCards(card1, card2, new Card(
				Farbe.HERZ, Wert.VIER), new Card(Farbe.HERZ, Wert.FÜNF),
				new Card(Farbe.HERZ, Wert.SECHS)));

		assertTrue(hand.isFlush());
	}

	private List<Card> createCards(Card... cards) {

		return Arrays.asList(cards);
	}

	@Test
	@Ignore("Ich verstehe den Test nicht!")
	public void testIsBetter() {
		PokerHand hand = new PokerHand(createCards(new Card(Farbe.HERZ,
				Wert.ZWEI), new Card(Farbe.HERZ, Wert.DREI), new Card(
				Farbe.HERZ, Wert.VIER), new Card(Farbe.HERZ, Wert.FÜNF),
				new Card(Farbe.HERZ, Wert.SECHS)));
		PokerHand hand2 = new PokerHand(createCards(new Card(Farbe.KARO,
				Wert.ZWEI), new Card(Farbe.KARO, Wert.DREI), new Card(
				Farbe.KARO, Wert.VIER), new Card(Farbe.KARO, Wert.FÜNF),
				new Card(Farbe.KARO, Wert.SECHS)));

		assertFalse(hand.isBetter(hand2));
		assertFalse(hand2.isBetter(hand));
	}

	@Test
	public void shouldVerifyThatHandIsFourOfAKind() {
		PokerHand hand = new PokerHand(createCards(new Card(Farbe.HERZ,
				Wert.ZWEI), new Card(Farbe.KARO, Wert.ZWEI), new Card(
				Farbe.HERZ, Wert.VIER), new Card(Farbe.KREUZ, Wert.ZWEI),
				new Card(Farbe.PIK, Wert.ZWEI)));

		assertTrue(hand.isFourOfAKind());
	}

	@Ignore("Hier sind noch andere Dinge ungeklärt")
	@Test
	public void isDecoupledFromInputParamters() {
		List<Card> cards = createCards(new Card(Farbe.HERZ, Wert.ZWEI),
				new Card(Farbe.KARO, Wert.ZWEI),
				new Card(Farbe.HERZ, Wert.VIER), new Card(Farbe.KREUZ,
						Wert.ZWEI), new Card(Farbe.PIK, Wert.ZWEI));

		PokerHand hand = new PokerHand(cards);

		cards = createCards(new Card(Farbe.HERZ, Wert.ZWEI), new Card(
				Farbe.KARO, Wert.ZWEI), new Card(Farbe.HERZ, Wert.VIER),
				new Card(Farbe.KREUZ, Wert.KOENIG), new Card(Farbe.PIK,
						Wert.ZWEI));
		PokerHand other = new PokerHand(cards);

		assertFalse(hand.isEqualTo(other));
	}

	@Before
	public void setUp() {
		testee = new PokerHandComparator();
	}

	@Test
	public void twoCardsOfSameValueIsPair() {
		ImmutableList<Card> cards = ImmutableList.<Card> builder()
				.add(new Card(Farbe.HERZ, Wert.ZWEI))
				.add(new Card(Farbe.KARO, Wert.ZWEI))
				.add(new Card(Farbe.PIK, Wert.ACHT))
				.add(new Card(Farbe.PIK, Wert.AS))
				.add(new Card(Farbe.PIK, Wert.KOENIG)).build();

		PokerHand hand = new PokerHand(cards);
		assertTrue(hand.isPair());
	}

	@Test
	public void moreThan2CardsOfSameValueIsNotPair() {
		ImmutableList<Card> cards = ImmutableList.<Card> builder()
				.add(new Card(Farbe.HERZ, Wert.ZWEI))
				.add(new Card(Farbe.KARO, Wert.ZWEI))
				.add(new Card(Farbe.PIK, Wert.ZWEI))
				.add(new Card(Farbe.PIK, Wert.AS))
				.add(new Card(Farbe.PIK, Wert.KOENIG)).build();

		PokerHand hand = new PokerHand(cards);
		assertFalse(hand.isPair());
	}

	@Test
	public void threeCardsOfSameValueIsThreeOfAKind() {
		ImmutableList<Card> cards = ImmutableList.<Card> builder()
				.add(new Card(Farbe.HERZ, Wert.ZWEI))
				.add(new Card(Farbe.KARO, Wert.ZWEI))
				.add(new Card(Farbe.PIK, Wert.ZWEI))
				.add(new Card(Farbe.PIK, Wert.AS))
				.add(new Card(Farbe.PIK, Wert.KOENIG)).build();

		PokerHand hand = new PokerHand(cards);
		assertTrue(hand.isThreeOfAKind());
	}

	@Test
	public void moreThan3CardsOfSameValueIsNotThreeOfAKind() {
		ImmutableList<Card> cards = ImmutableList.<Card> builder()
				.add(new Card(Farbe.HERZ, Wert.ZWEI))
				.add(new Card(Farbe.KARO, Wert.ZWEI))
				.add(new Card(Farbe.KREUZ, Wert.ZWEI))
				.add(new Card(Farbe.PIK, Wert.ZWEI))
				.add(new Card(Farbe.PIK, Wert.KOENIG)).build();

		PokerHand hand = new PokerHand(cards);
		assertFalse(hand.isThreeOfAKind());
	}

	@Test
	public void twoPairsIsTwoOfAPair() {
		ImmutableList<Card> cards = ImmutableList.<Card> builder()
				.add(new Card(Farbe.HERZ, Wert.ZWEI))
				.add(new Card(Farbe.KARO, Wert.ZWEI))
				.add(new Card(Farbe.PIK, Wert.AS))
				.add(new Card(Farbe.KREUZ, Wert.AS))
				.add(new Card(Farbe.PIK, Wert.KOENIG)).build();

		PokerHand hand = new PokerHand(cards);
		assertTrue(hand.isTwoPair());
	}

	@Test
	public void fourOfSameValueIsNotTwoPair() {
		ImmutableList<Card> cards = ImmutableList.<Card> builder()
				.add(new Card(Farbe.HERZ, Wert.ZWEI))
				.add(new Card(Farbe.KARO, Wert.ZWEI))
				.add(new Card(Farbe.PIK, Wert.ZWEI))
				.add(new Card(Farbe.KREUZ, Wert.ZWEI))
				.add(new Card(Farbe.PIK, Wert.KOENIG)).build();

		PokerHand hand = new PokerHand(cards);
		assertFalse(hand.isTwoPair());
	}
}
