package it.polimi.ingsw.model.player;

import it.polimi.ingsw.model.enumeration.Colour;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest{
    @Test
    public void testStudent(){
        Student student = new Student(Colour.Green);
        assertEquals(student.getColour(), Colour.Green);

        assertNotNull(student.toString());

    }
}
