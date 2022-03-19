package it.polimi.ingsw.model;

public class AssistantCard {

    private int value;
    private int movements;

    public AssistantCard(int value, int movements) {
        this.value = value;
        this.movements = movements;
    }

    public int getValue() {
        return value;
    }

    public int getMovements() {
        return movements;
    }
}
