package edu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
* Test Case to try if the Monopoly bonus game works correctly
* 
* @author: Sergio Penavades Suarez 
* @version: 1
*/
public class MonopolyTest {

	private Monopoly game;
	
	@Before
	public void setUp() throws Exception {
		game = new Monopoly();
		game.resetCountRailroad();
	}
	
	//Checks if the player rolls a 12, it will land on the electric company which awards 12*5=60 credits
	@Test
	public void landingOnCompanySpace() {
		//Given
		int dice1 = 6;
		int dice2 = 6;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(60,game.getCredits());
		assertEquals(12,game.getPosition());
	}
	
	//Checks if the player rolls a 10,lands in the space 20 by landing on the free parking which
	//will award the user 0 credits.
	@Test
	public void landingOnFreeParking() {
		//Given
		int dice1 = 5;
		int dice2 = 5;
		//When
		game.setPosition(10);
		game.dice(dice1, dice2);
		//Then
		assertEquals(0,game.getCredits());
		assertEquals(20,game.getPosition());
	}
	
	//Checks if the user lands on the go space awarding the user 200 credits by rolling 10
	//on the dice starting at the position 30.
	@Test
	public void landingOnGoSpace() {
		//Given
		int dice1 = 5;
		int dice2 = 5;
		//When
		game.setPosition(30);
		game.dice(dice1, dice2);
		//Then
		assertEquals(200,game.getCredits());
		assertEquals(0,game.getPosition());
	}
	
	//Checks if the player will land on Mediterranean Avenue by rolling a 10, starting in the position 31
	//and is awarded 200 credits as it passed through the go space.
	@Test
	public void landingGreaterThanOnGoSpace() {
		//Given
		int dice1 = 5;
		int dice2 = 5;
		//When
		game.setPosition(31);
		game.dice(dice1, dice2);
		//Then
		assertEquals(200,game.getCredits());
		assertEquals(1,game.getPosition());
	}
	
	//Checks if the player will land on the Jail Space by rolling a 10, starting in the position 20
	//is awarded 0 credits and goes back to the position 10 in the game board.
	@Test
	public void landingOnGoToJailSpace() {
		//Given
		int dice1 = 5;
		int dice2 = 5;
		//When
		game.setPosition(20);
		game.dice(dice1, dice2);
		//Then
		assertEquals(0,game.getCredits());
		assertEquals(10,game.getPosition());
	}
	
	
	//Checks if the player will land on the Visiting Jail Space by rolling a 10, starting in the position 0
	//is awarded 0 credits and stays in the position 10 in the game board.
	
	@Test
	public void landingOnVisitingJailSpace() {
		//Given
		int dice1 = 5;
		int dice2 = 5;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(0,game.getCredits());
		assertEquals(10,game.getPosition());
	}
	
	
	//Checks if the player will land on a property space (Baltic Avenue) by rolling a 3, 
	//starting in the position 0 is awarded 60 credits.
	@Test
	public void landingOnPropertyOrTaxSpace() {
		//Given
		int dice1 = 1;
		int dice2 = 2;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(60,game.getCredits());
		assertEquals(3,game.getPosition());
	}
	
	//Checks if the player will land on a Railroad Space (Reading Railroad) by rolling a 5, 
	//starting in the position 0 is awarded 200 credits.
	@Test
	public void landingOnRailroadSpace() {
		//Given
		int dice1 = 3;
		int dice2 = 2;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(200,game.getCredits());
		assertEquals(5,game.getPosition());
	}
	
	//Checks if the player will be awarded 200, 400, 600 and 800 credits when it lands on a railroad
	//space starting in the position 0.
	@Test
	public void railroadRule() {
		//---Roll 1---
		//Given
		int dice1 = 3;
		int dice2 = 2;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(200,game.getCredits());
		assertEquals(5,game.getPosition());
		//---Roll 2---
		//Given
		dice1 = 5;
		dice2 = 5;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(600,game.getCredits());
		assertEquals(15,game.getPosition());
		//---Roll 3---
		//Given
		dice1 = 5;
		dice2 = 5;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(1200,game.getCredits());
		assertEquals(25,game.getPosition());
		//---Roll 4---
		//Given
		dice1 = 5;
		dice2 = 5;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(2000,game.getCredits());
		assertEquals(35,game.getPosition());
	}
	
