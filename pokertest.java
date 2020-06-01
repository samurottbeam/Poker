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
		if(confidenceLevel == 1){
			System.out.println("They called.");
			casinoPot.Call(b);
		}
		else if(b.getMoney() <= 0){
			System.out.println("They were forced to Fold.");
			b.fold();
		}
		else if(confidenceLevel == 2){
			System.out.println("They raised by $1000!");
			casinoPot.Raise(b, 1000);
		}
		else if(confidenceLevel == 3){
			System.out.println("They raised by $10000!");
			casinoPot.Raise(b,1000);
		}
		else{
			System.out.println("They Folded");
			b.fold();
		}

	}
	public static void userBet(Scanner console, Pot casinoPot, Player p){
		p.unFold();
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
		BufferedImage img, chipsSmall, chipsMedium, chipsLarge;

		img = ImageIO.read(new File("blue_back.png"));
		chipsSmall = ImageIO.read(new File("ChipsSmall.png"));
		chipsMedium = ImageIO.read(new File("ChipsMedium.png"));
		chipsLarge = ImageIO.read(new File("ChipsLarge.png"));


		g.setColor(Color.black);
		Font font = new Font("Sans Serif", Font.BOLD, 25);
		g.setFont(font);
		g.drawString("Deck", 620,210);
		g.drawImage(img,550,230,220,300,null);
		Font font2 = new Font("Sans Serif", Font.PLAIN, 25);
		g.setFont(font2);
		// if(p1.getCurrentTurn()){
		String s1 = "" + currentPlayer.getName() + " Hand: ";
		g.drawString(s1, 50, 575);
		String s5 = "" + currentPlayer.getName() + " Balance: ";
		g.drawString(s5, 570,600);

		g.setFont(new Font("Sans Serif", Font.BOLD, 50));
		g.setColor(Color.green);
		g.drawString("$" + currentPlayer.getMoney(), 590, 650);

		if(pot.getMoney()>100000){
			g.drawImage(chipsLarge, 160, 285, 116, 91,null);
			g.drawImage(chipsLarge, 300, 290, 126, 99,null);
			g.drawImage(chipsMedium,225,290, 185,128,null);
			g.drawImage(chipsMedium, 200, 305, 116, 91,null);
			g.drawImage(chipsMedium, 265, 310, 126, 99,null);
			g.drawImage(chipsMedium,220,320, 185,128,null);
		}
		else if(pot.getMoney()>60000){
			g.drawImage(chipsLarge, 160, 285, 116, 91,null);
			g.drawImage(chipsLarge, 300, 290, 126, 99,null);
			g.drawImage(chipsMedium,220,320, 185,128,null);
		}
		else if(pot.getMoney()>25000){
			g.drawImage(chipsMedium,220,320, 185,128,null);
		}
		else{
			g.drawImage(chipsSmall,245,325,110,114,null);
		}
		
		

		g.setFont(font);
		g.setColor(Color.black);
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
		g.drawString("Current phase:", 575,50);
		g.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		g.drawString("" + currentPhase, 575, 75);
		g.setFont(new Font("Sans Serif", Font.BOLD, 25));

		g.drawString("Current pot: ", 120,500);

		g.setFont(new Font("Sans Serif", Font.BOLD, 50));
		g.setColor(Color.green);

		g.drawString("$" + pot.getMoney(), 285,515);

		g.setFont(new Font("Sans Serif", Font.BOLD, 25));
		g.setColor(Color.black);

		g.drawString("Current bet: ", 100, 240);

		g.setColor(Color.green);

		g.drawString("$" + pot.getCurrBid(), 250, 240);

		for(int i = 0; i < 5; i++){
			// String s = "" + (i+1);
			g.drawImage(img,100*i + 50,25,90,150,null);
			// g.drawString(s, 40+100*(i),23);
		}
		g.setFont(font2);
	}

	public static void printFolded(DrawingPanel dp, Graphics g, Player p, int x, int y){
		if(p.returnIsFolded()){
			g.setColor(Color.red);
			g.setFont(new Font("Sans Serif", Font.BOLD, 25));
			g.drawString("FOLDED", x, y);
		}
	}

	public static void printChange(DrawingPanel dp, Graphics g, Player p, int x, int y){
		String display = "";
		g.setFont(new Font("Sans Serif", Font.BOLD, 25));
		if(p.getChange()<0){
			g.setColor(Color.red);
			display = "-$";
		}
		else{
			g.setColor(Color.green);
			display = "+$";
		}
		g.drawString(display + Math.abs(p.getChange()), x, y);
	}

	public static void winningScreen(DrawingPanel dp, Graphics g, Player p1, Bot dealer, Bot p2, Bot p3) throws IOException{
		g.setColor(Color.white);
		Font font = new Font("Sans Serif", Font.BOLD, 25);
		g.setFont(font);
		g.fillRect(0,0,800,800);

		g.setColor(Color.black);
		g.drawString("" + p1.getName() + " Hand: ", 565,45);
		g.setColor(Color.blue);
		g.drawString(p1.getHand().getCombo(), 565,75);
		p1.getHand().printWinCon(dp,g,0);
		printChange(dp, g, p1, 565, 105);
		printFolded(dp, g, p1, 565, 135);


		g.setColor(Color.black);
		g.drawString("" + dealer.getName() + " Hand: ", 565, 215);
		g.setColor(Color.blue);
		g.drawString(dealer.getHand().getCombo(), 565,243);
		dealer.getHand().printWinCon(dp,g,1);
		printChange(dp, g, dealer, 565, 275);
		printFolded(dp, g, dealer, 565, 305);

		g.setColor(Color.black);
		g.drawString("" + p2.getName() + " Hand: ", 565,385);
		g.setColor(Color.blue);
		g.drawString(p2.getHand().getCombo(), 565,410);
		p2.getHand().printWinCon(dp,g,2);
		printChange(dp, g, p2, 565, 440);
		printFolded(dp, g, p2, 565, 470);

		g.setColor(Color.black);
		g.drawString("" + p3.getName() + " Hand: ", 565, 560);
		g.setColor(Color.blue);
		g.drawString(p3.getHand().getCombo(), 565,585);
		p3.getHand().printWinCon(dp,g,3);
		printChange(dp, g, p3, 565, 615);
		printFolded(dp, g, p3, 565, 645);
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
		DrawingPanel panel = new DrawingPanel(800,800);
		Graphics g = panel.getGraphics();
		while(response.equals("Y")){
			boolean wantSwap = true;
			ArrayList<Integer> swapIndex = new ArrayList<Integer>();
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
			Thread.sleep(3000);
			System.out.println("Dealer's turn.");
			refreshBoard(panel,g,dealer,currentPhase,casinoPot);
			dealer.printPlayerHand(panel,g);

			//TESTING
			//System.out.println(dealer.getHand());
			//System.out.println(dealer.getHand().handValue());

			int ciOfDealer = dealer.getConfidenceLevel(1);

			//TESTING
			//System.out.println(ciOfDealer + " CONDIFENCE");

			System.out.println("Dealer is choosing...");
			aiBet(ciOfDealer, casinoPot, dealer, 1);
			casinoPot.Call(player1);
			casinoPot.Call(player2);
			casinoPot.Call(player3);
			Thread.sleep(3000);
			dealer.decision();
			System.out.println();
			refreshBoard(panel,g,dealer,currentPhase,casinoPot);
			dealer.printPlayerHand(panel,g);

			Thread.sleep(3000);
			System.out.println("Player 2's turn.");
			refreshBoard(panel,g,player2,currentPhase,casinoPot);
			player2.printPlayerHand(panel,g);
			int ciOfp2 = dealer.getConfidenceLevel(1);

			//TESTING
			//System.out.println(player2.getHand());
			//System.out.println(player2.getHand().handValue());

			//TESTING
			//System.out.println(ciOfp2 + " CONDIFENCE");
			System.out.println("Player 2 is choosing...");
			aiBet(ciOfp2, casinoPot, player2, 1);
			casinoPot.Call(player1);
			casinoPot.Call(dealer);
			casinoPot.Call(player3);			
			Thread.sleep(3000);
			player2.decision();
			System.out.println();
			refreshBoard(panel,g,player2,currentPhase,casinoPot);
			player2.printPlayerHand(panel,g);

			Thread.sleep(3000);
			System.out.println("Player 3's turn.");
			refreshBoard(panel,g,player3,currentPhase,casinoPot);
			player3.printPlayerHand(panel,g);


			casinoPot.Call(player1);
			int ciOfp3 = dealer.getConfidenceLevel(1);

			//TESTING
			//System.out.println(player3.getHand());
			//System.out.println(player3.getHand().handValue());

			//TESTING
			//System.out.println(ciOfp3 + " CONDIFENCE");
			System.out.println("Player 3 is choosing...");
			aiBet(ciOfp3, casinoPot, player3, 1);
			casinoPot.Call(player1);
			casinoPot.Call(dealer);
			casinoPot.Call(player2);

			//System.out.println("Player 3 is choosing...");
			Thread.sleep(3000);
			player3.decision();
			System.out.println();
			refreshBoard(panel,g,player3,currentPhase,casinoPot);
			player3.printPlayerHand(panel,g);

			currentPhase = "Raise/Call/Fold, Post-Swap";
			if(player1.returnIsFolded() == false){
				refreshBoard(panel,g,player1,currentPhase,casinoPot);
				player1.printPlayerHand(panel,g);
				userBet(console, casinoPot, player1);
				casinoPot.Call(dealer);
				casinoPot.Call(player2);
				casinoPot.Call(player3);
			}
			

			System.out.println("Dealer is betting...");
			Thread.sleep(3000);
			ciOfDealer = dealer.getConfidenceLevel(2);

			//TESTING
			//System.out.println(dealer.getHand());
			//System.out.println(dealer.getHand().handValue());

			//TESTING
			//System.out.println(ciOfDealer + " CONDIFENCE");

			aiBet(ciOfDealer, casinoPot, dealer, 2);
			System.out.println();
			casinoPot.Call(player1);
			casinoPot.Call(player2);
			casinoPot.Call(player3);
			refreshBoard(panel,g,dealer,currentPhase,casinoPot);
			dealer.printPlayerHand(panel,g);
			System.out.println("Player 2 is betting...");
			Thread.sleep(3000);

			ciOfp2 = player2.getConfidenceLevel(2);

			//TESTING
			//System.out.println(player2.getHand());
			//System.out.println(player2.getHand().handValue());

			//TESTING
			//System.out.println(ciOfp2 + " CONDIFENCE");

			aiBet(ciOfDealer, casinoPot, player2, 2);
			System.out.println();
			casinoPot.Call(player1);
			casinoPot.Call(dealer);
			casinoPot.Call(player3);
			refreshBoard(panel,g,player2,currentPhase,casinoPot);
			player2.printPlayerHand(panel,g);
			Thread.sleep(3000);

			System.out.println("Player 3 is betting...");
			Thread.sleep(3000);
			ciOfp3 = player3.getConfidenceLevel(2);

			//TESTING
			//System.out.println(player3.getHand());
			//System.out.println(player3.getHand().handValue());

			//TESTING
			//System.out.println(ciOfp3 + " CONDIFENCE");

			aiBet(ciOfDealer, casinoPot, player3, 2);
			System.out.println();
			casinoPot.Call(player1);
			casinoPot.Call(dealer);
			casinoPot.Call(player2);
			refreshBoard(panel,g,player3,currentPhase,casinoPot);
			player3.printPlayerHand(panel,g);
			Thread.sleep(3000);
			
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


			/*
			for(Player p : playerList){
				System.out.println(p.getHand().handValue());
			}
			System.out.println("THIS IS THE LIST OF RANKING");
			*/
			


			
			if(playerList.isEmpty()){
				g.drawString("No one wins, house wins all.",0,745);
				winningScreen(panel,g,player1,dealer,player2,player3);
			}
			else{
				playerList.get(0).changeMoney(casinoPot.getMoney());
				winningScreen(panel,g,player1,dealer,player2,player3);
				g.setFont(new Font("Sans Serif", Font.BOLD, 30));
				g.drawString("The winner is " + playerList.get(0).getName() + "!", 15 ,725);
				g.setFont(new Font("Sans Serif", Font.BOLD, 50));
				g.drawString("THEY WIN", 15, 775);
				g.setColor(Color.green);
				g.drawString("$" + casinoPot.getMoney(), 272, 775);
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
