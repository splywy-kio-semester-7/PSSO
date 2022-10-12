package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
/*
 *
 * This class represents both the Life game and the UI of that game.
 */
public class GameOfLifePanel extends JPanel {
    protected int cellHeight;
    protected int cellWidth;

    protected static final Color DEAD_COLOR = Color.BLACK;

    protected static final Color LIVE_COLOR = Color.RED;

    protected static final int GRID_WIDTH = 500;

    protected static final int GRID_HEIGHT = 500;

    protected GameOfLife gameOfLife;

    public GameOfLifePanel(GameOfLife gameOfLife){
        this.gameOfLife = gameOfLife;
        cellHeight = GRID_HEIGHT / GameOfLife.ROWS;
        cellWidth = GRID_WIDTH / GameOfLife.COLS;
        initialize();
    }

    protected void initialize(){
        // Set the size of the Panel to  the Width x Height
        this.setSize(GRID_WIDTH, GRID_HEIGHT);
        this.setPreferredSize(this.getSize());
        this.setBackground(Color.black);
        // Add a listener to the mouse that will cause the life at the x,y
        //  position of the grid to be turned on/off.
        this.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseExited(MouseEvent e) {
            }
            public void mousePressed(MouseEvent e) {
                gameOfLife.toggle(e.getPoint().y / cellHeight, e.getPoint().x / cellWidth);
            }
            public void mouseReleased(MouseEvent e) {
            }});
    }

    // Necessary painting method which draws the lines of the grid and the live cells.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGrid(g);
        drawLives(g);
    }

    // Draws the lines of the grid.
    protected void drawGrid(Graphics g){
        int cellSize = this.getHeight() / GameOfLife.ROWS;
        g.setColor(Color.red);
        for(int i = 1; i < GameOfLife.COLS; i++){
            g.drawLine(0,i*cellSize,this.getWidth(),i*cellSize);
        }
        cellSize = this.getWidth() / GameOfLife.COLS;
        for(int i = 1; i < GameOfLife.COLS; i++){
            g.drawLine(i*cellSize,0,i*cellSize,this.getHeight());
        }
    }

    // Draws all live cells.
    protected void drawLives(Graphics g){
        g.setColor(Color.red);
        for(int i =0; i < GameOfLife.ROWS; i++){
            for(int j = 0; j < GameOfLife.COLS; j++){
                if (gameOfLife.isAlive(i, j) ){
                    g.fillRect(j*cellWidth,i*cellHeight,cellWidth,cellHeight);
                }
            }
        }
    }
}
