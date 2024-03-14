package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.SimulatorInterface;
import uttt.utils.Symbol;


    public class IsGameOver {
        private SimulatorInterface simulator;
    
        @Before
        public void over() {
            simulator = UTTTFactory.createSimulator();
        }
    
     
    
        @Test
        public void testIsGameOver_OngoingGame() {
            // Simulate an ongoing game
            BoardInterface[] boards = new BoardInterface[9];
            for (int i = 0; i < 9; i++) {
                boards[i] = UTTTFactory.createBoard();
                boards[i].setMarkAt(Symbol.CIRCLE, i);
            }
            simulator.setBoards(boards);
    
            boolean isGameOver = simulator.isGameOver();
    
            assertFalse(isGameOver);
        }
    }
    
    