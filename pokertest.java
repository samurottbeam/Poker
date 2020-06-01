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
	public static void refreshBoard(DrawingPanel dp, Graphics g, Player p1, Bot dealer) throws IOException{
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
		if(p1.getCurrentTurn()){
			String s1 = "" + p1.getName() + " Hand: ";
			g.drawString(s1, 0, 580);
			String s3 = "" + dealer.getName() + " Hand: ";
			g.drawString(s3, 7,13);
		}
		if(dealer.getCurrentTurn()){
			String s2 = "" + dealer.getName() + " Hand: ";
			g.drawString(s2, 0, 580);
			String s4 = "" + p1.getName() + " Hand: ";
			g.drawString(s4, 7,13);
		}
		
		for(int i = 0; i < 5; i++){
			String s = "" + (i+1);
			g.drawImage(img,100*i,25,90,150,null);
			g.drawString(s, 40+100*(i),23);
		}
	}

	public static void winningScreen(DrawingPanel dp, Graphics g, Player p1, Bot dealer, int winCon) throws IOException{
		g.setColor(Color.white);
		g.fillRect(0,0,800,800);
		String s1 = "" + p1.getName() + " Hand: ";
		g.setColor(Color.black);
		g.drawString(s1, 0,13);
		p1.getHand().printWinCon(dp,g);
		String s2 = "" + dealer.getName() + " Hand: ";
		g.setColor(Color.black);

		g.drawString(s2, 0, 570);
		dealer.printBotHand(dp,g);
		if(winCon == 1){
			g.drawString("Player wins.",7, 350);
		}
		else if(winCon == 0){
			g.drawString("Tie.",7, 350);
		}
		else{
			g.drawString("Dealer wins.",7, 350);
		}
	}
	//runs the game
	public static void main(String[] args) throws IOException, InterruptedException{
		//add hand to player and dealer for tmrw
		Scanner console = new Scanner(System.in);
		boolean wantSwap = true;
		ArrayList<Integer> swapIndex = new ArrayList<Integer>();
		DrawingPanel panel = new DrawingPanel(800,800);
		Graphics g = panel.getGraphics();
		Pot casinoPot = new Pot();
		Deck d = new Deck();
		d.fillDeck();
		d.shuffleDeck();
		Hand p = new Hand(d);
		p.draw();
		Hand deal = new Hand(d);
		deal.draw();
		Player person = new Player("Player", p, true);
		Bot dealer = new Bot("Dealer", deal, false);
		refreshBoard(panel,g,person,dealer);
		person.printPlayerHand(panel,g);
		//swaps the cards
		System.out.println("Which cards would you like to swap?");
		int cardNum = console.nextInt();
		while(cardNum != 0){
			person.getHand().swapCards(cardNum);
			while(swapIndex.contains(cardNum)){
				cardNum = console.nextInt();
			}
			swapIndex.add(cardNum);
		}
		
		//refresh board
		refreshBoard(panel,g,person,dealer);
		person.printPlayerHand(panel,g);
		person.getHand().setHandValue(person.getHand().handValue());
		Thread.sleep(2000);
		System.out.println("Dealer's turn.");
		person.setCurrentTurn(false);
		dealer.setCurrentTurn(true);
		refreshBoard(panel,g,person,dealer);
		dealer.printBotHand(panel,g);
		System.out.println("Dealer is choosing...");
		Thread.sleep(3000);
		dealer.decision();
		System.out.println();
		refreshBoard(panel,g,person,dealer);
		dealer.printBotHand(panel,g);
		dealer.getHand().setHandValue(dealer.getHand().handValue());
		int winCond = person.getHand().versus(dealer.getHand());
		winningScreen(panel,g,person,dealer,winCond);
		
		
		
		// System.exit(1);
	}
}