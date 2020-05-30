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
	public static void refreshBoard(DrawingPanel dp, Graphics g, Player p1, Player p2) throws IOException{
		g.setColor(Color.white);
		g.fillRect(0,0,800,800);
		BufferedImage img;
		img = ImageIO.read(new File("cardback.png"));
		g.setColor(Color.black);
		Font font = new Font("Sans Serif", Font.BOLD, 25);
		g.setFont(font);
		g.drawString("Deck: ", 600,250);
		g.drawString("Current player: " + p1.getName(), 515,35);
		g.drawImage(img,550,280,220,300,null);
		Font font2 = new Font("Sans Serif", Font.PLAIN, 12);
		g.setFont(font2);
		String s1 = "" + p1.getName() + " Hand: ";
		String s2 = "" + p2.getName() + " Hand: ";
		g.drawString(s1, 0, 580);
		g.drawString(s2, 0, 10);
		for(int i = 0; i < 5; i++){
			String s = "" + (i+1);
			g.drawImage(img,100*i,25,90,150,null);
			g.drawString(s, 40+100*(i),23);
		}
	}
	//runs the game
	public static void main(String[] args) throws IOException{
		//add hand to player and dealer for tmrw
		Scanner console = new Scanner(System.in);
		boolean wantSwap = true;
		int swapNum = 0;
		DrawingPanel panel = new DrawingPanel(800,800);
		Graphics g = panel.getGraphics();
		Deck d = new Deck();
		d.fillDeck();
		d.shuffleDeck();
		Hand p = new Hand(d);
		p.draw();
		Hand deal = new Hand(d);
		deal.draw();
		Player person = new Player("Player", p);
		Player dealer = new Player("Dealer", deal);
		refreshBoard(panel,g,person,dealer);
		person.printPlayerHand(panel,g);
		//swaps the cards
		System.out.println("Which cards would you like to swap?");
		person.getHand().swapCards(console);
		//refresh board
		refreshBoard(panel,g,person,dealer);
		person.printPlayerHand(panel,g);
		// System.out.println("Switch turns.");
		// refreshBoard(panel,g,dealer,person);
		// dealer.printPlayerHand(panel,g);
		

	}
}