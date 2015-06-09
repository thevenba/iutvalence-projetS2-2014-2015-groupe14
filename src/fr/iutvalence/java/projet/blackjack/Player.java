/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author thevenba
 * The player of BlackJack
 */
public class Player
{
	/** The budget by default 	*/
	public static final int BUDGET_DEFAULT = 1000;
	
	/** The bet by default*/
	public static final int BET_DEFAULT = 0;
	
	/**  The insurance by default*/
	public static final int INSURANCE_DEFAULT = 0;
	
	/** The Bet with value of 5 */
	private static final int BET_FIVE = 5;
	
	/** The Bet with value of 1 */
	private static final int BET_ONE = 1;
	
	/** The Bet with value of 25 */
	private static final int BET_TWENTY_FIVE = 25;
	
	/** The Bet with value of 100 */
	private static final int BET_ONE_HUNDRED = 100;
	
	/** The Bet with value of 500 */
	private static final int BET_FIVE_HUNDRED = 500;
	
	/**  The Player's budget*/
	private int budget;
	
	/**  The player's bet*/
	private int bet;
	
	/** The Player's insurance*/
	private int insurance;
	
	/** The player's hand*/
	public List<Card> hand;
	
	/**
	 * Create a player with a budget, a bet, an insurance
	 * and a hand.
	 */
	public Player()
	{
		this.budget = Player.BUDGET_DEFAULT;
		this.bet = Player.BET_DEFAULT;
		this.insurance = Player.INSURANCE_DEFAULT;
		this.hand = new LinkedList<>();
	}

	/**
	 * Get the player's bet
	 * @return bet the player's bet
	 */
	public int getBet()
	{
		return this.bet;
	}

	/**
	 * Reset the player's bet
	 * @param bet the bet to set
	 */
	public void resetBet()
	{
		this.bet = Player.BET_DEFAULT;
	}

	/**
	 * Take a bet with a value of 1
	 * @throws BudgetNotEnoughException exception if budget is not enough
	 */
	public void setBetOne() throws BudgetNotEnoughException
	{
		if (this.budget < Player.BET_ONE)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.bet = this.bet + Player.BET_ONE;
		this.budget = this.budget - Player.BET_ONE;
	}
	
	/**
	 * Take a bet with a value of 5
	 * @throws BudgetNotEnoughException exception if budget is not enough
	 */
	public void setBetFive() throws BudgetNotEnoughException
	{
		if (this.budget < Player.BET_FIVE)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.bet = this.bet + Player.BET_FIVE;
		this.budget = this.budget - Player.BET_FIVE;
	}
	
	/**
	 * Take a bet with a value of 25 
	 * @throws BudgetNotEnoughException exception if budget is not enough
	 */
	public void setBetTwentyFive() throws BudgetNotEnoughException
	{
		if (this.budget < Player.BET_TWENTY_FIVE)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.bet = this.bet + Player.BET_TWENTY_FIVE;
		this.budget = this.budget - Player.BET_TWENTY_FIVE;
	}
	
	/**
	 * Take a bet with a value of 100 
	 * @throws BudgetNotEnoughException exception if budget is not enough
	 */
	public void setBetOneHundred() throws BudgetNotEnoughException
	{
		if (this.budget < Player.BET_ONE_HUNDRED)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.bet = this.bet + Player.BET_ONE_HUNDRED;
		this.budget = this.budget - Player.BET_ONE_HUNDRED;
	}
	
	/**
	 * Take a bet with a value of 500
	 * @throws BudgetNotEnoughException exception if budget is not enough
	 */
	public void setBetFiveHundred() throws BudgetNotEnoughException
	{
		if (this.budget < Player.BET_FIVE_HUNDRED)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.bet = this.bet + Player.BET_FIVE_HUNDRED;
		this.budget = this.budget - Player.BET_FIVE_HUNDRED;
	}
	
	/**
	 * Take the player's budget
	 * @return budget the player's budget
	 */
	public int getBudget()
	{
		return budget;
	}
	
	/**
	 * Add the reward in budget
	 * @param reward the reward of the round 
	 */
	public void setBudget(int reward)
	{
		this.budget += reward;
	}
	
	/**
	 * Reset the player's hand
	 */
	public void resetHand()
	{
		this.hand = new LinkedList<>();
	}
	
	/**
	 *  Take cards from the deck
	 * @param deck the list of cards in game
	 */
	public void deal(Deck deck)
	{
		this.hit(deck);
		this.hit(deck);
	}
	
	/**
	 * Take a random card from the deck to the hand of player
	 * @param deck the list of cards in game
	 */
	public void hit(Deck deck)
	{
		this.hand.add(deck.randomCard());
	}
	
	/**
	 *  The player pay the double of the bet
	 * @param deck the list of cards in game
	 * @throws BudgetNotEnoughException exception if budget is not enough
	 */
	public void doubleDown(Deck deck) throws BudgetNotEnoughException
	{
		if (this.budget < this.bet)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.budget = this.budget - this.bet;
		this.bet = this.bet*2;
		this.hit(deck);
	}
	
	/**
	 *  Take the player's score
	 * @return score the player's score
	 */
	public int reckonScore()
	{
		int score = 0;
		for (int cardIndex = 0; cardIndex < this.hand.size(); cardIndex++)
			score += this.hand.get(cardIndex).getRank().getValue();
		return score;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Player [budget=" + budget + ", bet=" + bet + ", hand=" + hand
				+ "]";
	}
	
	
}
