package edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class contains the functioning of the Monopoly bonus Game which consists of creating the game 
 * board and handling the credits and position of the player.
 * 
 * @author: Sergio Penavades Suarez 
 * @version: 1
 */

public class Monopoly {
	
	private static Random random;
	private List<BasicSpace> spaces;
	private int credits, position;
	
	/**
	 * The method Monopoly is the constructor method which creates the grid of the game and
	 * initializes the credits and the position 
	 */
	public Monopoly(){
		credits = 0;
		position = 0;
		createBoard();
	}
	
	/**
	 * The method getCredits returns the credit amount
	 * @return gives the credit amount
	 */
	public int getCredits(){
		return credits;
	}
	
	/**
	 * The method getPosition returns the token position
	 * @return gives the number of the token position
	 */
	public int getPosition(){
		return position;
	}
	
	/**
	 * The method getChanceSpace returns the Chance card gotten from the 5 options
	 * @return gives the card name
	 */
	public String getChanceSpace(){
		return ChanceSpace.chanceKind;
	}
	
	/**
	 * The method getCommunityChestSpace returns the CommunityChest card gotten from the 5 options
	 * @return gives the card name
	 */
	public String getCommunityChestSpace(){
		return CommunityChestSpace.communityChestKind;
	}
	
	/**
	 * The method getSpaces returns the spaces list
	 * @return gives spaces list
	 */
	public List<BasicSpace> getSpaces(){
		return spaces;
	}
	
	/**
	 * The method setPosition put the token in the new space and identifies that space
	 * @param newPosition is the value of the token position in a next turn
	 */
	public void setPosition(int newPosition){
		position = newPosition;
		spaces.get(newPosition);
	}
	
	/**
	 * The method setCredits changes the total amount of credits 
	 * @param newCredit is the value of the new amount
	 */
	public void setCredits(int newCredit){
		credits = newCredit;	
	}
	
	/**
	 * The method resetCountRailroad reset the NumberVisited variable in the Railroad class
	 * 
	 */
	public void resetCountRailroad(){
		spaces.get(5).resetNumberVisited();
	}
	
	/**
	 * The method addCredits increments the credit value
	 * @param credits is the value to increment
	 */
	public void addCredits(int credits){
		this.credits += credits;
	}
	
	/**
	 * The method jailPosition allows to know what is the jail position
	 * @return the jail position
	 */
	private int jailPosition(){
		for(BasicSpace space : spaces){
			if(space instanceof JailSpace)
				return spaces.indexOf(space);
		}
		return -1;
	}
	
	/**
	 * The method goToJail assigns the jail position to the position variable
	 */
	public void goToJail(){
		position = jailPosition();
	}
	
	/**
	 * The method dice calculates if the token is inside the board and if the game can
	 * continue or if it finishes
	 * @param numberOfSpaces number of spaces to advance
	 * @return true if the game continues and false if the game exits
	 */
	public boolean dice(int dice1, int dice2){
		int numberOfSpaces = dice1+dice2;
		if(numberOfSpaces < 2 || numberOfSpaces > 12){
			throw new IllegalArgumentException("numberOfSpaces should be between 2 and 12, inclusive.");
		}
		if(position + numberOfSpaces < spaces.size()){
			position += numberOfSpaces;
			spaces.get(position).onLand(this, dice1, dice2);
			System.out.println(String.format("Total Credits Won: %d", credits));
			return true;
		}else{
			position = position + numberOfSpaces - spaces.size();
			if(position != 0){
				addCredits(200);
				System.out.println("Player passes Go and is awarded 200 credits.");
			}else spaces.get(0).onLand(this, dice1, dice2);
			System.out.println(String.format("Total Credits Won: %d", credits));
			return false;
		}
	}
	
	/**
	 * The method randomDice rolls the dice
	 * @param size defines the dice size
	 * @return the dice score
	 */
	public static int randomDice(int size){
		if(random == null){
			random = new Random(System.currentTimeMillis());
		}
		return random.nextInt(size)+1;
	}

