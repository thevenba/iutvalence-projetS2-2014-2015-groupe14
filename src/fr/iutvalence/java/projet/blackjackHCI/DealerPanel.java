/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.projet.blackjack.Dealer;
import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author thevenba
 *
 */
public class DealerPanel extends JPanel
{
	private DealersCards dealersCards;
	private JLabel bankLabel;
	private JSplitPane separator;
	
	private Dealer dealer;
	
	/**
	 * @param dealer
	 */
	public DealerPanel(Dealer dealer){
		this.dealersCards = new DealersCards(dealer);
		this.bankLabel = new JLabel("Bank");
		this.separator = new JSplitPane(JSplitPane.VERTICAL_SPLIT,this.bankLabel,this.dealersCards);
		this.separator.setEnabled(false);
		this.separator.setResizeWeight(0.1);
		this.add(this.separator);
	}
}
