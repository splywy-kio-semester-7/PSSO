package main;

import java.util.*;

/*
 *
 * This is the main class of the application.
 */
public class GameOfLife extends Observable {

    public static int COLS;

    public static int ROWS;

    public static int LIFE_EXPECTANCY;

    protected int grid[][];

    protected Collection<Observer> observers;

    @Override
    public synchronized void addObserver(Observer o) {
        if (observers != null)
        {
            observers.add(o);
        }
        else
        {
            observers = new ArrayList<>(List.of(o));
        }
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        if (observers != null)
        {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this, null));
    }

    public GameOfLife(int cols, int rows, int lifeExpectancy)  {
        COLS = cols;
        ROWS = rows;
        LIFE_EXPECTANCY = lifeExpectancy;
        grid = new int[rows][cols];
    }

    // Reverse the life status of the cell at location r,c
    public void toggle(int r, int c){
        if( isAlive(r,c) ) grid[r][c] = 0;
        else grid[r][c] = LIFE_EXPECTANCY;
        notifyObservers();
    }

    public boolean isAlive(int r, int c){
        return (grid[r][c] != 0);
    }

    // Returns the number of alive neighbors for the cell at position r,c.  The
    //  grid is finite but unbound, meaning that the neighbor relation wraps around
    //  the grid boundaries.
    protected int nbrOfNeighbors(int r, int c) {
        int n = 0;
        int x = 0;
        int y = r-1;
        if ( y < 0 ) y = ROWS-1;
        for (int rCt = 1; rCt <= 3; rCt++) {
            x = c-1;
            if ( x < 0 )  x = COLS-1;
            for(int cCt = 1; cCt <= 3; cCt++) {
                if ( x != c || y != r ){
                    if ( isAlive(y,x) ){
                        n++;
                    }
                }
                x = (x+1)%COLS;
            }
            y = (y+1)%ROWS;
        }
        return n;
    }

    // This method implements the rules of the Game of Life.  For each cell,
    //  we simple find the number of neighbors and then bring the cell to life
    //  if appropriate.
    // a live cell with 2, 3 neighbors stays alive.
    // a non-existent cell comes alive if it has 3 neighbors
    public void advance(){
        int[][] newGrid = new int[ROWS][COLS];
        int n=0;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                n = nbrOfNeighbors(i,j);
                if (  isAlive(i,j) ){
                    if ( n == 2 || n == 3 ){
                        newGrid[i][j] = grid[i][j] - 1;
                    }
                    else {
                        newGrid[i][j] = 0;
                    }
                }
                else {
                    if ( n == 3){
                        newGrid[i][j] = LIFE_EXPECTANCY;
                    }
                    else {
                        newGrid[i][j] = 0;
                    }
                }

            }
        }
        grid = newGrid;
        notifyObservers();
    }
}
