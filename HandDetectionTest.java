import java.util.*;

public class HandDetectionTest{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Deck d = new Deck();
		d.fillDeck();
		d.shuffleDeck();
		ArrayList<Card> initial = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			initial.add(new Card(console.nextInt(), console.nextInt()));
		}
		Hand hand = new Hand(d, initial);
		Bot bot = new Bot("Dealer", hand);

		
		System.out.println();
		System.out.println(bot.getHand());
		System.out.println(bot.getHand().getHandValue());
		System.out.println("I have a first round confidence level of " + bot.getConfidenceLevel(1));
		System.out.println(bot.getHand().getHandValue());
		System.out.println("I have a second round confidence level of " + bot.getConfidenceLevel(2));

		/*
		bot.decision();
		System.out.println();
		System.out.println(bot.getHand());
		System.out.println(bot.getHand().handValue());
		System.out.println("I have a confidence level of " + bot.getConfidenceLevel(2));
		*/
	}
}
