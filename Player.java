import java.util.*;
import java.awt.*;

public class Player{
	private String name;
	public Hand h;
	private int money;
	public int playerBet;
	public Boolean isFolded;


	//default constructor function set at $100000
	public Player(String name, Hand h){
		this.name = name;
		this.h = h;
		money = 100000;
		playerBet = 0;
		isFolded = false;
	}

	//constructor if amount of money to start with is not $100000
	public Player(String name, Hand h, int money){
		this.name = name;
		this.h = h;
		this.money = money;
	}

	//prints hand
	public void printPlayerHand(DrawingPanel d, Graphics g){
		h.printHand(d,g);
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

	public void returnPlayerHand(){
		h.returnHand();
	}

	public void fold(){
		isFolded = true;
	}

	public Boolean returnIsFolded(){
		return isFolded;
	}

	public int getPlayerBet(){
		return playerBet;
	}

	public void setPlayerBet(int newBet){
		playerBet = newBet;
	} 

	public void changeMoney(int change){
		this.money += change;
	}

	public int getMoney(){
		return money;
	}

}
