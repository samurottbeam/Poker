public class Pot{
	private int money;
	private int currBid;

	public Pot(){
		money = 0;
		currBid = 0;
	}

	public void ante(Player p1, Bot dealer, Bot p2, Bot p3){
		p1.changeMoney(-100);
		dealer.changeMoney(-100);
		p2.changeMoney(-100);
		p3.changeMoney(-100);
		money+=400;
	}

	public void Call(Player p){
		if(p.getMoney() > currBid){
			p.changeMoney(-(currBid-p.getPlayerBet()));
			money += currBid-p.getPlayerBet() ;
		}
		else{
			money+=p.getMoney();
			p.changeMoney(-p.getMoney());
		}
	}

	public void Raise(Player p1, int bid){
		p1.changeMoney(-bid);
		money += bid;
		currBid += bid;
	}

	public int getMoney(){
		return money;
	}

	public int getCurrBid(){
		return currBid;
	}
}
