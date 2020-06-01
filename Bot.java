import java.awt.*;
import java.util.*;	

public class Bot extends Player{
	private Hand h;
	private int money;

	public Bot(String name, Hand h, Boolean isCurrentTurn){
		super(name, h, isCurrentTurn);
	}

	
	public Hand getHand(){
		return h;
	}
	
	public void printBotHand(DrawingPanel d, Graphics g){
		h.printHand(d,g);
	}

	public void setCurrentTurn(Boolean b){
		isCurrentTurn = b;
	}

	public Boolean getCurrentTurn(){
		return isCurrentTurn;
	}
		
	//bots course of action on swapping
	public void decision(){
		if (h.handValue() >= 5) {
			return;
		} else if (h.isAlmostFlush().size() != 0){
			//swap other 2 cards
			System.out.println(h.isAlmostFlush());
			for (int i = 0; i < h.isAlmostFlush().size(); i++) {
				h.swapCards(h.isAlmostFlush().get(i) + 1);
			}
		} else if (h.isAlmostStraight() > -1){
			//swap last card
			h.swapCards(h.isAlmostStraight() + 1);
		} else if (h.moreThanTriple() > -1){
			//swap card at h.moreThanTriple()
			System.out.println(h.moreThanTriple());
			h.swapCards(h.moreThanTriple() + 1);
		} else if (h.moreThanOnePair().size() != 0){
			//swap out other three
			for (int i = 0; i < 3; i++) {
				h.swapCards(h.moreThanOnePair().get(i) + 1);
			}
		} else {
			//swap everything
			for (int i = 0; i < 5; i++) {
				h.swapCards(i + 1);
			}
		}
	}

}
