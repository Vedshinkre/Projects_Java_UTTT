package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;

public class CreateBoardTest {
    BoardInterface board;

    @Before
    public void createb() throws Exception {
        this.board = UTTTFactory.createBoard();
    }

    @Test
    public void simpleBoardTest() {
        assertNotNull(this.board);
    }
}
