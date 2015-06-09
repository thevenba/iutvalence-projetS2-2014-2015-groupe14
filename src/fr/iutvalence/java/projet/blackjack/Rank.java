/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * Card's rank
 * @author thevenba
 */
public enum Rank
{

	ACE(1),
	
	KING(10),
	
	QUEEN(10),
	
	JACK(10),
	
	TEN(10),
	
	NINE(9),
	
	EIGHT(8),
	
	SEVEN(7),
	
	SIX(6),
	
	FIVE(5),
	
	FOUR(4),
	
	THREE(3),
	
	TWO(2);
	
	/** The card's value */
	private int value;
	
	/**
	 * Give the value to the rank
	 * @param value the card's value
	 */
	private Rank(int value)
	{
		this.setValue(value);
	}

	/**
	 * Get the card's value
	 * @return value the card's value 
	 */
	public int getValue()
	{
		return this.value;
	}

	/**
	 * Set the card's value
	 * @param value the value to set
	 */
	public void setValue(int value)
	{
		this.value = value;
	}
}
