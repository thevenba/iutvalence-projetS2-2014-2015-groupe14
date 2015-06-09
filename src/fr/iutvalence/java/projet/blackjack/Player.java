/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * @author thevenba
 *
 */
public class Player
{
	/** the budget by default */
	public static final int BUDGET_DEFAULT = 1000;
	
	/** The insurance by default*/
	public static final int INSURANCE_DEFAULT = 0;

	/** The player's budget*/
	private int budget;
	
	/** The player's insurance*/
	private int insurance;
	
	/** The player's main hand*/
	private Hand mainHand;
	
	/** The player's subsistute hand*/
	private Hand subHand;
	
	/**
	 * Create a player with a budget, an insurance, main hand
	 * and a subsitute hand
	 */
	public Player()
	{
		this.budget = Player.BUDGET_DEFAULT;
		this.insurance = Player.INSURANCE_DEFAULT;
		this.mainHand = new Hand();
		this.subHand = new Hand();
	}

	/**
	 *  Set the bet with a value of one
	 * @throws BudgetNotEnoughException the exception if the budget isn't enough
	 */
	public void setBetOne() throws BudgetNotEnoughException
	{
		if (this.budget < Hand.BET_ONE)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.mainHand.setBet(this.mainHand.getBet() + Hand.BET_ONE);
		this.budget = this.budget - Hand.BET_ONE;
	}
	
	/**
	 * Set the bet with a value of five
	 * @throws BudgetNotEnoughException the exception if the budget isn't enough
	 */
	public void setBetFive() throws BudgetNotEnoughException
	{
		if (this.budget < Hand.BET_FIVE)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.mainHand.setBet(this.mainHand.getBet() + Hand.BET_FIVE);
		this.budget = this.budget - Hand.BET_FIVE;
	}
	
	/**
	 * Set the bet with a value of twenty-five
	 * @throws BudgetNotEnoughException the exception if the budget isn't enough
	 */
	public void setBetTwentyFive() throws BudgetNotEnoughException
	{
		if (this.budget < Hand.BET_TWENTY_FIVE)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.mainHand.setBet(this.mainHand.getBet() + Hand.BET_TWENTY_FIVE);
		this.budget = this.budget - Hand.BET_TWENTY_FIVE;
	}
	
	/**
	 * Set the bet with a value of one hundred
	 * @throws BudgetNotEnoughException the exception if the budget isn't enough
	 */
	public void setBetOneHundred() throws BudgetNotEnoughException
	{
		if (this.budget < Hand.BET_ONE_HUNDRED)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.mainHand.setBet(this.mainHand.getBet() + Hand.BET_ONE_HUNDRED);
		this.budget = this.budget - Hand.BET_ONE_HUNDRED;
	}
	
	/**
	 * Set the bet with a value of five hundred
	 * @throws BudgetNotEnoughException the exception if the budget isn't enough
	 */
	public void setBetFiveHundred() throws BudgetNotEnoughException
	{
		if (this.budget < Hand.BET_FIVE_HUNDRED)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.mainHand.setBet(this.mainHand.getBet() + Hand.BET_FIVE_HUNDRED);
		this.budget = this.budget - Hand.BET_FIVE_HUNDRED;
	}
	
	/**
	 * Get the player's budget
	 * @return budget the player's budget
	 */
	public int getBudget()
	{
		return budget;
	}

	/**
	 * Set the budget with the reward
	 * @param reward the round's rewark
	 */
	public void setBudget(int reward)
	{
		this.budget += reward;
	}
	
	/**
	 * Get the player's main hand
	 * @return the mainHand the player's main hand
	 */
	public Hand getMainHand()
	{
		return mainHand;
	}

	/**
	 * Reset player's hands
	 */
	public void resetHand()
	{
		this.mainHand = new Hand();
		this.subHand = new Hand();
	}
	
	/**
	 * Hit cards from the deck to player's hands
	 * @param deck the game's deck
	 */
	public void deal(Deck deck)
	{
		this.mainHand.hit(deck);
		this.subHand.hit(deck);
	}
	
	/**
	 * Double the Main hand's bet and he can't hit again for this hand
	 * @param deck the game's deck
	 * @throws AlreadyHitException exception when the player has already hit
	 * @throws BudgetNotEnoughException exception when budget isn't enough
	 */
	public void doubleDownMainHand(Deck deck) throws AlreadyHitException, BudgetNotEnoughException
	{
		if (this.budget < this.mainHand.getBet())
			throw new BudgetNotEnoughException("Your budget is not high enough");
		if (this.mainHand.getCards().size() > 2)
			throw new AlreadyHitException("You can not double down if you have already hit");
		this.mainHand.setBet(this.mainHand.getBet()*2);
		this.mainHand.hit(deck);
		if (this.insurance != 0)
			this.insurance = this.insurance + this.mainHand.getBet()/4;
	}
	
	/**
	 * Double the Subtitute hand's bet and he can't hit again for this hand
	 * @param deck the game's deck
	 * @throws AlreadyHitException exception when the player has already hit
	 * @throws BudgetNotEnoughException exception when budget isn't enough
	 */
	public void doubleDownSubHand(Deck deck) throws AlreadyHitException, BudgetNotEnoughException
	{
		if (this.budget < this.subHand.getBet())
			throw new BudgetNotEnoughException("Your budget is not high enough");
		if (this.subHand.getCards().size() > 2)
			throw new AlreadyHitException("You can not double down if you have already hit");
		this.subHand.setBet(this.subHand.getBet()*2);
		this.subHand.hit(deck);
		if (this.insurance != 0)
			this.insurance = this.insurance + this.subHand.getBet()/4;
	}
	
	/**
	 * Separate a player's hand if he has got two cards with the same value
	 * @throws CardsValueNotEqual
	 * @throws BudgetNotEnoughException
	 */
	public void split() throws CardsValueNotEqual, BudgetNotEnoughException
	{
		if (this.mainHand.getCards().get(0).getRank().getValue() != this.mainHand.getCards().get(1).getRank().getValue())
			throw new CardsValueNotEqual("The cards' value is not equal");
		if (this.budget < this.mainHand.getBet())
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.subHand.setBet(this.mainHand.getBet());
		this.subHand.setCards(this.mainHand.getCards().subList(1, 1));
		this.mainHand.removeCard(1);
		if (this.insurance != 0)
			this.insurance = this.insurance + this.subHand.getBet()/2;
	}
	
	/**
	 * 
	 */
	public void insurrance()
	{
		this.insurance = this.mainHand.getBet()/2 + this.subHand.getBet()/2;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Player [budget=" + budget + ", insurance=" + insurance
				+ ", mainHand=" + mainHand + ", subHand=" + subHand + "]";
	}
	
	
}
