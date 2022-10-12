package main;

public class Main {

    public static void main(String[] args) {
        // Create an instance of the game with a 20x20 life grid shown in a 200x200 panel.
        GameOfLife life = new GameOfLife(20, 20, 20);
        GameOfLifeUI ui = new GameOfLifeUI("Game of Life", life);
        life.addObserver(ui);
    }
}

