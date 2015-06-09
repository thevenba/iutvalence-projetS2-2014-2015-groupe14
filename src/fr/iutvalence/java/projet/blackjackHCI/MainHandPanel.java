/**
 *
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.iutvalence.java.projet.blackjack.Card;
import fr.iutvalence.java.projet.blackjack.Player;
import java.util.ArrayList;

/**
 * @author duboitho
 *
 */
public class MainHandPanel extends JPanel
{

    private final Player player;
    private final List<JButton> mainHand;
    private final boolean isMainHand;

    public MainHandPanel(Player player, boolean isMainHand)
    {
        this.player = player;
        this.mainHand = new ArrayList();
        this.isMainHand = isMainHand;
    }

    public void refreshPlayerMainHand()
    {
        for (JButton buttonToDelete : this.mainHand) {
            this.remove(buttonToDelete);
        }
        List<Card> handToLook;
        if (this.isMainHand) {
            handToLook = this.player.getMainHand().getCards();
        }
        else {
            handToLook = this.player.getSubHand().getCards();
        }
        for (Card CardToAdd : handToLook) {
            JButton buttonToAdd = new JButton("" + CardToAdd);
            this.revalidate();
            this.add(buttonToAdd);
            this.mainHand.add(buttonToAdd);
        }
    }
}
