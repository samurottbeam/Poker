import java.awt.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.image.*;
public class Hand{
	public ArrayList<Card> h = new ArrayList<Card>();
	private Deck deck;
	private double handValue;

				//constructor for testing
				public Hand(Deck d, ArrayList<Card> h){
					this.deck = d;
					this.h = h;
					this.handValue = this.handValue();
				}


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
		this.organizeHand();
	}
	//adds hand back into the deck
	public void returnHand(){
		for(int i = 0; i < 5; i++){
			deck.backIntoDeck(h.remove(0));
		}
	}

	//swap function for five-card draw
	public void swapCards(int cardNum){
		deck.backIntoDeck(h.get(cardNum-1));
		h.set(cardNum-1, deck.drawCard());
	}


	//how each hand is printed
	public void printHand(DrawingPanel dp, Graphics g) throws IOException{		
		for(int i = 2; i < 7; i++){	
			String num = "" + (i-1);
			String rank = h.get(i-2).getRank();
			String suit = h.get(i-2).getSuit();
			g.setColor(Color.black);
			BufferedImage img = null;
			if(rank == "A" && suit == "\u2663"){
				img = ImageIO.read(new File("AC.png"));
			}
			if(rank == "A" && suit == "\u2666"){
				img = ImageIO.read(new File("AD.png"));
			}
			if(rank == "A" && suit == "\u2665"){
				img = ImageIO.read(new File("AH.png"));
			}
			if(rank == "A" && suit == "\u2660"){
				img = ImageIO.read(new File("AS.png"));
			}
			if(rank == "2" && suit == "\u2663"){
				img = ImageIO.read(new File("2C.png"));
			}
			if(rank == "2" && suit == "\u2666"){
				img = ImageIO.read(new File("2D.png"));
			}
			if(rank == "2" && suit == "\u2665"){
				img = ImageIO.read(new File("2H.png"));
			}
			if(rank == "2" && suit == "\u2660"){
				img = ImageIO.read(new File("2S.png"));
			}
			if(rank == "3" && suit == "\u2663"){
				img = ImageIO.read(new File("3C.png"));
			}
			if(rank == "3" && suit == "\u2666"){
				img = ImageIO.read(new File("3D.png"));
			}
			if(rank == "3" && suit == "\u2665"){
				img = ImageIO.read(new File("3H.png"));
			}
			if(rank == "3" && suit == "\u2660"){
				img = ImageIO.read(new File("3S.png"));
			}
			if(rank == "4" && suit == "\u2663"){
				img = ImageIO.read(new File("4C.png"));
			}
			if(rank == "4" && suit == "\u2666"){
				img = ImageIO.read(new File("4D.png"));
			}
			if(rank == "4" && suit == "\u2665"){
				img = ImageIO.read(new File("4H.png"));
			}
			if(rank == "4" && suit == "\u2660"){
				img = ImageIO.read(new File("4S.png"));
			}
			if(rank == "5" && suit == "\u2663"){
				img = ImageIO.read(new File("5C.png"));
			}
			if(rank == "5" && suit == "\u2666"){
				img = ImageIO.read(new File("5D.png"));
			}
			if(rank == "5" && suit == "\u2665"){
				img = ImageIO.read(new File("5H.png"));
			}
			if(rank == "5" && suit == "\u2660"){
				img = ImageIO.read(new File("5S.png"));
			}
			if(rank == "6" && suit == "\u2663"){
				img = ImageIO.read(new File("6C.png"));
			}
			if(rank == "6" && suit == "\u2666"){
				img = ImageIO.read(new File("6D.png"));
			}
			if(rank == "6" && suit == "\u2665"){
				img = ImageIO.read(new File("6H.png"));
			}
			if(rank == "6" && suit == "\u2660"){
				img = ImageIO.read(new File("6S.png"));
			}
			if(rank == "7" && suit == "\u2663"){
				img = ImageIO.read(new File("7C.png"));
			}
			if(rank == "7" && suit == "\u2666"){
				img = ImageIO.read(new File("7D.png"));
			}
			if(rank == "7" && suit == "\u2665"){
				img = ImageIO.read(new File("7H.png"));
			}
			if(rank == "7" && suit == "\u2660"){
				img = ImageIO.read(new File("7S.png"));
			}
			if(rank == "8" && suit == "\u2663"){
				img = ImageIO.read(new File("8C.png"));
			}
			if(rank == "8" && suit == "\u2666"){
				img = ImageIO.read(new File("8D.png"));
			}
			if(rank == "8" && suit == "\u2665"){
				img = ImageIO.read(new File("8H.png"));
			}
			if(rank == "8" && suit == "\u2660"){
				img = ImageIO.read(new File("8S.png"));
			}
			if(rank == "9" && suit == "\u2663"){
				img = ImageIO.read(new File("9C.png"));
			}	
			if(rank == "9" && suit == "\u2666"){
				img = ImageIO.read(new File("9D.png"));
			}
			if(rank == "9" && suit == "\u2665"){
				img = ImageIO.read(new File("9H.png"));
			}
			if(rank == "9" && suit == "\u2660"){
				img = ImageIO.read(new File("9S.png"));
			}
			if(rank == "10" && suit == "\u2663"){
				img = ImageIO.read(new File("10C.png"));
			}
			if(rank == "10" && suit == "\u2666"){
				img = ImageIO.read(new File("10D.png"));
			}
			if(rank == "10" && suit == "\u2665"){
				img = ImageIO.read(new File("10H.png"));
			}
			if(rank == "10" && suit == "\u2660"){
				img = ImageIO.read(new File("10S.png"));
			}
			if(rank == "J" && suit == "\u2663"){
				img = ImageIO.read(new File("JC.png"));
			}
			if(rank == "J" && suit == "\u2666"){
				img = ImageIO.read(new File("JD.png"));
			}
			if(rank == "J" && suit == "\u2665"){
				img = ImageIO.read(new File("JH.png"));
			}
			if(rank == "J" && suit == "\u2660"){
				img = ImageIO.read(new File("JS.png"));
			}
			if(rank == "Q" && suit == "\u2663"){
				img = ImageIO.read(new File("QC.png"));
			}
			if(rank == "Q" && suit == "\u2666"){
				img = ImageIO.read(new File("QD.png"));
			}
			if(rank == "Q" && suit == "\u2665"){
				img = ImageIO.read(new File("QH.png"));
			}
			if(rank == "Q" && suit == "\u2660"){
				img = ImageIO.read(new File("QS.png"));
			}
			if(rank == "K" && suit == "\u2663"){
				img = ImageIO.read(new File("KC.png"));
			}
			if(rank == "K" && suit == "\u2666"){
				img = ImageIO.read(new File("KD.png"));
			}
			if(rank == "K" && suit == "\u2665"){
				img = ImageIO.read(new File("KH.png"));
			}
			if(rank == "K" && suit == "\u2660"){
				img = ImageIO.read(new File("KS.png"));
			}
			g.drawImage(img,100*(i-2) + 50, 600, 90, 150,null);
			// g.drawString(num, 40+100*(i-2),595);
			// g.drawRect(100*(i-2), 600, 90, 150);
			// String cardstring = "" + rank +" " + suit;
			// if(suit.equals("\u2666") || suit.equals("\u2665")){
			// 	g.setColor(Color.red);
			// }
			// else{
			// 	g.setColor(Color.black);
			// }
			// g.drawString(cardstring, 100*(i-1)-45,615);
		}
	}
	
	public void printWinCon(DrawingPanel dp, Graphics g, int playerNum) throws IOException{


		for(int i = 2; i < 7; i++){	
			String num = "" + (i-1);
			String rank = h.get(i-2).getRank();
			String suit = h.get(i-2).getSuit();
			BufferedImage img = null;
			if(rank == "A" && suit == "\u2663"){
				img = ImageIO.read(new File("AC.png"));
			}
			if(rank == "A" && suit == "\u2666"){
				img = ImageIO.read(new File("AD.png"));
			}
			if(rank == "A" && suit == "\u2665"){
				img = ImageIO.read(new File("AH.png"));
			}
			if(rank == "A" && suit == "\u2660"){
				img = ImageIO.read(new File("AS.png"));
			}
			if(rank == "2" && suit == "\u2663"){
				img = ImageIO.read(new File("2C.png"));
			}
			if(rank == "2" && suit == "\u2666"){
				img = ImageIO.read(new File("2D.png"));
			}
			if(rank == "2" && suit == "\u2665"){
				img = ImageIO.read(new File("2H.png"));
			}
			if(rank == "2" && suit == "\u2660"){
				img = ImageIO.read(new File("2S.png"));
			}
			if(rank == "3" && suit == "\u2663"){
				img = ImageIO.read(new File("3C.png"));
			}
			if(rank == "3" && suit == "\u2666"){
				img = ImageIO.read(new File("3D.png"));
			}
			if(rank == "3" && suit == "\u2665"){
				img = ImageIO.read(new File("3H.png"));
			}
			if(rank == "3" && suit == "\u2660"){
				img = ImageIO.read(new File("3S.png"));
			}
			if(rank == "4" && suit == "\u2663"){
				img = ImageIO.read(new File("4C.png"));
			}
			if(rank == "4" && suit == "\u2666"){
				img = ImageIO.read(new File("4D.png"));
			}
			if(rank == "4" && suit == "\u2665"){
				img = ImageIO.read(new File("4H.png"));
			}
			if(rank == "4" && suit == "\u2660"){
				img = ImageIO.read(new File("4S.png"));
			}
			if(rank == "5" && suit == "\u2663"){
				img = ImageIO.read(new File("5C.png"));
			}
			if(rank == "5" && suit == "\u2666"){
				img = ImageIO.read(new File("5D.png"));
			}
			if(rank == "5" && suit == "\u2665"){
				img = ImageIO.read(new File("5H.png"));
			}
			if(rank == "5" && suit == "\u2660"){
				img = ImageIO.read(new File("5S.png"));
			}
			if(rank == "6" && suit == "\u2663"){
				img = ImageIO.read(new File("6C.png"));
			}
			if(rank == "6" && suit == "\u2666"){
				img = ImageIO.read(new File("6D.png"));
			}
			if(rank == "6" && suit == "\u2665"){
				img = ImageIO.read(new File("6H.png"));
			}
			if(rank == "6" && suit == "\u2660"){
				img = ImageIO.read(new File("6S.png"));
			}
			if(rank == "7" && suit == "\u2663"){
				img = ImageIO.read(new File("7C.png"));
			}
			if(rank == "7" && suit == "\u2666"){
				img = ImageIO.read(new File("7D.png"));
			}
			if(rank == "7" && suit == "\u2665"){
				img = ImageIO.read(new File("7H.png"));
			}
			if(rank == "7" && suit == "\u2660"){
				img = ImageIO.read(new File("7S.png"));
			}
			if(rank == "8" && suit == "\u2663"){
				img = ImageIO.read(new File("8C.png"));
			}
			if(rank == "8" && suit == "\u2666"){
				img = ImageIO.read(new File("8D.png"));
			}
			if(rank == "8" && suit == "\u2665"){
				img = ImageIO.read(new File("8H.png"));
			}
			if(rank == "8" && suit == "\u2660"){
				img = ImageIO.read(new File("8S.png"));
			}
			if(rank == "9" && suit == "\u2663"){
				img = ImageIO.read(new File("9C.png"));
			}	
			if(rank == "9" && suit == "\u2666"){
				img = ImageIO.read(new File("9D.png"));
			}
			if(rank == "9" && suit == "\u2665"){
				img = ImageIO.read(new File("9H.png"));
			}
			if(rank == "9" && suit == "\u2660"){
				img = ImageIO.read(new File("9S.png"));
			}
			if(rank == "10" && suit == "\u2663"){
				img = ImageIO.read(new File("10C.png"));
			}
			if(rank == "10" && suit == "\u2666"){
				img = ImageIO.read(new File("10D.png"));
			}
			if(rank == "10" && suit == "\u2665"){
				img = ImageIO.read(new File("10H.png"));
			}
			if(rank == "10" && suit == "\u2660"){
				img = ImageIO.read(new File("10S.png"));
			}
			if(rank == "J" && suit == "\u2663"){
				img = ImageIO.read(new File("JC.png"));
			}
			if(rank == "J" && suit == "\u2666"){
				img = ImageIO.read(new File("JD.png"));
			}
			if(rank == "J" && suit == "\u2665"){
				img = ImageIO.read(new File("JH.png"));
			}
			if(rank == "J" && suit == "\u2660"){
				img = ImageIO.read(new File("JS.png"));
			}
			if(rank == "Q" && suit == "\u2663"){
				img = ImageIO.read(new File("QC.png"));
			}
			if(rank == "Q" && suit == "\u2666"){
				img = ImageIO.read(new File("QD.png"));
			}
			if(rank == "Q" && suit == "\u2665"){
				img = ImageIO.read(new File("QH.png"));
			}
			if(rank == "Q" && suit == "\u2660"){
				img = ImageIO.read(new File("QS.png"));
			}
			if(rank == "K" && suit == "\u2663"){
				img = ImageIO.read(new File("KC.png"));
			}
			if(rank == "K" && suit == "\u2666"){
				img = ImageIO.read(new File("KD.png"));
			}
			if(rank == "K" && suit == "\u2665"){
				img = ImageIO.read(new File("KH.png"));
			}
			if(rank == "K" && suit == "\u2660"){
				img = ImageIO.read(new File("KS.png"));
			}
			g.drawImage(img,100*(i-2) + 50, 25+170*playerNum, 90, 150,null);
			// g.setColor(Color.black);
			// g.drawRect(100*(i-2), 25+170*playerNum, 90, 150);
			// String cardstring = "" + rank +" " + suit;
			// if(suit.equals("\u2666") || suit.equals("\u2665")){
			// 	g.setColor(Color.red);
			// }
			// else{
			// 	g.setColor(Color.black);
			// }

			// g.drawString(cardstring, 100*(i-1)-45,40+170*(playerNum));
		}	
	}

	public String toString(){
		String out = "";
		for(Card a : h){
			out = out + a.getSuitValue() + ", " + a.getRankValue() + "\n";
		}
		return out;
	}

	public void organizeHand(){
		Collections.sort(h);
	}

	//returns the string of the Name of the combination in the poker hand
	public String getCombo(){
		if((int)this.handValue() == 9){
			return "Straight Flush";
		}
		else if((int)this.handValue() == 8){
			return "Four of a Kind";
		}
		else if((int)this.handValue() == 7){
			return "Full House";
		}
		else if((int)this.handValue() == 6){
			return "Flush";
		}
		else if((int)this.handValue() == 5){
			return "Straight";
		}
		else if((int)this.handValue() == 4){
			return "Triple";
		}
		else if((int)this.handValue() == 3){
			return "Two Pairs";
		}
		else if((int)this.handValue() == 2){
			return "One Pair";
		}
		else{
			return "Absolute Garbage";
		}
	}

	//returns double representing value of the hand: 1 for high card, 9 for straight flush
	public double handValue(){
		this.organizeHand();

		if (isStraight() && isFlush()) {
			return 9 + 0.1*(0.1*h.get(4).getRankValue());
		} else if (isFourOfKind() > -1){
			return 8 + 0.1*(0.1*h.get(3).getRankValue() + 0.01*h.get(isFourOfKind()).getRankValue());
		} else if (isFullHouse()){
			return 7 + 0.1*(0.1*h.get(isTriple()).getRankValue() + 0.01*h.get(isExternalPair(h.get(isTriple()).getRankValue())).getRankValue());
		} else if (isFlush()){
			return 6 + 0.1*(0.1*h.get(4).getRankValue() + 0.01*h.get(3).getRankValue() + 0.001*h.get(2).getRankValue() + 0.0001*h.get(1).getRankValue() + 0.00001*h.get(0).getRankValue());
		} else if (isStraight()){
			return 5 + 0.1*(0.1*h.get(4).getRankValue());
		} else if (isTriple() > -1){	 //number that is
			int secondHighest = 0;
			int tripleNum = h.get(isTriple()).getRankValue();
			int min = h.get(moreThanTriple()).getRankValue();
			for (int i = 0; i < 5; i++) {
				if (h.get(i).getRankValue() != tripleNum && h.get(i).getRankValue() != min) {
					secondHighest = i;
					break;
				}
			}
			return 4 + 0.1*(0.1*tripleNum + 0.01*secondHighest + 0.001*min);
		} else if (isTwoPair() > -1){ //number that is not
			int otherCard = h.get(isTwoPair()).getRankValue();
			int higherRanking = Math.max(h.get(isOnePair()).getRankValue(), h.get(isExternalPair(h.get(isOnePair()).getRankValue())).getRankValue());
			int lowerRanking = Math.min(h.get(isOnePair()).getRankValue(), h.get(isExternalPair(h.get(isOnePair()).getRankValue())).getRankValue());
			return 3 + 0.1*(0.1*higherRanking + 0.01*lowerRanking + 0.001*otherCard);
		} else if (isOnePair() > -1){ //number that is 
			int pair = h.get(isOnePair()).getRankValue();
			ArrayList<Integer> otherThree = moreThanOnePair();
			Collections.sort(otherThree);
			int highest = otherThree.get(2);
			int medium = otherThree.get(1);
			int lowest = otherThree.get(0);
			return 2 + 0.1*(0.1*pair + 0.01*highest + 0.001*medium + 0.0001*lowest);
		} else { //high card
			return 1 + 0.1*(0.1*h.get(4).getRankValue() + 0.01*h.get(3).getRankValue() + 0.001*h.get(2).getRankValue() + 0.0001*h.get(1).getRankValue() + 0.00001*h.get(0).getRankValue());
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
	
	public void setHandValue(double value){
		this.handValue = value;
	}

	public double getHandValue(){
		return handValue;
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

	//returns index of card that is NOT in the quadruplet, or -1 if hand is not four of kind
	public int isFourOfKind(){
		if (h.get(0).getRankValue() == h.get(3).getRankValue()){
			return 4;
		} else if (h.get(1).getRankValue() == h.get(4).getRankValue()){
			return 0;
		} else {
			return -1;
		}

	}

	//returns the index of the first occurrence of the triplet
	public int isTriple(){
		this.organizeHand();
		if (h.get(0).getRankValue() == h.get(2).getRankValue()) {
			return 0;
		} else if (h.get(1).getRankValue() == h.get(3).getRankValue()){
			return 1;
		} else if (h.get(2).getRankValue() == h.get(4).getRankValue()){
			return 2;
		} else {
			return -1;
		}
	}
	
	//returns the index of the first occurance of the pair
	public int isOnePair(){
		for(int i = 0; i<4; i++){
			if(h.get(i).getRankValue() == h.get(i+1).getRankValue()){
				return i;
			}
		}
		return -1;
	}

	//returns index of external pair
	public int isExternalPair(int removed){
		for(int i = 0; i<4; i++){
			if(h.get(i).getRankValue() == h.get(i+1).getRankValue() && h.get(i).getRankValue() != removed){
				return i;
			}
		}
		return -1;
	}

	public boolean isFullHouse(){
		if(isTriple() > -1 && isExternalPair(h.get(isTriple()).getRankValue()) > -1){
			return true;
		}
		return false;
	}

	public int isTwoPair(){
		if(isOnePair() > -1 && isExternalPair(h.get(isOnePair()).getRankValue()) > -1){
			for(int i = 0; i<5;i++){
				if(h.get(i).getRankValue() != h.get(isOnePair()).getRankValue() && h.get(i).getRankValue() != h.get(isExternalPair(h.get(isOnePair()).getRankValue())).getRankValue()){
					return i;
				}
			}
		}
		return -1;
	}
	

	//returns 1 hand wins, -1 if other hand wins, 0 if tie
	public int versus(Hand other){
		if(this.handValue() > other.handValue()){
			return 1;
		} else if (this.handValue < other.handValue()){
			return -1;
		} else {
			return 0;
		}
	}
	

	public int isAlmostStraight(){
		int reject = -1;
		int counter = 0;
		for(int i = 1; i < 6; i++){
			if(h.get(4).getRankValue() == 14 && i == 1){
				counter++;
			} 
			else if(h.get(i-1).getRankValue() == i){
				counter++;
			}
			else{
				reject = i - 1;
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
		}
		return -1;
	}
	

	//returns index of smaller kicker, used for close to full house or four of a kind
	public int moreThanTriple(){ 
		if(isTriple() > -1 && h.get(isTriple()).getRankValue() >= 0){
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

	public ArrayList<Integer> isAlmostFlush(){

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
	
	//returns size 3 arraylist of integers of the indexes of the other 3 numbers
	public ArrayList<Integer> moreThanOnePair(){
		ArrayList<Integer> output = new ArrayList<Integer>();
		if(isOnePair() > -1){
			for(int i = 0; i < 5; i++){
				if(h.get(i).getRankValue() != h.get(isOnePair()).getRankValue()){
					output.add(i);
				}
			}
			return output;
		}
		else{
			return output;
		}
	}
	



}
