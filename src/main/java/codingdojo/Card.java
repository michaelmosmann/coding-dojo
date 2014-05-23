package codingdojo;

public class Card implements Comparable<Card> {
	public static enum Farbe {
		HERZ, PIK, KREUZ, KARO
	}

	public static enum Wert {
		ZWEI, DREI, VIER, FÜNF, SECHS, SIEBEN, ACHT, NEUN, ZEHN, BUBE, DAME, KOENIG, AS
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
}
