import java.awt.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.image.*;
public class pokertest{
	/*
	refreshes the board every time it's used, you guys can remove some of the text probably isn't needed
	the java site has a lot of the graphics functions here: https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
	we can work on adding like mouselisteners and buttons if we get everything else to work
	might want to replace p2 with a dealer class, since dealer has to run an AI to check if it works	
	*/
	public static void aiBet(int confidenceLevel, Pot casinoPot, Bot b, int round){
		if(round == 1){
			if(confidenceLevel == 2 || confidenceLevel == 1){
				System.out.println("They called.");
				casinoPot.Call(b);
			}
			else if(b.getMoney() <= 0){
				System.out.println("They folded.");
				b.fold();
			}
			else{
				System.out.println("They raised.");
				casinoPot.Raise(b, 1000);
			}
		}
		else{
			if(confidenceLevel == 1 || b.getMoney() <= 0){
				System.out.println("They folded.");
				b.fold();
			}
			else if(confidenceLevel == 2){
				System.out.println("They called.");
				casinoPot.Call(b);
			}
			else{
				System.out.println("They raised.");
				casinoPot.Raise(b, 1000);
			}
		}
	}
	public static void userBet(Scanner console, Pot casinoPot, Player p){
		System.out.println("What would you like to do? (R/C/F)");
		String userInput = console.next();
		if(userInput.equals("R")){
			System.out.println("What would you like to raise it by?");
			int r = console.nextInt();
			casinoPot.Raise(p, r);
		}
		else if(userInput.equals("C")){
			casinoPot.Call(p);
		}
		else{
			p.fold();
		}
	}
	public static void refreshBoard(DrawingPanel dp, Graphics g, Player currentPlayer, String currentPhase, Pot pot) throws IOException{
		g.setColor(Color.white);
		g.fillRect(0,0,800,800);
		BufferedImage img;
		img = ImageIO.read(new File("cardback.png"));
		g.setColor(Color.black);
		Font font = new Font("Sans Serif", Font.BOLD, 25);
		g.setFont(font);
		g.drawString("Deck: ", 600,250);
		g.drawImage(img,550,280,220,300,null);
		Font font2 = new Font("Sans Serif", Font.PLAIN, 12);
		g.setFont(font2);
		// if(p1.getCurrentTurn()){
		String s1 = "" + currentPlayer.getName() + " Hand: ";
		g.drawString(s1, 0, 580);
		String s5 = "" + currentPlayer.getName() + " Balance: " + currentPlayer.getMoney();
		g.drawString(s5, 550,600);
		// String s3 = "" + dealer.getName() + " Hand: ";
		// g.drawString(s3, 7,13);
		
		// String s7 = "" + dealer.getName() + " Balance: " + dealer.getMoney();
		// g.drawString(s7, 550,30);
		// }
		// if(dealer.getCurrentTurn()){
		// 	String s2 = "" + dealer.getName() + " Hand: ";
		// 	g.drawString(s2, 0, 580);
		// 	// String s4 = "" + p1.getName() + " Hand: ";
		// 	// g.drawString(s4, 7,13);
		// 	String s6 = "" + dealer.getName() + " Hand: " + dealer.getMoney();
		// 	g.drawString(s6, 550,600);
		// 	// String s8 = "" + p1.getName() + " Hand: " + p1.getMoney();
		// 	// g.drawString(s6, 550,30);
		// }
		g.drawString("Current phase: " + currentPhase, 0,300);
		g.drawString("Current pot: " + pot.getMoney(), 0,310);
		g.drawString("Current bet: " + pot.getCurrBid(), 0, 320);
		for(int i = 0; i < 5; i++){
			// String s = "" + (i+1);
			g.drawImage(img,100*i,25,90,150,null);
			// g.drawString(s, 40+100*(i),23);
		}
	}

