package codingdojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.google.common.collect.ImmutableList;

public class Card implements Comparable<Card> {
	public static enum Farbe {
		HERZ, PIK, KREUZ, KARO
	}

	public static enum Wert {
		ZWEI(2), DREI(3), VIER(4), FÜNF(5), SECHS(6), SIEBEN(7), ACHT(8), NEUN(9), ZEHN(10),
		BUBE(11), DAME, KOENIG, AS
	}

	private final Farbe farbe;

	private final Wert wert;

	public Card(Farbe farbe, Wert wert) {
		super();
		this.farbe = farbe;
		this.wert = wert;
	}

	public Farbe getFarbe() {
		return farbe;
	}

	public Wert getWert() {
		return wert;
	}

	@Override
	public int compareTo(Card o) {
		return getWert().compareTo(o.getWert());
	}
	
	public static ImmutableList<Card> sorted(Collection<Card> src) {
		ArrayList<Card> copy = new ArrayList<Card>(src);
		Collections.sort(copy);
		return ImmutableList.copyOf(copy);
	}
}
