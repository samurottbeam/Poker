import java.util.*;
import java.awt.*;

public class Player{
	private String name;
	Hand h;
	private int money;

	//default constructor function set at $100000
	public Player(String name, Hand h){
		this.name = name;
		this.h = h;
		money = 100000;
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

	public void changeMoney(int change){
		this.money += change;
	}

	public int getMoney(){
		return money;
	}

}
