public class Pot{
	private int money;
	private int currBid;

	public Pot(){
		money = 0;
		currBid = 0;
	}

	public void Call(Player p){
		p.changeMoney(-currBid);
		money += currBid;
	}

	public void Raise(Player p, int bid){
		if(bid>=currBid){
			p.changeMoney(-bid);
			money += bid;
			currBid = bid;
		}
		else{
			System.out.println("You must bet at least $" + currBid + ".");
		}
	}

	public void Fold(Player p){
		//remove from the round
	}

	public int getMoney(){
		return money;
	}

	public int getCurrBid(){
		return currBid;
	}
}