	//Checks if the player will land on a chance space by rolling a 7, starting in the position 0
	// and testing all of the possibilities from the 5 available.
	@Test
	public void fiveKindsOfchanceRule() {
		//Given
		int dice1 = 3;
		int dice2 = 4;
		int numberOfStatesTested=0;
		int positionGoJail=0, creditsGoJail=0;
		int positionGet50Credits=0, creditsGet50Credits=0; 
		int positionBack3Spaces=0, creditsBack3Spaces=0;
		int positionGet10Credits=0, creditsGet10Credits=0;
		int positionGet100Credits=0, creditsGet100Credits=0;
		boolean goTOJail = false;
		boolean get50Credits = false;
		boolean back3Spaces = false;
		boolean get10Credits = false;
		boolean get100Credits = false;
		//When
		while(true){
			game.setPosition(0);
			game.setCredits(0);
			game.dice(dice1, dice2);
			
			if (game.getChanceSpace().equals("GO_JAIL") && goTOJail == false){
				numberOfStatesTested++;
				goTOJail = true;
				positionGoJail=game.getPosition();
				creditsGoJail=game.getCredits();
			} else if (game.getChanceSpace().equals("GET_50_CREDITS") && get50Credits == false){
				numberOfStatesTested++;
				get50Credits = true;
				positionGet50Credits=game.getPosition();
				creditsGet50Credits=game.getCredits();
			} else if (game.getChanceSpace().equals("BACK_3_SPACES") && back3Spaces == false){
				numberOfStatesTested++;
				back3Spaces = true;
				positionBack3Spaces=game.getPosition();
				creditsBack3Spaces=game.getCredits();
			} else if (game.getChanceSpace().equals("GET_10_CREDITS") && get10Credits == false ){
				numberOfStatesTested++;
				get10Credits = true;
				positionGet10Credits=game.getPosition();
				creditsGet10Credits=game.getCredits();
			} else if (game.getChanceSpace().equals("GET_100_CREDITS") && get100Credits == false){
				numberOfStatesTested++;
				get100Credits = true;
				positionGet100Credits=game.getPosition();
				creditsGet100Credits=game.getCredits();
			} 
			if (numberOfStatesTested ==5) break;
		}
		//Then
		assertEquals(10,positionGoJail);
		assertEquals(0,creditsGoJail);
		assertEquals(7,positionGet50Credits);
		assertEquals(50,creditsGet50Credits);
		assertEquals(4,positionBack3Spaces);
		assertEquals(0,creditsBack3Spaces);
		assertEquals(7,positionGet10Credits);
		assertEquals(10,creditsGet10Credits);
		assertEquals(7,positionGet100Credits);
		assertEquals(100,creditsGet100Credits);	
	}
	
	//Checks if the player will land on a community chest space by rolling a 2, starting in the position 0
	// and testing all of the possibilities from the 5 available.
	@Test
	public void fiveKindsOfCommunityChestRule() {
		//Given
		int dice1 = 1;
		int dice2 = 1;
		int numberOfStatesTested=0;
		int positionGet200Credits=0, creditsGet200Credits=0;
		int positionGet50Credits=0, creditsGet50Credits=0;
		int positionGoJail=0, creditsGoJail=0;
		int positionGet100Credits=0, creditsGet100Credits=0;
		int positionGet20Credits=0, creditsGet20Credits=0;
		boolean get200Credits = false;
		boolean get50Credits = false;
		boolean goJail = false;
		boolean get100Credits = false;
		boolean get20Credits = false;
		//When
		while(true){
			game.setPosition(0);
			game.setCredits(0);
			game.dice(dice1, dice2);
			
			if (game.getCommunityChestSpace().equals("GET_200_CREDITS") && get200Credits == false){
				numberOfStatesTested++;
				get200Credits = true;
				positionGet200Credits=game.getPosition();
				creditsGet200Credits=game.getCredits();
			} else if (game.getCommunityChestSpace().equals("GET_50_CREDITS") && get50Credits == false){
				numberOfStatesTested++;
				get50Credits = true;
				positionGet50Credits=game.getPosition();
				creditsGet50Credits=game.getCredits();
			} else if (game.getCommunityChestSpace().equals("GO_JAIL") && goJail == false){
				numberOfStatesTested++;
				goJail = true;
				positionGoJail=game.getPosition();
				creditsGoJail=game.getCredits();
			} else if (game.getCommunityChestSpace().equals("GET_100_CREDITS") && get100Credits == false ){
				numberOfStatesTested++;
				get100Credits = true;
				positionGet100Credits=game.getPosition();
				creditsGet100Credits=game.getCredits();
			} else if (game.getCommunityChestSpace().equals("GET_20_CREDITS") && get20Credits == false){
				numberOfStatesTested++;
				get20Credits = true;
				positionGet20Credits=game.getPosition();
				creditsGet20Credits=game.getCredits();
			} 
			if (numberOfStatesTested ==5) break;
		}
		//Then
		assertEquals(2,positionGet200Credits);
		assertEquals(200,creditsGet200Credits);
		assertEquals(2,positionGet50Credits);
		assertEquals(50,creditsGet50Credits);
		assertEquals(10,positionGoJail);
		assertEquals(0,creditsGoJail);
		assertEquals(2,positionGet100Credits);
		assertEquals(100,creditsGet100Credits);
		assertEquals(2,positionGet20Credits);
		assertEquals(20,creditsGet20Credits);	
	}
	
	//Checks if what happens when the player finishes the whole bonus round.
	@Test
	public void completeBonusRound() {
		//---Roll 1---
		//Given
		int dice1 = 6;
		int dice2 = 6;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(60,game.getCredits());
		assertEquals(12,game.getPosition());
		//---Roll 2---
		//Given
		dice1 = 2;
		dice2 = 1;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(260,game.getCredits());
		assertEquals(15,game.getPosition());
		//---Roll 3---
		//Given
		dice1 = 1;
		dice2 = 2;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(440,game.getCredits());
		assertEquals(18,game.getPosition());
		//---Roll 4---
		//Given
		dice1 = 6;
		dice2 = 5;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(720,game.getCredits());
		assertEquals(29,game.getPosition());	
		//---Roll 5---
		//Given
		dice1 = 5;
		dice2 = 6;
		//When
		game.dice(dice1, dice2);
		//Then
		assertEquals(920,game.getCredits());
		assertEquals(0,game.getPosition());
	}
	
}
