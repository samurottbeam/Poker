import java.awt.*;

public class Card implements Comparable<Card>{

	private String rank;
	private String suit;
	private int suitValue;
	private int rankValue;

	//constructor
	public Card(String rank, String suit, int suitValue, int rankValue){
		this.rank = rank;
		this.suit = suit;
		this.suitValue = suitValue;
		this.rankValue = rankValue;
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

	public int getSuitValue(){
		return suitValue;
	}

	public int getRankValue(){
		return rankValue;
	}

	public int compareTo(Card other){
		if(this.getRank() == other.getRank()){
			if(this.getSuitValue() > other.getSuitValue()){
				return 1;
			}
			else{
				return 0;
			}
		}
		else{
			if(this.getRankValue() > other.getRankValue()){
				return 1;
			}
			else{
				return -1;
			}
		}
	}

}
