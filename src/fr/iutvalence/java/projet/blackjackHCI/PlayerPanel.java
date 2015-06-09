/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.projet.blackjack.Player;

import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author thevenba
 *
 */
public class PlayerPanel extends JPanel
{
	private PlayerDisplay playerDisplay;
	private PlayerControl playerControl;
	private JSplitPane separator;
	private Player player;

	public PlayerPanel(Player player, ActionListener buttonsListener)
	{
		this.playerControl = new PlayerControl(player, buttonsListener);
		this.playerDisplay = new PlayerDisplay(player);
		this.separator = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.playerDisplay, this.playerControl);
		this.separator.setEnabled(false);
		this.separator.setResizeWeight(1.0);
		this.add(this.separator);
	}

	/**
	 * @return the playerDisplay
	 */
	public PlayerDisplay getPlayerDisplay()
	{
		return playerDisplay;
	}

	/**
	 * @return the playerControl
	 */
	public PlayerControl getPlayerControl()
	{
		return playerControl;
	}
}
