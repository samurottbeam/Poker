import java.awt.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.image.*;

public class Player implements Comparable<Player>{
	private String name;
	public Hand h;
	private int money;
	public int playerBet;
	public Boolean isFolded;
	public int netChange;


	//default constructor function set at $100000
	public Player(String name, Hand h){
		this.name = name;
		this.h = h;
		money = 100000;
		playerBet = 0;
		isFolded = false;
		netChange = 0;
	}

	//constructor if amount of money to start with is not $100000
	public Player(String name, Hand h, int money){
		this.name = name;
		this.h = h;
		this.money = money;
	}

	//prints hand
	public void printPlayerHand(DrawingPanel d, Graphics g) throws IOException{
		h.printHand(d,g);
	}

	public int getChange(){
		return netChange;
	}
	//return functions

	public String getName(){
		return name;
	}

	
	public Hand getHand(){
		return h;
	}

	public void setHand(Hand newH){
		this.h = newH;
	}

	public void fold(){
		isFolded = true;
	}

	public void unFold(){
		isFolded = false;
	}

	public Boolean returnIsFolded(){
		return isFolded;
	}

	public void unfold(){
		isFolded = false;
	}

	public int getPlayerBet(){
		return playerBet;
	}

	public void setPlayerBet(int newBet){
		playerBet = newBet;
	} 

	public void changeMoney(int change){
		if(isFolded){
			return;
		}
		this.money += change;
		netChange += change;
	}

	public int compareTo(Player other){
		if(this.getHand().handValue() == other.getHand().handValue()){
			return 0;
		}
		else{
			if(this.getHand().handValue() > other.getHand().handValue()){
				return -1;
			}
			else{
				return 1;
			}
		}
	}

	public int getMoney(){
		return money;
	}

}
