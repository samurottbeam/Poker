import java.awt.*;

public class Card{

	private String rank;
	private String suit;
	
	//constructor
	public Card(String rank, String suit){
		this.rank = rank;
		this.suit = suit;
	}
	//change rank
	public void setRank(String newRank){
		rank = newRank;
	}
	//change suit
	public void setSuit(String newSuit){
		suit = newSuit;
	}
	//return functions
	public String getRank(){
		return rank;
	}

	public String getSuit(){
		return suit;
	}

}