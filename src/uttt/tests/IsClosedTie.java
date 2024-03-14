package uttt.tests;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.utils.Symbol;

public class IsClosedTie {
    private BoardInterface board;

    @Before
    public void tie() {
        board = UTTTFactory.createBoard();
    
    }

    @Test
    public void testIsClosed_Tie() {
        // Set marks on the board to simulate a tie state
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.CROSS, 2);
        board.setMarkAt(Symbol.CIRCLE, 3);
        board.setMarkAt(Symbol.CROSS, 4);
        board.setMarkAt(Symbol.CIRCLE, 5);
        board.setMarkAt(Symbol.CIRCLE, 6);
        board.setMarkAt(Symbol.CROSS, 7);
        board.setMarkAt(Symbol.CIRCLE, 8);

        assertTrue(board.isClosed());
    }
}
