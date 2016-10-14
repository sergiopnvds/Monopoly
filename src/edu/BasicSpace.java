package edu;

/**
 * The abstract class BasicSpace defines the basic structure of a Monopoly space.
 * 
 * @author: Sergio Penavades Suarez 
 * @version: 1
 */
public abstract class BasicSpace {
	
	protected String name;
	
	/**
	 * The abstract method onLand performs the operation in the space where the token is situated
	 * @param game contains the Monopoly board and the actual state
	 */
	public abstract void onLand(Monopoly game, Integer... dice);
	
	/**
	 * The toString returns the space name 
	 * @return the name
	 */
	public String toString(){
		return name;
	}
	/**
	 * The method resetNumberVisited reset the numberVisited count
	 */
	public void resetNumberVisited(){
	}
	
}
