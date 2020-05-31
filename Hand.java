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
	
	public String toString(){
		String out = "";
		for(Card a : h){
			out = out + a.getRank() + ", " + a.getSuitValue() + "\n";
		}
		return out;
	}

	public void organizeHand(){
		Collections.sort(h);
	}

	//returns int representing value of the hand: 1 for high card, 9 for straight flush
	public int handValue (){
		if (isStraight() && isFlush()) {
			return 9;
		} else if (isFourOfKind()){
			return 8;
		} else if (isFullHouse()){
			return 7;
		} else if (isFlush()){
			return 6;
		} else if (isStraight()){
			return 5;
		} else if (isTriple()){
			return 4;
		} else if (isTwoPair()){
			return 3;
		} else if (isOnePair()){
			return 2;
		} else { //high card
			return 1;
		}
	}

	public boolean isStraight(){
		this.organizeHand();
		if (h.get(0).getRankValue() == 14 && h.get(1).getRankValue() == 2 && h.get(2).getRankValue() == 3 && h.get(3).getRankValue() == 4 && h.get(4).getRankValue() == 5) {
			return true;
		}
		if (h.get(4).getRankValue() < 5) {
			return false;
		}
		for (int i = 0; i < 4; i++) {
			if (!(h.get(i).getRankValue() + 1 == h.get(i+1).getRankValue())) {
				return false;	
			}
		}
		return true;
	}

	public boolean isFlush(){
		int first = h.get(0).getSuitValue();
		for (Card c : h) {
			if (c.getSuitValue() != first) {
				return false;
			}
		}
		return true;
	}

	public boolean isFourOfKind(){
		int firstVal = h.get(0).getRankValue();
		int secondVal = h.get(1).getRankValue();
		boolean flag = true;
		//check first four
		for (int i = 1; i < 3; i++) {
			if (h.get(i).getRankValue() != firstVal) {
				flag = false;
				break;
			}
		}
		//check second four if first four weren't same
		if (flag == false) {
			for (int i = 2; i < 4; i++) {
				if (h.get(i).getRankValue() != secondVal) {
					return false;
				}
			}
			return true;
		}
		return flag;
	}

	//returns True hand wins, False if other hand wins
	public boolean versus(Hand other){
		if(this.handValue() > other.handValue()){
			return true;
		} else if (this.handValue() < other.handValue()){
			return false;
		} else {
			/*
			have to deal with kicker
			*/
		}
	}
}
