package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.SimulatorInterface;

public class IsMovePossiblesim2 {
    private SimulatorInterface simulator;

    @Before
    public void simp() {
        simulator = UTTTFactory.createSimulator();
    }

    @Test
    public void testIsMovePossible_ValidMove() {
        int boardIndex = 0;
        int markIndex = 0;

        boolean isMovePossible = simulator.isMovePossible(boardIndex, markIndex);

        assertTrue(isMovePossible);
    }

    @Test
    public void testIsMovePossible_InvalidBoardIndex() {

        SimulatorInterface simulator = UTTTFactory.createSimulator();
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.isMovePossible(0, 9);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.isMovePossible(-1, 8);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.isMovePossible(0, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.isMovePossible(9, 0);
        });
    }
}