/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.projet.blackjack.BudgetNotEnoughException;
import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author thevenba
 *
 */
public class PlayerControl extends JPanel
{
	private Player player;
	private BetButtonsPanel betButtonsPanel;
	private ActionButtonsPanel actionButtonsPanel;
	private JSplitPane separator;
	
	public PlayerControl(Player player, ActionListener buttonsListener)
	{
		this.player = player;
		this.betButtonsPanel = new BetButtonsPanel(buttonsListener);
		this.actionButtonsPanel = new ActionButtonsPanel(buttonsListener, player);
		this.separator = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.betButtonsPanel, this.actionButtonsPanel);
		this.separator.setEnabled(false);
		this.separator.setResizeWeight(1.0);
		this.add(this.separator);
	}

	
	
	/**
	 * @return the betButtonsPanel
	 */
	public BetButtonsPanel getBetButtonsPanel()
	{
		return betButtonsPanel;
	}



	/**
	 * @return the actionButtonsPanel
	 */
	public ActionButtonsPanel getActionButtonsPanel()
	{
		return actionButtonsPanel;
	}
}
