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
	/**	*/
	public static final int BUDGET_DEFAULT = 1000;
	/** */
	public static final int INSURANCE_DEFAULT = 0;

	/** */
	private int budget;
	/** */
	private int insurance;
	/** */
	private Hand mainHand;
	/** */
	private Hand subHand;
	
	/**
	 * 
	 */
	public Player()
	{
		this.budget = Player.BUDGET_DEFAULT;
		this.insurance = Player.INSURANCE_DEFAULT;
		this.mainHand = new Hand();
		this.subHand = new Hand();
	}

	/**
	 * @throws BudgetNotEnoughException 
	 */
	public void setBetOne() throws BudgetNotEnoughException
	{
		if (this.budget < Hand.BET_ONE)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.mainHand.setBet(this.mainHand.getBet() + Hand.BET_ONE);
		this.budget = this.budget - Hand.BET_ONE;
	}
	
	/**
	 * @throws BudgetNotEnoughException 
	 */
	public void setBetFive() throws BudgetNotEnoughException
	{
		if (this.budget < Hand.BET_FIVE)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.mainHand.setBet(this.mainHand.getBet() + Hand.BET_FIVE);
		this.budget = this.budget - Hand.BET_FIVE;
	}
	
	/**
	 * @throws BudgetNotEnoughException 
	 */
	public void setBetTwentyFive() throws BudgetNotEnoughException
	{
		if (this.budget < Hand.BET_TWENTY_FIVE)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.mainHand.setBet(this.mainHand.getBet() + Hand.BET_TWENTY_FIVE);
		this.budget = this.budget - Hand.BET_TWENTY_FIVE;
	}
	
	/**
	 * @throws BudgetNotEnoughException 
	 */
	public void setBetOneHundred() throws BudgetNotEnoughException
	{
		if (this.budget < Hand.BET_ONE_HUNDRED)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.mainHand.setBet(this.mainHand.getBet() + Hand.BET_ONE_HUNDRED);
		this.budget = this.budget - Hand.BET_ONE_HUNDRED;
	}
	
	/**
	 * @throws BudgetNotEnoughException 
	 */
	public void setBetFiveHundred() throws BudgetNotEnoughException
	{
		if (this.budget < Hand.BET_FIVE_HUNDRED)
			throw new BudgetNotEnoughException("Your budget is not high enough");
		this.mainHand.setBet(this.mainHand.getBet() + Hand.BET_FIVE_HUNDRED);
		this.budget = this.budget - Hand.BET_FIVE_HUNDRED;
	}
	
	/**
	 * @return the budget
	 */
	public int getBudget()
	{
		return budget;
	}

	public void setBudget(int reward)
	{
		this.budget += reward;
	}
	
	public void resetHand()
	{
		this.mainHand = new Hand();
	}
	
	public void deal(Deck deck)
	{
		this.mainHand.hit(deck);
		this.mainHand.hit(deck);
	}
	
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
