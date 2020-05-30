import java.awt.*;
import java.util.*;
public class Hand{
	private ArrayList<Card> h = new ArrayList<Card>();
	private Deck deck;
	//constructor
	public Hand(Deck d){
		deck = d;
	}

	public void prepareDeck(){
		deck.fillDeck();
		deck.shuffleDeck();
	}
	//draws 5 cards in hand
	public void draw(){
		for(int i =0; i < 5; i++){
			h.add(deck.drawCard());
		}
	}
	//adds hand back into the deck
	public void returnHand(){
		for(int i = 0; i < 5; i++){
			deck.backIntoDeck(h.remove(i));
		}
	}
	//swap function for five-card draw
	public void swapCards(Scanner console){
		int cardNum = console.nextInt();
		while(cardNum != 0){
			deck.backIntoDeck(h.get(cardNum-1));
			h.set(cardNum-1, deck.drawCard());
			cardNum = console.nextInt();
		}
		
	}
	//how each hand is printed
	public void printHand(DrawingPanel dp, Graphics g){		
		for(int i = 2; i < 7; i++){	
			String num = "" + (i-1);
			String rank = h.get(i-2).getRank();
			String suit = h.get(i-2).getSuit();
			g.setColor(Color.black);
			g.drawString(num, 40+100*(i-2),595);
			g.drawRect(100*(i-2), 600, 90, 150);
			String cardstring = "" + rank +" " + suit;
			if(suit.equals("♦") || suit.equals("♥")){
				g.setColor(Color.red);
			}
			else{
				g.setColor(Color.black);
			}
			g.drawString(cardstring, 100*(i-1)-45,615);
		}
	}
}