coding-dojo
===========

## Übung

- Es gibt 52 Karten, jede Karte hat eine Farbe (Herz, Karo, Piek, Kreuz) und einen Wert (7,8,9,10,Bube,Dame,König,Ass)
- Eine Pokerhand hat 5 Karten aus diesen 52 Karten (http://de.wikipedia.org/wiki/Poker - Five Card Draw)
- Vergleiche zwei Pokerhänder und ermittle den Gewinner.

### Ranking

Die Reihenfolge ist aufsteigend, je weiter unten der Aufzählung, desto höher der Wert:

- **High Card**: die höchste Karte gewinnt
- **Pair**: zwei von einem Wert, das höchste Paar gewinnt
- **Two Pairs**: zwei Paare, Regeln wir bei Pair und High Card
- **Three of Kind**: drei Karten des selben Wertes
- **Straight**: fünf Karten in Reihenfolge der Werte mit unterschiedlichen Farben
- **Flush**: Fünf Karten der selben Farbe
- **FullHouse**: die Summe aus Pair und Three of Kind
- **Four of a kind**: wie Three of Kind, nur mit 4 Karten
- **Straight**: wie Straight nur alle von der selben Farbe

Bei Gleichheit entscheidet immer der höchste Wert.

## Erweiterung

Wenn das alles zu einfach wird, können wir gerne auf andere Pokerspielarten zurückgreifen.
