package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.SimulatorInterface;

public class GetNextIndex {
    private SimulatorInterface simulator;

    @Before
    public void getnextb() {
        simulator = UTTTFactory.createSimulator();
    }

    @Test
    public void testGetIndexNextBoard_NoRestriction() {

        int expectedIndex = -1;
        simulator.setIndexNextBoard(expectedIndex);

        int retrievedIndex = simulator.getIndexNextBoard();

        assertEquals(expectedIndex, retrievedIndex);
    }

    @Test
    public void testGetIndexNextBoard_WithRestriction() {

        int expectedIndex = 3;
        simulator.setIndexNextBoard(expectedIndex);

        int retrievedIndex = simulator.getIndexNextBoard();

        assertEquals(expectedIndex, retrievedIndex);
    }
}