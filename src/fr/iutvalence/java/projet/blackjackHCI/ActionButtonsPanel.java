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
public class ActionButtonsPanel extends JPanel
{
	private Player player;
	private JButton deal;
	private JButton hit;
	private JButton doubleDown;
	private JButton insurrance;
	private JButton split;
	private JButton stand;
	
	public ActionButtonsPanel(ActionListener buttonsListener, Player player)
	{
		this.player = player;
		this.deal = new JButton("Deal");
		this.deal.setEnabled(false);
		this.deal.addActionListener(buttonsListener);
		this.hit = new JButton("Hit");
		this.hit.setEnabled(false);
		this.hit.addActionListener(buttonsListener);
		this.doubleDown = new JButton("Double Down");
		this.doubleDown.setEnabled(false);
		this.doubleDown.addActionListener(buttonsListener);
		this.insurrance = new JButton("Insurrance");
		this.insurrance.setEnabled(false);
		this.insurrance.addActionListener(buttonsListener);
		this.split = new JButton("Split");
		this.split.setEnabled(false);
		this.split.addActionListener(buttonsListener);
		this.stand = new JButton("Stand");
		this.stand.setEnabled(false);
		this.stand.addActionListener(buttonsListener);
		this.setLayout(new GridLayout(1, 6));
		this.add(this.deal);
		this.add(this.hit);
		this.add(this.doubleDown);
		this.add(this.insurrance);
		this.add(this.split);
		this.add(this.stand);
	}

	/**
	 * @return the deal
	 */
	public JButton getDeal()
	{
		return this.deal;
	}

	/**
	 * @return the hit
	 */
	public JButton getHit()
	{
		return this.hit;
	}

	/**
	 * @return the doubleDown
	 */
	public JButton getDoubleDown()
	{
		return this.doubleDown;
	}

	/**
	 * @return the insurrance
	 */
	public JButton getInsurrance()
	{
		return this.insurrance;
	}

	/**
	 * @return the split
	 */
	public JButton getSplit()
	{
		return this.split;
	}

	/**
	 * @return the stand
	 */
	public JButton getStand()
	{
		return this.stand;
	}
}
