/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

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

	public PlayerPanel(Player player){
		this.playerDisplay = new PlayerDisplay();
	}
}
