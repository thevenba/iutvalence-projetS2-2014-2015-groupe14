/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * @author thevenba
 * Exception of budget
 */
public class BudgetNotEnoughException extends Exception
{
	/**
	 * Return the exception's message
	 * @param message the message to display
	 */
	public BudgetNotEnoughException(String message)
	{
		super(message);
	}
}
