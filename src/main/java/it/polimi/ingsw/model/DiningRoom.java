package it.polimi.ingsw.model;

import it.polimi.ingsw.model.enumeration.Colour;

import java.util.ArrayList;

public class DiningRoom {
    private ArrayList<Student> greenStudents;
    private ArrayList<Student> redStudents;
    private ArrayList<Student> yellowStudents;
    private ArrayList<Student> pinkStudents;
    private ArrayList<Student> blueStudents;

    public DiningRoom() {
        this.greenStudents = new ArrayList<>(0);
        this.redStudents = new ArrayList<>(0);
        this.yellowStudents = new ArrayList<>(0);
        this.pinkStudents = new ArrayList<>(0);
        this.blueStudents = new ArrayList<>(0);
    }

    public void addStudent(Student s){                 // scusate i tanti if ma sono funzionali
        if(s.getColour().equals(Colour.Green))         // qui poi nelle regole esperte bisogna contare le  monete
            greenStudents.add(s);
        else if(s.getColour().equals(Colour.Red))
            redStudents.add(s);
        else if(s.getColour().equals(Colour.Yellow))
            yellowStudents.add(s);
        else if(s.getColour().equals(Colour.Pink))
            pinkStudents.add(s);
        else if(s.getColour().equals(Colour.Blue))
            blueStudents.add(s);
    }

    public int NumOfGreenStudents() {
        return greenStudents.size();
    }

    public int NumOfRedStudents() {
        return redStudents.size();
    }

    public int NumOfYellowStudents() {
        return yellowStudents.size();
    }

    public int NumOfPinkStudents() {
        return pinkStudents.size();
    }

    public int NumOfBlueStudents() {
        return blueStudents.size();
    }
}