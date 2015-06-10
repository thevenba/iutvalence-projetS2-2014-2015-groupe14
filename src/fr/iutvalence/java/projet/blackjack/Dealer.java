package fr.iutvalence.java.projet.blackjack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author thevenba
 *
 */
public class Dealer
{
	public Hand hand;
	
	public Dealer()
	{
		this.hand = new Hand();
	}
	
	public void resetHand()
	{
		this.hand = new Hand();
	}
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Dealer [hand=" + hand + "]";
	}

	public Hand getHand()
	{
		return this.hand;
	}
}
