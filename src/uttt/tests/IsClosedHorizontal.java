package uttt.tests;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.utils.Symbol;

public class IsClosedHorizontal {
    private BoardInterface board;

    @Before
    public void hor() {
        board = UTTTFactory.createBoard();
        
    }

    @Test
    public void testIsClosed_PlayerWonHorizontal() {

        // Set marks on the board to simulate a player win horizontally
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CROSS, 2);

        assertTrue(board.isClosed());
    }
}