	/**
	 * The method createBoard creates the Monopoly board
	 */
	private void createBoard(){
		spaces = new ArrayList<>();
		spaces.add(new GoSpace());
		spaces.add(new PropertyOrTaxSpace("Mediterranean Avenue", 60));
		spaces.add(new CommunityChestSpace());
		spaces.add(new PropertyOrTaxSpace("Baltic Avenue", 60));
		spaces.add(new PropertyOrTaxSpace("Income Tax", 200));
		spaces.add(new RailroadSpace("Reading Railroad"));
		spaces.add(new PropertyOrTaxSpace("Oriental Avenue", 100));
		spaces.add(new ChanceSpace());
		spaces.add(new PropertyOrTaxSpace("Vermont Avenue", 100));
		spaces.add(new PropertyOrTaxSpace("Connecticut Avenue", 120));
		spaces.add(new JailSpace());
		spaces.add(new PropertyOrTaxSpace("St. Charles Place", 140));
		spaces.add(new CompanySpace("Electrical Company", 5));
		spaces.add(new PropertyOrTaxSpace("States Avenue", 140));
		spaces.add(new PropertyOrTaxSpace("Virginia Avenue", 160));
		spaces.add(new RailroadSpace("Pennsylvania Railroad"));
		spaces.add(new PropertyOrTaxSpace("St. James Place", 180));
		spaces.add(new CommunityChestSpace());
		spaces.add(new PropertyOrTaxSpace("Tennessee Avenue", 180));
		spaces.add(new PropertyOrTaxSpace("New York Avenue", 200));
		spaces.add(new FreeParking());
		spaces.add(new PropertyOrTaxSpace("Kentucky Avenue", 220));
		spaces.add(new ChanceSpace());
		spaces.add(new PropertyOrTaxSpace("Indiana Avenue", 220));
		spaces.add(new PropertyOrTaxSpace("Illinois Avenue", 240));
		spaces.add(new RailroadSpace("B. & O. Railroad"));
		spaces.add(new PropertyOrTaxSpace("Atlantic Avenue", 260));
		spaces.add(new PropertyOrTaxSpace("Ventnor Avenue", 260));
		spaces.add(new CompanySpace("Water Works", 10));
		spaces.add(new PropertyOrTaxSpace("Marvin Gardens", 280));
		spaces.add(new GoToJailSpace());
		spaces.add(new PropertyOrTaxSpace("Pacific Avenue", 300));
		spaces.add(new PropertyOrTaxSpace("North Carolina Avenue", 300));
		spaces.add(new CommunityChestSpace());
		spaces.add(new PropertyOrTaxSpace("Pennsylvania Avenue", 320));
		spaces.add(new RailroadSpace("Short Line Railroad"));
		spaces.add(new ChanceSpace());
		spaces.add(new PropertyOrTaxSpace("Park Place", 350));
		spaces.add(new PropertyOrTaxSpace("Luxury Tax", 100));
		spaces.add(new PropertyOrTaxSpace("Boardwalk", 400));
		
	}
	
	/**
	 * Method that starts the application
	 * @args -dice, if define, the user should be prompted the values of two six
	 *  sided dice when it is time for the player to move
	 */ 
	public static void main(String [] args){
		boolean autoGenerateDice = true;
		for(String arg : args)
			if("-dice".equals(arg)){
				autoGenerateDice = false;
				break;
			}
		Monopoly monopoly = new Monopoly();
		Scanner scanner = new Scanner(System.in);
		while(true){
			int dice1 = Monopoly.randomDice(6);
			int dice2 = Monopoly.randomDice(6);
			if(!autoGenerateDice){
				while(true){
					System.out.print("Please enter your dice roll: ");
					String input = scanner.nextLine();
					input = input.trim();
					if(Pattern.matches("^\\d\\s\\d$", input)){
						String[] numbers = input.split(" ");
						dice1 = Integer.parseInt(numbers[0]);
						dice2 = Integer.parseInt(numbers[1]);
						if(dice1 < 1 || dice1 > 6 || dice2 < 1 || dice2 > 6){
							System.out.println("Numbers must be between 1 and 6, inclusive.");
						}else break;
					}else{
						System.out.println("You must enter two numbers between 1 and 6 separated by a space.");
					}
				}
			}else{
				System.out.println(String.format("Player rolled %d and %d = %d", dice1, dice2, dice1+dice2));	
			}
			boolean gameContinues = monopoly.dice(dice1, dice2);
			
			if(gameContinues) continue;
			else{
				scanner.close();
				System.exit(0);
			}
		}
	}
}
