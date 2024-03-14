package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.SimulatorInterface;

public class SetIndexNextBoard {
    private SimulatorInterface simulator;

    @Before
    public void setmeup() {
        simulator = UTTTFactory.createSimulator();
    }

    @Test
    public void testSetIndexNextBoard_ValidIndex() {
        int expectedIndex = 3;
        simulator.setIndexNextBoard(expectedIndex);

        int retrievedIndex = simulator.getIndexNextBoard();

        assertEquals(expectedIndex, retrievedIndex);
    }

    @Test
    public void testSetIndexNextBoard_InvalidIndex() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setIndexNextBoard(10);
        });
    }
}
