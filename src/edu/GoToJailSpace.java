package edu;

/**
 * The class ChanceSpace extends BasicSpace and controls the Go to Jail space
 * 
 * @author: Sergio Penavades Suarez 
 * @version: 1
 */

public class GoToJailSpace extends BasicSpace {


	/**
	 * The method onLand performs the space operation 
	 * @param game contains the Monopoly board and the actual state
	 */
	@Override
	public void onLand(Monopoly game, Integer... dice) {
		System.out.println("Go directly to Jail. Do not pass Go, do not collect 200 credits.");
		game.goToJail();
	}

}
