/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * @author thevenba
 *
 */
public enum Rank
{

	ACE(11),
	
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
	
	private int value;
	
	private Rank(int value)
	{
		this.setValue(value);
	}

	/**
	 * @return the value
	 */
	public int getValue()
	{
		return this.value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value)
	{
		this.value = value;
	}
}
