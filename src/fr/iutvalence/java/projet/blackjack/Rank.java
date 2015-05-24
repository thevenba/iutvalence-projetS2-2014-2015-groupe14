/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * @author thevenba
 * The enumeration of all Rank's cards
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
	
	/** The value of a card */
	private int value;
	
	/** Constructor of Rank*/
	private Rank(int value)
	{
		this.setValue(value);
	}

	/**
	 * Take the value of the card
	 * @return the value
	 */
	public int getValue()
	{
		return this.value;
	}

	/**
	 * @param value the value to set
	 * Take the value of this card
	 */
	public void setValue(int value)
	{
		this.value = value;
	}
}
