/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

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
	
	/** */
	private int budget;
	/** */
	private int bet;
	/** */
	private int insurance;

	/**
	 * 
	 */
	public Player()
	{
		this.budget = Player.BUDGET_DEFAULT;
		this.bet = Player.BET_DEFAULT;
		this.insurance = Player.INSURANCE_DEFAULT;
	}

	/**
	 * @param budget
	 */
	public Player(int budget)
	{
		this.budget = budget;
		this.bet = Player.BET_DEFAULT;
		this.insurance = Player.INSURANCE_DEFAULT;
	}
	
	
}
