package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.SimulatorInterface;
import uttt.utils.Symbol;

public class GetBoards {
    private BoardInterface[] boards;
    private SimulatorInterface simulator;

    @Before
    public void gboard() {
        boards = new BoardInterface[9];
        simulator = UTTTFactory.createSimulator();
    }

    @Test

    public void getboard() {
        for (int i = 0; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();
            boards[i].setMarkAt(Symbol.CIRCLE, i);
        }
        assertNotNull(boards);
        simulator.setBoards(boards);
        assertNotNull(simulator);

        BoardInterface[] retrievedBoards = simulator.getBoards();
        assertNotNull(retrievedBoards);

        for (int i = 0; i < 9; i++) {
            assertEquals(boards[i], retrievedBoards[i]);
        }

    }

    @Test

    public void getboardnull() {

        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setBoards(null);
        });

    }
}
