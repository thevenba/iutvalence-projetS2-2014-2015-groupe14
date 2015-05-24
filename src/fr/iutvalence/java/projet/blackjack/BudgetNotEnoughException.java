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
	 * @param message
	 * Return the message of the exception
	 */
	public BudgetNotEnoughException(String message)
	{
		super(message);
	}
}
