package it.polimi.ingsw;

import it.polimi.ingsw.model.AssistantCard;
import it.polimi.ingsw.model.Parameters;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.model.enumeration.Colour;
import it.polimi.ingsw.model.enumeration.TowerColour;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;



public class PlayerTest extends TestCase {

    @Test
    public void testPlayer(){
        Parameters.setParameters(3,true);
        Player p1 = new Player("mef", 1);
        Player p2 = new Player("gius", 2);
        Player p3 = new Player("nico", 3);

        assertEquals(1, p1.getIndex());
        assertEquals(2, p2.getIndex());
        assertEquals(3, p3.getIndex());

        assertEquals(TowerColour.values()[0], p1.PlayerTowerColor());
        assertEquals(p1.PlayerTowerColor(), p1.getPlayerSchoolBoard().getTowerColor());
        assertEquals(TowerColour.values()[1], p2.PlayerTowerColor());
        assertEquals(p2.PlayerTowerColor(), p2.getPlayerSchoolBoard().getTowerColor());
        assertEquals(TowerColour.values()[2], p3.PlayerTowerColor());
        assertEquals(p3.PlayerTowerColor(), p3.getPlayerSchoolBoard().getTowerColor());

        assertEquals(1, p1.getCoins());
        p2.addCoin();
        assertEquals(2, p2.getCoins());
        for(int i=0; i<10; i++)
            p3.addCoin();
        assertEquals(11, p3.getCoins());

        assertEquals(10, p1.getAssistantDeck().size());
        assertEquals(10, p2.getAssistantDeck().size());
        assertEquals(10, p3.getAssistantDeck().size());

        assertEquals(3, p1.getAssistantDeck().get(2).getValue());
        assertEquals(2, p1.getAssistantDeck().get(2).getMovements());
        assertEquals(7, p2.getAssistantDeck().get(6).getValue());
        assertEquals(4, p2.getAssistantDeck().get(6).getMovements());
        assertEquals(10, p3.getAssistantDeck().get(9).getValue());
        assertEquals(5, p3.getAssistantDeck().get(9).getMovements());


        AssistantCard as1 = p1.getAssistantDeck().get(0);
        AssistantCard as2 = p1.getAssistantDeck().get(1);
        p1.playAssistantCard(as1);

        assertEquals(as1, p1.getCurrentCard());

        assertEquals(9, p1.getAssistantDeck().size());

        assertEquals(4, p1.getAssistantDeck().get(2).getValue());
        assertEquals(2, p1.getAssistantDeck().get(2).getMovements());

        p1.playAssistantCard(as2);
        assertEquals(as2, p1.getCurrentCard());
        assertEquals(8, p1.getAssistantDeck().size());

    }

}