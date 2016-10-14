package edu;

/**
 * The class ChanceSpace extends BasicSpace and controls the Go space
 * 
 * @author: Sergio Penavades Suarez 
 * @version: 1
 */

public class GoSpace extends BasicSpace{
	
	public final static int CREDITS = 200;
	private final static String NAME = "Go";
	
	/**
	 * The method GoSpace is the constructor method which creates the space
	 */
	public GoSpace(){
		this.name = NAME;
	}
	/**
	 * The method onLand performs the space operation 
	 * @param game contains the Monopoly board and the actual state
	 */
	@Override
	public void onLand(Monopoly game, Integer... dice) {
		game.addCredits(CREDITS);
		System.out.println(String.format("%s awards %d credits.", name, CREDITS));
	}

}
