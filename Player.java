import java.util.*;
import java.awt.*;

public class Player{
	private String name;
	Hand h;

	//constructor function
	public Player(String name, Hand h){
		this.name = name;
		this.h = h;
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



}