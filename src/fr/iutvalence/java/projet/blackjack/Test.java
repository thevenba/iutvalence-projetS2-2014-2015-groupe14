package fr.iutvalence.java.projet.blackjack;

import junit.framework.*;

public class Test extends TestCase {
	
	public Test(String name){
		super(name);
	}
	
	public void testBudget() throws BudgetNotEnoughException {
		Player p1 = new Player();
		int budget = Player.BUDGET_DEFAULT;
		p1.setBetFiveHundred();
		p1.setBetFiveHundred();
		assertEquals(budget, budget);
		
		
	}
	
	public void testChoix() throws InvalideChoiceException {
		
	}
	
	public void testAce() throws CardsValueNotEqual, BudgetNotEnoughException {
		//Player p3 = new Player();
		//Card c1 = new Card(Suit.CLUBS, Rank.EIGHT);
		//Card c2 = new Card(Suit.DIAMONDS, Rank.EIGHT);
		//p1.getMainHand().getCards().add(new Card(Suit.CLUBS, Rank.EIGHT));
		//p1.getMainHand().getCards().add(new Card(Suit.DIAMONDS, Rank.EIGHT));
		//p1.split();
		//assertEquals(p1.getSubHand().getCards().get(0), c2);
		//assertEquals(p1.getMainHand().getCards().get(0), c1);
		
		
		
	}
	
	public void testCardsValueEqual() throws InvalidAceException {
		
	}
	
	public void testHit() throws AlreadyHitException {
		
	}

}
