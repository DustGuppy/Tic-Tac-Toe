package views;
import controllers.Controller;

import java.util.Scanner;

public class View {
    private Controller controller;
    private Scanner scanner = new Scanner(System.in);

    public View(Controller controller) {
        this.controller = controller;
    }

    public void promptUser(){
        boolean choice = true;
        System.out.println("    Hello! Welcome to the game of Tic-Tac-Toe!    ");
        System.out.println("In the game of Tic-Tac-Toe, two players are needed");
        System.out.println("            Would you like to play?               ");
        if(scanner.next().toUpperCase().equals("N")){
            choice = false;
        }
        while(choice){
            this.setupGame();
            System.out.println("       Would you like to play again?            ");
            if(scanner.next().toUpperCase().equals("N")){
                choice = false;
            }
        }
    }

    public void printBoard() {
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                System.out.print(this.board[i][j].printToken());
            }
            System.out.println();
        }
    }

    private void setupGame() {
        System.out.println("Please enter your desired row");
        while(this.scanner.nextInt() > 3 || this.scanner.nextInt() < 1) {
            System.out.println("Please enter a coordinate between 1 and 3");
            this.scanner.nextInt();
        }
        int row = this.scanner.nextInt();

        System.out.println("Please enter your desired column");
        while(this.scanner.nextInt() > 3 || this.scanner.nextInt() < 1) {
            System.out.println("Please enter a coordinate between 1 and 3");
            this.scanner.nextInt();
        }
        int column = this.scanner.nextInt();

        if(this.controller.isTaken()){
            System.out.println("That space is taken");
            setupGame();
        }

        this.controller.addPlayerLocation(row, column);

        printBoard();
    }

    public void printWin(){
        System.out.println("       Congratulations, you won!        ");
        System.out.println();
        promptUser();
    }
}
