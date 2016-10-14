package edu;

/**
 * The class ChanceSpace extends BasicSpace and controls the chance spaces
 * 
 * @author: Sergio Penavades Suarez 
 * @version: 1
 */
public class ChanceSpace extends BasicSpace {
	
	enum Card{GO_JAIL, GET_50_CREDITS, BACK_3_SPACES, GET_10_CREDITS, GET_100_CREDITS};
	public static String chanceKind;
	/**
	 * The method ChanceSpace is the constructor method which creates the space
	 */
	public ChanceSpace(){
		this.name = "Chance";
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
		case GO_JAIL:
			chanceKind="GO_JAIL";
			System.out.println("Chance space: Go directly to Jail.");
			game.goToJail();
			break;
		case GET_50_CREDITS:
			chanceKind="GET_50_CREDITS";
			game.addCredits(50);
			System.out.println("Chance space: Bank pays you dividend of 50 credits.");
			break;
		case BACK_3_SPACES:
			chanceKind="BACK_3_SPACES";
			game.setPosition(game.getPosition()-3);
			System.out.println("Chance space: Go back 3 spaces.");
			break;
		case GET_10_CREDITS:
			chanceKind="GET_10_CREDITS";
			game.addCredits(10);
			System.out.println("Chance space: You have won a crossword competition. Collect 10 credits.");
			break;
		case GET_100_CREDITS:
			chanceKind="GET_100_CREDITS";
			game.addCredits(100);
			System.out.println("Chance space: You have been elected Chairman of the Board. Collect 100 credits.");
			break;
		}
	}

}
