import java.awt.*;
import java.util.*;	

//compares hands after swaps to determine winner
public class handComparer{
	private Hand hand1;
	private Hand hand2;

	public handComparer(Player p1, Bot bot){
		this.hand1 = p1.getHand();
		this.hand2 = bot.getHand();
	}

	
}