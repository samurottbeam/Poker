import java.awt.*;
import java.util.*;	

public class Bot extends Player{

	public Bot(String name, Hand h){
		super(name, h);
	}

	
	public Hand getHand(){
		return h;
	}
	
	//bots course of action on swapping
	public void decision(){
		if (h.handValue() >= 5) {
			return;
		} else if (h.isAlmostFlush().size() != 0){
			//swap other 2 cards
			for (int i = 0; i < h.isAlmostFlush().size(); i++) {
				h.swapCards(h.isAlmostFlush().get(i) + 1);
			}
		} else if (h.isAlmostStraight() > -1){
			//swap last card
			h.swapCards(h.isAlmostStraight() + 1);
		} else if (h.moreThanTriple() > -1){
			//swap card at h.moreThanTriple()
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


	//returns confidence level of AI in their hand
	public int getConfidenceLevel(int round){
		//confidence high (raise), mid (call), low (fold)
		if (round == 1){
			if (h.getHandValue() >= 5 || h.isAlmostFlush().size() != 0 || h.isAlmostStraight() > -1 || h.moreThanTriple() > -1) {
				return 3;
			} else {
				return 2;
			}
		} else {
			if (h.getHandValue() >= 5) {
				return 3;
			} else if (h.getHandValue() >= 3){
				return 2;
			} else {
				return 1;
			}
		}	
	}
}
