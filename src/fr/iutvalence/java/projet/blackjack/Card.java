/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * @author thevenba
 *
 */
public class Card
{
	private Suit suit;
	
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * @return the rank
	 */
	public Rank getRank()
	{
		return rank;
	}
	
	/**
	 * @throws InvalidAceException 
	 * 
	 */
	public void switchAceValue()
	{
		this.rank.setValue(1);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Card [suit=" + suit + ", rank=" + rank + "]";
	}
	
	
	
	
}
	
