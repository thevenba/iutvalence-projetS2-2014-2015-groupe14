/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * @author thevenba
 *
 */
public enum Card
{
	CLUBS_ACE(1),
	
	CLUBS_TWO(2),
	
	CLUBS_THREE(3),
	
	CLUBS_FOUR(4),
	
	CLUBS_FIVE(5),
	
	CLUBS_SIX(6),
	
	CLUBS_SEVEN(7),
	
	CLUBS_EIGHT(8),
	
	CLUBS_NINE(9),
	
	CLUBS_TEN(10),
	
	CLUBS_JACK(10),
	
	CLUBS_QUEEN(10),
	
	CLUBS_KING(10),
	
	DIAMONDS_ACE(1),
	
	DIAMONDS_TWO(2),
	
	DIAMONDS_THREE(3),
	
	DIAMONDS_FOUR(4),
	
	DIAMONDS_FIVE(5),
	
	DIAMONDS_SIX(6),
	
	DIAMONDS_SEVEN(7),
	
	DIAMONDS_EIGHT(8),
	
	DIAMONDS_NINE(9),
	
	DIAMONDS_TEN(10),
	
	DIAMONDS_JACK(10),
	
	DIAMONDS_QUEEN(10),
	
	DIAMONDS_KING(10),
	
	HEARTS_ACE(1),
	
	HEARTS_TWO(2),
	
	HEARTS_THREE(3),
	
	HEARTS_FOUR(4),
	
	HEARTS_FIVE(5),
	
	HEARTS_SIX(6),
	
	HEARTS_SEVEN(7),
	
	HEARTS_EIGHT(8),
	
	HEARTS_NINE(9),
	
	HEARTS_TEN(10),
	
	HEARTS_JACK(10),
	
	HEARTS_QUEEN(10),
	
	HEARTS_KING(10),
	
	SPADES_ACE(1),
	
	SPADES_TWO(2),
	
	SPADES_THREE(3),
	
	SPADES_FOUR(4),
	
	SPADES_FIVE(5),
	
	SPADES_SIX(6),
	
	SPADES_SEVEN(7),
	
	SPADES_EIGHT(8),
	
	SPADES_NINE(9),
	
	SPADES_TEN(10),
	
	SPADES_JACK(10),
	
	SPADES_QUEEN(10),
	
	SPADES_KING(10);
	
	private int rank;
	
	Card(int rank) {
		this.rank = rank;
	}

	/**
	 * @return the rank
	 */
	public int getRank()
	{
		return this.rank;
	}

	/**
	 * 
	 */
	public void switchAceRank()
	{
		if ((this != CLUBS_ACE) || (this != DIAMONDS_ACE) || (this != HEARTS_ACE) || (this != SPADES_ACE))
			return;
		if (this.rank == 1)
			this.rank = 11;
		else
			this.rank = 1;
	}
	
	
}
	
