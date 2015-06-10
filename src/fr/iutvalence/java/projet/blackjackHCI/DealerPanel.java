/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.projet.blackjack.Dealer;
import fr.iutvalence.java.projet.blackjack.Player;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * @author thevenba
 *
 */
public class DealerPanel extends JPanel
{
	private DealersCards dealersCards;
	private JLabel bankLabel;
	private JSplitPane separator;
	
	/**
	 * @param dealer
	 */
	public DealerPanel(Dealer dealer){
		
		GridLayout layout = new GridLayout(1,1);
		this.setLayout(layout);
		this.dealersCards = new DealersCards(dealer);
		this.bankLabel = new JLabel("Bank");
		this.separator = new JSplitPane(JSplitPane.VERTICAL_SPLIT,this.bankLabel,this.dealersCards);
		this.separator.setEnabled(false);
		this.separator.setResizeWeight(0.1);
		bankLabel.setSize(400,200);
		this.add(this.separator);
	}

	/**
	 * @return the dealersCards
	 */
	public DealersCards getDealersCards()
	{
		return dealersCards;
	}
	
	
}
