/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author thevenba
 *
 */
public class Player
{
	/**	*/
	public static final int BUDGET_DEFAULT = 1000;
	/** */
	public static final int BET_DEFAULT = 0;
	/** */
	public static final int INSURANCE_DEFAULT = 0;
	private static final int BET_FIVE = 5;
	private static final int BET_ONE = 1;
	private static final int BET_TWENTY_FIVE = 25;
	private static final int BET_ONE_HUNDRED = 100;
	private static final int BET_FIVE_HUNDRED = 500;
	
	/** */
	private int budget;
	/** */
	private int bet;
	/** */
	private int insurance;
	
	public Set<Card> hand;
	/**
	 * 
	 */
	public Player()
	{
		this.budget = Player.BUDGET_DEFAULT;
		this.bet = Player.BET_DEFAULT;
		this.insurance = Player.INSURANCE_DEFAULT;
		this.hand = new HashSet<>();
	}

	/**
	 * @param budget
	 */
	public Player(int budget)
	{
		this.budget = budget;
		this.bet = Player.BET_DEFAULT;
		this.insurance = Player.INSURANCE_DEFAULT;
		this.hand = new HashSet<>();
	}

	/**
	 * @return the bet
	 */
	public int getBet()
	{
		return this.bet;
	}

	/**
	 * @throws BudgetNotEnoughException 
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
	 */
	public void setBetFiveHundred() throws BudgetNotEnoughException
	{
		if (this.budget < Player.BET_FIVE_HUNDRED)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.bet = this.bet + Player.BET_FIVE_HUNDRED;
		this.budget = this.budget - Player.BET_FIVE_HUNDRED;
	}
	
	public void deal()
	{
		this.hit();
		this.hit();
	}
	
	public boolean hit()
	{
		/* TODO remplacer par générateur aléatoir */
		return this.hand.add(new Card(Suit.SPADES, Rank.JACK));
	}
	
	public void doubleDown() throws BudgetNotEnoughException
	{
		if (this.budget < this.bet)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.budget = this.budget - this.bet;
		this.bet = this.bet*2;
		this.hit();
	}
	
}
