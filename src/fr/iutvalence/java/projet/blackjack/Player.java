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
	
	/**  The budget of Player*/
	private int budget;
	
	/**  The bet of player*/
	private int bet;
	
	/** The insurance of Player*/
	private int insurance;
	
	/** The hand of the player*/
	public List<Card> hand;
	/**
	 * Constructor of the player
	 */
	public Player()
	{
		this.budget = Player.BUDGET_DEFAULT;
		this.bet = Player.BET_DEFAULT;
		this.insurance = Player.INSURANCE_DEFAULT;
		this.hand = new LinkedList<>();
	}

	/**
	 * Take the bet of the player
	 * @return the bet
	 */
	public int getBet()
	{
		return this.bet;
	}

	/**
	 * @param bet the bet to set
	 * Reset the bet of player
	 */
	public void resetBet()
	{
		this.bet = Player.BET_DEFAULT;
	}

	/**
	 * @throws BudgetNotEnoughException 
	 *  Take a bet withe a value of 1
	 */
	public void setBetOne() throws BudgetNotEnoughException
	{
		if (this.budget < Player.BET_ONE)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.bet = this.bet + Player.BET_ONE;
		this.budget = this.budget - Player.BET_ONE;
	}
	
	/**
	 * @throws BudgetNotEnoughException
	 * Take a bet withe a value of 5
	 */
	public void setBetFive() throws BudgetNotEnoughException
	{
		if (this.budget < Player.BET_FIVE)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.bet = this.bet + Player.BET_FIVE;
		this.budget = this.budget - Player.BET_FIVE;
	}
	
	/**
	 * @throws BudgetNotEnoughException
	 * Take a bet withe a value of 25 
	 */
	public void setBetTwentyFive() throws BudgetNotEnoughException
	{
		if (this.budget < Player.BET_TWENTY_FIVE)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.bet = this.bet + Player.BET_TWENTY_FIVE;
		this.budget = this.budget - Player.BET_TWENTY_FIVE;
	}
	
	/**
	 * @throws BudgetNotEnoughException
	 * Take a bet withe a value of 100 
	 */
	public void setBetOneHundred() throws BudgetNotEnoughException
	{
		if (this.budget < Player.BET_ONE_HUNDRED)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.bet = this.bet + Player.BET_ONE_HUNDRED;
		this.budget = this.budget - Player.BET_ONE_HUNDRED;
	}
	
	/**
	 * @throws BudgetNotEnoughException 
	 * Take a bet withe a value of 500
	 */
	public void setBetFiveHundred() throws BudgetNotEnoughException
	{
		if (this.budget < Player.BET_FIVE_HUNDRED)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.bet = this.bet + Player.BET_FIVE_HUNDRED;
		this.budget = this.budget - Player.BET_FIVE_HUNDRED;
	}
	
	/**
	 * Take the budget of player
	 * @return the budget
	 */
	public int getBudget()
	{
		return budget;
	}
	
	/**
	 * 
	 * @param bet
	 * Add the bet in budget
	 */
	public void setBudget(int bet)
	{
		this.budget += bet;
	}
	
	/**
	 * Reset the hand of player
	 */
	public void resetHand()
	{
		this.hand = new LinkedList<>();
	}
	
	/**
	 *  Take cards from the deck
	 * @param deck
	 */
	public void deal(Deck deck)
	{
		this.hit(deck);
		this.hit(deck);
	}
	
	/**
	 * Take a random card from the deck to the hand of player
	 * @param deck
	 */
	public void hit(Deck deck)
	{
		this.hand.add(deck.randomCard());
	}
	
	/**
	 *  The player pay the double of the bet
	 * @param deck
	 * @throws BudgetNotEnoughException
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
	 *  Take the score of the player
	 * @return score of player
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
