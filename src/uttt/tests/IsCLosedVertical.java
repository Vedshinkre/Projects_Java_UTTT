package uttt.tests;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.utils.Symbol;

public class IsCLosedVertical {
    private BoardInterface board;

    @Before
    public void ver() {
        board = UTTTFactory.createBoard();

    }

    @Test
    public void testIsClosed_PlayerWonVertical() {

        // Set marks on the board to simulate a player win vertically
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CIRCLE, 3);
        board.setMarkAt(Symbol.CIRCLE, 6);

        assertTrue(board.isClosed());
    }
}
