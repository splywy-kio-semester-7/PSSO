package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class GameOfLifeUI extends JFrame implements Observer
{
    protected JButton advanceButton;

    protected JPanel contentPane;

    protected GameOfLifePanel view;

    protected final static int WIDTH_PAD = 50;

    protected final static int HEIGHT_PAD = 100;

    protected final static int PADDING = 100;

    protected GameOfLife gameOfLife;

    // Build the appropriate instance of the GameOfLifePanel class and initialize the
    //  application frame.
    public GameOfLifeUI(String title, GameOfLife gameOfLife)
    {
        super(title);
        this.gameOfLife = gameOfLife;
        view = new GameOfLifePanel(gameOfLife);
        advanceButton = new JButton("Advance");
        contentPane = new JPanel();
        initialize();
    }

    // Build the UI and set the "advance" button to cause the game object to
    //  advance one generation.
    protected void initialize(){
        this.setSize(GameOfLifePanel.GRID_WIDTH + PADDING, GameOfLifePanel.GRID_HEIGHT + PADDING);
        contentPane.setLayout(new FlowLayout());
        contentPane.add(view);
        contentPane.add(advanceButton);
        this.setContentPane(contentPane);
        this.setVisible(true);
        advanceButton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                gameOfLife.advance();
            } } );
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void update(Observable o, Object arg) {
        view.repaint();
    }

}
