package models;
import controllers.Controller;

public class Board {
    private int rows = 3;
    private int columns = 3;
    private Controller controller;

    public Board(Controller controller){
        this.controller = controller;
        this.columns = columns;
        this.rows = rows;
    }

    public String printToken() {

    }
}
