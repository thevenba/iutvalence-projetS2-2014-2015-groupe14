/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * Exception when budget is not enough
 * @author thevenba
 */
public class BudgetNotEnoughException extends Exception
{
	/**
	 * Take a message when budget is not enough
	 * @param message the message to display
	 */
	public BudgetNotEnoughException(String message)
	{
		super(message);
	}
}
