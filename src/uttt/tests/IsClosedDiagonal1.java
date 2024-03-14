package uttt.tests;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.utils.Symbol;

public class IsClosedDiagonal1 {
    private BoardInterface board;

    @Before
    public void dia1() {
        board = UTTTFactory.createBoard();
        
    }

    @Test
    public void testIsClosed_PlayerWonDiagonal() {

        // Set marks on the board to simulate a player win diagonally
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CROSS, 4);
        board.setMarkAt(Symbol.CROSS, 8);

        assertTrue(board.isClosed());
    }

}
