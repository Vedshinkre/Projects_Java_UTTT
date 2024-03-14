
package uttt.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.utils.Symbol;

public class IsMovePossible {
    private BoardInterface board;

    @Before
    public void ismov() throws Exception {
        this.board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 3);
        board.setMarkAt(Symbol.CIRCLE, 6);
        board.setMarkAt(Symbol.EMPTY, 8);
    }

    @Test
    public void testMovePossible() {
        assertFalse(board.isMovePossible(3)); // Position 3 is occupied by CROSS
        assertFalse(board.isMovePossible(6)); // Position 6 is occupied by CIRCLE
        assertTrue(board.isMovePossible(0)); // Position 1 is empty
        assertTrue(board.isMovePossible(5)); // Position 5 is empty
        assertTrue(board.isMovePossible(8)); // Position 9 is empty
    }

    @Test
    public void testMovePossible_OutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            board.isMovePossible(9);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            board.isMovePossible(-1);
        });

    }
}
