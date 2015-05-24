/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * @author thevenba
 * Exception of Ace in the method switchAceValue()
 */
public class InvalidAceException extends Exception
{

	public InvalidAceException(String message)
	{
		super(message);
	}

}
