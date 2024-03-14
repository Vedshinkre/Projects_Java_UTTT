package uttt.tests;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.utils.Symbol;

public class IsClosedDiagonal2 {
    private BoardInterface board;

    @Before
    public void dia2() {
        board = UTTTFactory.createBoard();
    
    }

    @Test
    public void testIsClosed_PlayerWonDiagonal2() {
       
        // Set marks on the board to simulate a player win diagonally
        board.setMarkAt(Symbol.CROSS, 2);
        board.setMarkAt(Symbol.CROSS, 4);
        board.setMarkAt(Symbol.CROSS, 6);

        assertTrue(board.isClosed());
    }
}
