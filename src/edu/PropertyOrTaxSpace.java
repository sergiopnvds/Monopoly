package edu;

/**
 * The class ChanceSpace extends BasicSpace and controls the Property or Tax spaces
 * 
 * @author: Sergio Penavades Suarez 
 * @version: 1
 */

public class PropertyOrTaxSpace extends BasicSpace {
	
	private int credits;
	
	/**
	 * The method PropertyOtTaxSpace is the constructor method which creates the space
	 */
	public PropertyOrTaxSpace(String name, int credits){
		this.name = name;
		this.credits = credits;
	}


	/**
	 * The method onLand performs the space operation 
	 * @param game contains the Monopoly board and the actual state
	 */
	@Override
	public void onLand(Monopoly game, Integer... dice) {
		game.addCredits(credits);
		System.out.println(String.format("%s awards %d credits.", name, credits));
	}
	
}
