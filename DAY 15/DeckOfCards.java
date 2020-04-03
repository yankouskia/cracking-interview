import java.util.LinkedList;
import java.util.Random;

// We will just use basic case for black jack with 52 cards

public class DeckOfCards {
  public static void main(String[] args){
    Deck deck = new Deck();

    Card card1 = deck.take();
    System.out.printf("Card %s %s (%d points) has been taken\n", card1.getMeaning(), card1.getSuit(), card1.getValue());

    Card card2 = deck.take();
    System.out.printf("Card %s %s (%d points) has been taken\n", card2.getMeaning(), card2.getSuit(), card2.getValue());

    System.out.printf("The size of deck is: %d\n", deck.getSize());

    deck.shuffle();

    Card card3 = deck.take();
    System.out.printf("Card %s %s (%d points) has been taken\n", card3.getMeaning(), card3.getSuit(), card3.getValue());

    Card card4 = deck.take();
    System.out.printf("Card %s %s (%d points) has been taken\n", card4.getMeaning(), card4.getSuit(), card4.getValue());

    deck.put(card1);
    deck.put(card2);
    deck.put(card3);
    deck.put(card4);
    deck.shuffle();

    System.out.println("All cards are added back and shuffled");
    System.out.printf("The size of deck is: %d\n", deck.getSize());

    Card card5 = deck.take();
    System.out.printf("Card %s %s (%d points) has been taken\n", card5.getMeaning(), card5.getSuit(), card5.getValue());

    /*
      Card NINE HEARTS (9 points) has been taken
      Card JACKET HEARTS (10 points) has been taken
      The size of deck is: 50
      Card KING SPADES (10 points) has been taken
      Card JACKET DIAMONDS (10 points) has been taken
      All cards are added back and shuffled
      The size of deck is: 52
      Card ACE SPADES (11 points) has been taken
    */
  }
}

class Deck {
  private static int CARDS_COUNT = 52;
  private LinkedList<Card> cards = new LinkedList<Card>();

  private void init() {
    for (Meaning meaning: Meaning.values()) {
      for (Suit suit: Suit.values()) {
        this.cards.push(new Card(meaning, suit));
      }
    }
  }

  public Deck() {
    this.init();
    this.shuffle();
  }

  public void shuffle() {
    Random random = new Random();
    int count = random.nextInt(this.getSize() * 1000);

    for (int i = 0; i < count; i++) {
      int removeIndex = random.nextInt(this.getSize() - 1);
      int addIndex = random.nextInt(this.getSize() - 2);

      Card card = this.cards.remove(removeIndex);
      this.cards.add(addIndex, card);
    }
  }

  public Card take() {
    return this.cards.pop();
  }

  public void put(Card card) {
    this.cards.addFirst(card);
  }

  public int getSize() {
    return this.cards.size();
  }
}

enum Meaning {
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  EIGHT(8),
  NINE(9),
  TEN(10),
  JACKET(10),
  QUEEN(10),
  KING(10),
  ACE(11);

  public final Integer value;

  private Meaning(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}

enum Suit {
  HEARTS,
  CLUBS,
  DIAMONDS,
  SPADES,
}

class Card {
  private Meaning meaning;
  private Suit suit;

  public Card(Meaning meaning, Suit suit) {
    this.meaning = meaning;
    this.suit = suit;
  }

  public Suit getSuit() {
    return this.suit;
  }

  public Meaning getMeaning() {
    return this.meaning;
  }

  public Integer getValue() {
    return this.meaning.getValue();
  }
}
