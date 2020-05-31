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
	public void swapCards(int cardNum){
		deck.backIntoDeck(h.get(cardNum-1));
		deck.shuffleDeck();
		h.set(cardNum-1, deck.drawCard());
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
		} else if (isTriple()){	 //number that is
			return 4;
		} else if (isTwoPair()){ //number that is not
			return 3;
		} else if (isOnePair()){ //number that is 
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

	public int isDouble(){
		for(int i = 0; i<4; i++){
			if(h.get(i).getRankValue() == h.get(i+1).getRankValue()){
				return i;
			}
		}
		return -1;
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

	public int isAlmostStraight(){
		int reject = -1;
		int counter = 0;
		for(int i = 1; i < 6; i++){
			if(h.get(4).getRankValue() == 14 && i == 1){
				counter++;
			} 
			else if(h.get(i).getRankValue() == i){
				counter++;
			}
			else{
				reject = i;
			}
		}

		if(counter == 4){
			return reject;
		}

		for(int i = 2; i <=10 ; i++){
			int count = 0;
			for(int j = 0; j < 5; j++){
				if(h.get(j).getRankValue() == i+j){
					count++;
				}
				else{
					reject = j;
				}
			}
			if(count == 4){
				return reject;
			}
			else{
				return -1;
			}
		}
	}

	//used for close to full house or four of a kind
	public int moreThanTriple(){ 
		if(h.get(isTriple()).getRankValue() >= 0){
			int min = 4;
			for(int i = 0; i<5;i++){
				if(h.get(i).getRankValue() < h.get(min).getRankValue() && h.get(i).getRankValue() != h.get(isTriple()).getRankValue()){
					min = i;
				}
			}
			return min;

		}
		else{
			return -1;
		}
	}

	public ArrayList<Integer> almostFlush(){

		ArrayList<Integer> output = new ArrayList<Integer>();

		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		String holder = "";
		for(Card a : h){
			if(a.getSuitValue() == 1){
				count1++;
			}
			else if(a.getSuitValue() == 2){
				count2++;
			}
			else if(a.getSuitValue() == 3){
				count3++;
			}
			else if(a.getSuitValue() == 4){
				count4++;
			}
		}

		if(count1 <= 2 && count1 > 0){
			holder = holder + 1;
		}
		if(count2 <= 2 && count2 > 0){
			holder = holder + 2;
		}
		if(count3 <= 2 && count3 > 0){
			holder = holder + 3;
		}
		if(count4 <= 2 && count4 > 0){
			holder = holder + 4;
		}

		if(holder.length() > 2){
			return output;
		}

		for(int i = 0; i<5; i++){
			if(h.get(i).getSuitValue() == Character.getNumericValue(holder.charAt(0)) || h.get(i).getSuitValue() == Character.getNumericValue(holder.charAt(holder.length()-1))){
				output.add(i);
			}
		}

		return output;

	}

}
