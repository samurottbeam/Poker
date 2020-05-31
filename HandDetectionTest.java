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
		Bot bot = new Bot(hand);
		System.out.println(hand.handValue());

		bot.decision();
		System.out.println();
		
		System.out.println(bot.getHand());
		System.out.println(bot.getHand().handValue());
	}
}