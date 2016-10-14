package edu;

/**
 * The class ChanceSpace extends BasicSpace and controls the Community Chest spaces
 * 
 * @author: Sergio Penavades Suarez 
 * @version: 1
 */
public class CommunityChestSpace extends BasicSpace {
		
	enum Card{GET_200_CREDITS, GET_50_CREDITS, GO_JAIL, GET_100_CREDITS, GET_20_CREDITS};
	public static String communityChestKind;
	/**
	 * The method CommunityChestSpace is the constructor method which creates the space
	 */
	public CommunityChestSpace(){
		this.name = "CommunityChest";
	}
	
	/**
	 * The method onLand performs the space operation 
	 * @param game contains the Monopoly board and the actual state
	 */
	@Override
	public void onLand(Monopoly game, Integer... dice) {
		int randomNumber = Monopoly.randomDice(5)-1;
		Card card = Card.values()[randomNumber];
		switch(card){
		case GET_200_CREDITS:
			communityChestKind ="GET_200_CREDITS";
			game.addCredits(200);
			System.out.println("Community Chest space: Bank error in your favor. Collect 200 credits.");
			break;
		case GET_50_CREDITS:
			communityChestKind="GET_50_CREDITS";
			game.addCredits(50);
			System.out.println("Community Chest space: From sale of stock, you get 50 credits.");
			break;
		case GO_JAIL:
			communityChestKind="GO_JAIL";
			System.out.println("Community Chest space: Go directly to Jail.");
			game.goToJail();
			break;
		case GET_100_CREDITS:
			communityChestKind="GET_100_CREDITS";
			game.addCredits(100);
			System.out.println("Community Chest space: Holiday Fund matures. Receive 100 credits.");
			break;
		case GET_20_CREDITS:
			communityChestKind="GET_20_CREDITS";
			game.addCredits(20);
			System.out.println("Community Chest space: Income tax refund. Collect 20 credits.");
			break;
		}
	}

}
