/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * Exception when the player doesn't have an ace to switch value
 * @author thevenba
 */
public class InvalidAceException extends Exception
{

	/**
	 * Take the message when the player wants to switch the value of an ace
	 * and he doesn't have ace.
	 * @param message the message to display
	 */
	public InvalidAceException(String message)
	{
		super(message);
	}

}
