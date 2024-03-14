package uttt.tests;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.utils.Symbol;

public class IsClosedTest_true {
    private BoardInterface board;

    @Before
    public void tru() {
        board = UTTTFactory.createBoard();
        
    }

    @Test
    public void testIsClosed_NoMovesLeft() {
        // Set marks on the board to simulate a closed state with no moves left
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.CROSS, 2);
        board.setMarkAt(Symbol.CIRCLE, 3);
        board.setMarkAt(Symbol.CROSS, 4);
        board.setMarkAt(Symbol.CIRCLE, 5);
        board.setMarkAt(Symbol.CROSS, 6);
        board.setMarkAt(Symbol.CIRCLE, 7);
        board.setMarkAt(Symbol.CROSS, 8);

        assertTrue(board.isClosed());

    }
}