	public static void winningScreen(DrawingPanel dp, Graphics g, Player p1, Bot dealer, Bot p2, Bot p3) throws IOException{
		g.setColor(Color.white);
		g.fillRect(0,0,800,800);
		g.setColor(Color.black);
		g.drawString("" + p1.getName() + " Hand: ", 0,13);
		p1.getHand().printWinCon(dp,g,0);
		g.setColor(Color.black);
		g.drawString("" + dealer.getName() + " Hand: ", 0, 185);
		dealer.getHand().printWinCon(dp,g,1);
		g.setColor(Color.black);
		g.drawString("" + p2.getName() + " Hand: ", 0,360);
		p2.getHand().printWinCon(dp,g,2);
		g.setColor(Color.black);
			g.drawString("" + p3.getName() + " Hand: ", 0, 530);
		p3.getHand().printWinCon(dp,g,3);
	}
	//runs the game
	public static void runGame() throws IOException, InterruptedException{
		//add hand to player and dealer for tmrw
		Deck d = new Deck();
		d.fillDeck();
		d.shuffleDeck();
		int numOfGames = 0;
		Hand hand1 = new Hand(d);
		Hand deal = new Hand(d);
		Hand hand2 = new Hand(d);
		Hand hand3 = new Hand(d);
		Player player1 = new Player("Player 1", hand1);
		Bot dealer = new Bot("Dealer", deal);
		Bot player2 = new Bot("Player 2", hand2);
		Bot player3 = new Bot("Player 3", hand3);
		Scanner console = new Scanner(System.in);
		String response = "Y";
		while(response.equals("Y")){
			boolean wantSwap = true;
			ArrayList<Integer> swapIndex = new ArrayList<Integer>();
			DrawingPanel panel = new DrawingPanel(800,800);
			Graphics g = panel.getGraphics();
			String currentPhase = "";
			Pot casinoPot = new Pot();

			hand1.draw();
			deal.draw();
			hand2.draw();
			hand3.draw();
			player1.setHand(hand1);
			dealer.setHand(deal);
			player2.setHand(hand2);
			player3.setHand(hand3);

			currentPhase = "Raise/Call/Fold, Pre-Swap";
			refreshBoard(panel,g,player1,currentPhase, casinoPot);
			casinoPot.ante(player1,dealer,player2,player3);
			refreshBoard(panel,g,player1,currentPhase, casinoPot);
			player1.printPlayerHand(panel,g);
			userBet(console, casinoPot, player1);
			casinoPot.Call(dealer);
			casinoPot.Call(player2);
			casinoPot.Call(player3);
			refreshBoard(panel,g,player1,currentPhase, casinoPot);
			player1.printPlayerHand(panel,g);

			//swaps the cards
			if(player1.returnIsFolded() == false){
				System.out.println("Which cards would you like to swap?");
				int cardNum = console.nextInt();
				while(cardNum != 0){
					player1.getHand().swapCards(cardNum);
					while(swapIndex.contains(cardNum)){
						cardNum = console.nextInt();
					}
					swapIndex.add(cardNum);
				}
			}
			
			
			//refresh board
			refreshBoard(panel,g,player1,currentPhase,casinoPot);
			player1.printPlayerHand(panel,g);
			Thread.sleep(1000);
			System.out.println("Dealer's turn.");
			refreshBoard(panel,g,dealer,currentPhase,casinoPot);
			dealer.printPlayerHand(panel,g);

			//TESTING
			System.out.println(dealer.getHand());
			System.out.println(dealer.getHand().handValue());

			int ciOfDealer = dealer.getConfidenceLevel(1);

			//TESTING
			System.out.println(ciOfDealer + " CONDIFENCE");

			aiBet(ciOfDealer, casinoPot, dealer, 1);
			casinoPot.Call(player1);
			casinoPot.Call(player2);
			casinoPot.Call(player3);
			System.out.println("Dealer is choosing...");
			Thread.sleep(1000);
			dealer.decision();
			System.out.println();
			refreshBoard(panel,g,dealer,currentPhase,casinoPot);
			dealer.printPlayerHand(panel,g);

			Thread.sleep(1000);
			System.out.println("Player 2's turn.");
			refreshBoard(panel,g,player2,currentPhase,casinoPot);
			player2.printPlayerHand(panel,g);
			int ciOfp2 = dealer.getConfidenceLevel(1);

			//TESTING
			System.out.println(player2.getHand());
			System.out.println(player2.getHand().handValue());

			//TESTING
			System.out.println(ciOfp2 + " CONDIFENCE");

			aiBet(ciOfp2, casinoPot, player2, 1);
			casinoPot.Call(player1);
			casinoPot.Call(dealer);
			casinoPot.Call(player3);			
			System.out.println("Player 2 is choosing...");
			Thread.sleep(1000);
			player2.decision();
			System.out.println();
			refreshBoard(panel,g,player2,currentPhase,casinoPot);
			player2.printPlayerHand(panel,g);

			Thread.sleep(1000);
			System.out.println("Player 3's turn.");
			refreshBoard(panel,g,player3,currentPhase,casinoPot);
			player3.printPlayerHand(panel,g);


			casinoPot.Call(player1);
			int ciOfp3 = dealer.getConfidenceLevel(1);

			//TESTING
			System.out.println(player3.getHand());
			System.out.println(player3.getHand().handValue());

			//TESTING
			System.out.println(ciOfp3 + " CONDIFENCE");
			
			aiBet(ciOfp3, casinoPot, player3, 1);
			casinoPot.Call(player1);
			casinoPot.Call(dealer);
			casinoPot.Call(player2);

			System.out.println("Player 3 is choosing...");
			Thread.sleep(1000);
			player3.decision();
			System.out.println();
			refreshBoard(panel,g,player3,currentPhase,casinoPot);
			player3.printPlayerHand(panel,g);

			currentPhase = "Raise/Call/Fold, Post-Swap";
			if(player1.returnIsFolded() == false){
				userBet(console, casinoPot, player1);
				casinoPot.Call(dealer);
				casinoPot.Call(player2);
				casinoPot.Call(player3);
			}
			

			System.out.println("Dealer is betting...");
			Thread.sleep(1000);
			ciOfDealer = dealer.getConfidenceLevel(2);

			//TESTING
			System.out.println(dealer.getHand());
			System.out.println(dealer.getHand().handValue());

			//TESTING
			System.out.println(ciOfDealer + " CONDIFENCE");

			aiBet(ciOfDealer, casinoPot, dealer, 2);
			casinoPot.Call(player1);
			casinoPot.Call(player2);
			casinoPot.Call(player3);
			refreshBoard(panel,g,dealer,currentPhase,casinoPot);
			dealer.printPlayerHand(panel,g);
			Thread.sleep(1000);

			System.out.println("Player 2 is betting...");
			Thread.sleep(1000);
			ciOfp2 = player2.getConfidenceLevel(2);

			//TESTING
			System.out.println(player2.getHand());
			System.out.println(player2.getHand().handValue());

			//TESTING
			System.out.println(ciOfp2 + " CONDIFENCE");

			aiBet(ciOfDealer, casinoPot, player2, 2);
			casinoPot.Call(player1);
			casinoPot.Call(dealer);
			casinoPot.Call(player3);
			refreshBoard(panel,g,player2,currentPhase,casinoPot);
			player2.printPlayerHand(panel,g);
			Thread.sleep(1000);

			System.out.println("Player 3 is betting...");
			Thread.sleep(1000);
			ciOfp3 = player3.getConfidenceLevel(2);

			//TESTING
			System.out.println(player3.getHand());
			System.out.println(player3.getHand().handValue());

			//TESTING
			System.out.println(ciOfp3 + " CONDIFENCE");

			aiBet(ciOfDealer, casinoPot, player3, 2);
			casinoPot.Call(player1);
			casinoPot.Call(dealer);
			casinoPot.Call(player2);
			refreshBoard(panel,g,player3,currentPhase,casinoPot);
			player3.printPlayerHand(panel,g);
			Thread.sleep(1000);
			
			ArrayList<Player> playerList = new ArrayList<Player>();
			if(player1.returnIsFolded() == false){
				playerList.add(player1);
			}
			if(dealer.returnIsFolded() == false){
				playerList.add(dealer);
			}
			if(player2.returnIsFolded() == false){
				playerList.add(player2);
			}
			if(player3.returnIsFolded() == false){
				playerList.add(player3);
			}


			Collections.sort(playerList);
			Collections.reverse(playerList);

			winningScreen(panel,g,player1,dealer,player2,player3);
			if(playerList.isEmpty()){
				g.drawString("No one wins, house wins all.",0,745);
			}
			else{
				playerList.get(0).changeMoney(casinoPot.getMoney());
				g.drawString("The winner is: " + playerList.get(0).getName(),0,745);
			}
			
			
			player1.getHand().returnHand();
			dealer.getHand().returnHand();
			player2.getHand().returnHand();
			player3.getHand().returnHand();

			d.shuffleDeck();
			
			System.out.println("Would you like to continue the game? (Y/N)");
			response = console.next();
			if(response.equals("N")){
				System.exit(1);
			}
			else if(player1.getMoney() <= 0){
				System.out.println("You're out of money.");
				System.exit(1);
			}
			else{
				numOfGames++;
			}

		}
		
		
		
		// System.exit(1);
	}
	public static void main(String[] args) throws IOException, InterruptedException{
		runGame();
	}
}
