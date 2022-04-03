package it.polimi.ingsw;

import it.polimi.ingsw.model.Professor;
import it.polimi.ingsw.model.enumeration.Colour;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class ProfessorTest extends TestCase {

    @Test

    public void testProfessor(){

        Professor professor1 = new Professor(Colour.Green);
        Professor professor2 = new Professor(Colour.Red);
        Professor professor3 = new Professor(Colour.Yellow);
        Professor professor4 = new Professor(Colour.Pink);
        Professor professor5 = new Professor(Colour.Blue);

        assertEquals(Colour.Green,professor1.getProfessorColour());
        assertEquals(Colour.Red,professor2.getProfessorColour());
        assertEquals(Colour.Yellow,professor3.getProfessorColour());
        assertEquals(Colour.Pink,professor4.getProfessorColour());
        assertEquals(Colour.Blue,professor5.getProfessorColour());






    }


}
