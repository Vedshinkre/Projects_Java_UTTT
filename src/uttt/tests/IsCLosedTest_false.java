package uttt.tests;

import static org.junit.Assert.assertFalse;


import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.utils.Symbol;

public class IsCLosedTest_false {
    private BoardInterface board;

    @Before
    public void fals() {
        board = UTTTFactory.createBoard();
        
    }

    @Test
    public void testIsClosed_NoMovesLeftt() {
        // Set marks on the board to simulate a closed state with no moves left
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.EMPTY, 1);
        board.setMarkAt(Symbol.EMPTY, 2);
        board.setMarkAt(Symbol.EMPTY, 3);
        board.setMarkAt(Symbol.EMPTY, 4);
        board.setMarkAt(Symbol.CIRCLE, 5);
        board.setMarkAt(Symbol.EMPTY, 6);
        board.setMarkAt(Symbol.EMPTY, 7);
        board.setMarkAt(Symbol.EMPTY, 8);

        assertFalse(board.isClosed());
    }
    }