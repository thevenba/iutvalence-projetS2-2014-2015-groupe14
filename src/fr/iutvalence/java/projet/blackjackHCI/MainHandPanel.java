/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.projet.blackjack.Card;
import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author duboitho
 *
 */
public class MainHandPanel extends JPanel
{
	
	private Player player;
	private List<Card> mainHand;	
	private JButton mainButton = new JButton();
	
	public MainHandPanel(Player player){
		
		this.player=player;
		this.mainHand=this.player.getMainHand().getCards();
		
		for(int i=0;i<mainHand.size();i++)
		{
			this.add(new JButton(""+this.player.getMainHand().getCards().get(i)));
			this.setEnabled(false);
		}
	}
	
	public void refreshPlayerMainHand(){
		this.mainHand=this.player.getMainHand().getCards();
		this.add(new JButton((""+this.player.getMainHand().getCards().get(mainHand.size()))));
	}
}
