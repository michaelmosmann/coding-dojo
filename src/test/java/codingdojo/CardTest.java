package codingdojo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import codingdojo.Card.Farbe;
import codingdojo.Card.Wert;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class CardTest {

	@Test
	public void twoIsOnFirstPlace() {
		ArrayList<Card> unsorted = Lists.newArrayList(new Card(Farbe.HERZ, Wert.ACHT), new Card(Farbe.HERZ, Wert.ZWEI));
		ImmutableList<Card> sorted = Card.sorted(unsorted);
		assertEquals(Wert.ZWEI, sorted.get(0).getWert());
	}
}
