import java.util.*;
import java.awt.*;

public class Player{
	private String name;
	public Hand h;
	private int money;
	public Boolean isCurrentTurn;


	//default constructor function set at $100000
	public Player(String name, Hand h, Boolean isCurrentTurn){
		this.name = name;
		this.h = h;
		money = 100000;
		this.isCurrentTurn = isCurrentTurn;
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
	
	public void setCurrentTurn(Boolean b){
		isCurrentTurn = b;
	}

	public Boolean getCurrentTurn(){
		return isCurrentTurn;
	}

	public void changeMoney(int change){
		this.money += change;
	}

	public int getMoney(){
		return money;
	}

}
