package edu;

/**
 * The class ChanceSpace extends BasicSpace and controls the Company spaces
 * 
 * @author: Sergio Penavades Suarez 
 * @version: 1
 */
public class CompanySpace extends BasicSpace {
	
	private int multiplier;
	
	/**
	 * The method CompanySpace is the constructor method which creates the space
	 */
	public CompanySpace(String name, int multiplier){
		this.name = name;
		this.multiplier = multiplier;
	}

	/**
	 * The method onLand performs the space operation 
	 * @param game contains the Monopoly board and the actual state
	 */
	@Override
	public void onLand(Monopoly game, Integer... dice) {
		if(dice == null || dice.length != 2 ){
			throw new IllegalArgumentException("CompanySpace need two number representing dice.");
		}
		int dice1 = dice[0];
		int dice2 = dice[1];
		int credits = (dice1 + dice2) * multiplier;
		game.addCredits(credits);
		System.out.println(String.format("%s awards (%d + %d) x %d = %d", name, dice1, dice2, multiplier, credits));
	}
}
