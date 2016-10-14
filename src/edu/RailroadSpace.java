package edu;

/**
 * The class ChanceSpace extends BasicSpace and controls the Railroad spaces
 * 
 * @author: Sergio Penavades Suarez 
 * @version: 1
 */

public class RailroadSpace extends BasicSpace {
	
	private final static int CREDITS = 200;
	private static int numberVisited = 0;
	
	/**
	 * The method RailroadSpace is the constructor method which creates the space
	 */
	public RailroadSpace(String name){
		this.name = name;
	}
	
	/**
	 * The method resetNumberVisited reset the numberVisited count
	 */
	public void resetNumberVisited(){
		numberVisited=0;
	}
	/**
	 * The method onLand performs the space operation 
	 * @param game contains the Monopoly board and the actual state
	 */
	@Override
	public void onLand(Monopoly game, Integer... dice) {
		numberVisited++;
		int creditsToAdd = CREDITS*numberVisited;
		game.addCredits(creditsToAdd);
		System.out.println(String.format("%s awards %d x %d = %d credits.", name, numberVisited, CREDITS, creditsToAdd));
	}

}
