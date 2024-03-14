package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.utils.Symbol;

public class SetMarkAt {
    private BoardInterface board;

    @Before
    public void ssmark() throws Exception {
        this.board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 3);
        board.setMarkAt(Symbol.CIRCLE, 6);
        board.setMarkAt(Symbol.EMPTY, 8);
    }

    @Test
    public void testSetMarkAt() {
        assertFalse(board.setMarkAt(Symbol.CIRCLE, 3));
        assertFalse(board.setMarkAt(Symbol.CROSS, 6));
        assertTrue(board.setMarkAt(Symbol.CROSS, 8));

        assertEquals(Symbol.CROSS, board.getMarks()[3].getSymbol());
        assertEquals(Symbol.CIRCLE, board.getMarks()[6].getSymbol());
        assertEquals(Symbol.CROSS, board.getMarks()[8].getSymbol());
    }

    @Test
    public void testSetMarkAt_OutOfRange() {

        assertThrows(IllegalArgumentException.class, () -> {
            board.setMarkAt(Symbol.CROSS, 9);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            board.setMarkAt(null, 3);
        });
    }
}