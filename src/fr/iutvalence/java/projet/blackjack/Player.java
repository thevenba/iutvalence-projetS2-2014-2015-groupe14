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
	 * @param bet the bet to set
	 */
	public void setBet(int bet)
	{
		this.bet = bet;
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
	
	public void doubleDown()
	{
		this.setBet(this.bet*2);
		this.hit();
	}
	
}
