import java.awt.*;
import java.util.*;
public class Deck{
	public ArrayList<Card> deck = new ArrayList<Card>();
	//array for ranks and suits
	private String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private String[] suits = {"♣","♦","♥","♠"};

	//fills up the deck, remainder for rank, division for suit
	public void fillDeck(){
		for(int i = 0; i < 51; i++){
			String rank = ranks[i%13];
			String suit = suits[i/13];
			Card c = new Card(rank,suit);
			deck.add(c);
		}
	}
	//adds the card back in
	public void backIntoDeck(Card c){
		deck.add(c);
	}
	//draws top card on deck
	public Card drawCard(){
		Card c = deck.remove(0);
		return c;
	}
	//clears the deck
	public void clearDeck(){
		for(Card c: deck){
			deck.remove(c);
		}
	}
	//shuffle
	public void shuffleDeck(){
		Collections.shuffle(deck);
	}

}