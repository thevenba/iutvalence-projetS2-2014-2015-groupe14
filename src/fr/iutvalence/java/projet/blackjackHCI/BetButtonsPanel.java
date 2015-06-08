/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author thevenba
 *
 */
public class BetButtonsPanel extends JPanel
{
	private JButton betOne;
	private JButton betFive;
	private JButton betTwentyFive;
	private JButton betOneHundred;
	private JButton betFiveHundred;
	
	public BetButtonsPanel(ActionListener buttonsListener)
	{
		this.betOne = new JButton("1");
		this.betOne.addActionListener(buttonsListener);
		this.betFive = new JButton("5");
		this.betFive.addActionListener(buttonsListener);
		this.betTwentyFive = new JButton("25");
		this.betTwentyFive.addActionListener(buttonsListener);
		this.betOneHundred = new JButton("100");
		this.betOneHundred.addActionListener(buttonsListener);
		this.betFiveHundred = new JButton("500");
		this.betFiveHundred.addActionListener(buttonsListener);
		this.setLayout(new GridLayout(1, 5));
		this.add(this.betOne);
		this.add(this.betFive);
		this.add(this.betTwentyFive);
		this.add(this.betOneHundred);
		this.add(this.betFiveHundred);
	}

	/**
	 * @return the betOne
	 */
	public JButton getBetOne()
	{
		return betOne;
	}

	/**
	 * @return the betFive
	 */
	public JButton getBetFive()
	{
		return betFive;
	}

	/**
	 * @return the betTwentyFive
	 */
	public JButton getBetTwentyFive()
	{
		return betTwentyFive;
	}

	/**
	 * @return the betOneHundred
	 */
	public JButton getBetOneHundred()
	{
		return betOneHundred;
	}

	/**
	 * @return the betFiveHundred
	 */
	public JButton getBetFiveHundred()
	{
		return betFiveHundred;
	}
}
