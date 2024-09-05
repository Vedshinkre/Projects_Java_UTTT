# Ultimate Tic-Tac-Toe
## Overview
This project implements the game Ultimate Tic-Tac-Toe (UTTT) in Java, a more complex version of the classic Tic-Tac-Toe. UTTT challenges players to win on a larger 3x3 grid where each cell contains a smaller 3x3 Tic-Tac-Toe board. The game emphasizes strategy, as each move determines where the next player must play. The project includes test creation, game logic implementation, and an optional AI development.

## Features
### Phase 1: Test Creation:
Implement JUnit tests to verify the correctness of UTTT implementations.
### Phase 2: Game Logic:
Implement the full game logic, including moves validation, winning conditions, and handling both small and large boards.

## UTTT Gameplay
The game is played on a 3x3 grid of smaller Tic-Tac-Toe boards.
Players take turns placing their marks (X or O) in the smaller boards.
A player must play in the small board corresponding to the position of the last move made.
Winning a small board is similar to classic Tic-Tac-Toe, and the game is won by getting three small boards in a row.
For detailed rules, see the Ultimate Tic-Tac-Toe Wikipedia.

## Project Structure
The project is divided into three main packages:

### uttt.game:
Contains interfaces and logic for the game, such as handling boards, moves, and simulations.
### uttt.utils: 
Provides utility classes, including those for managing symbols and moves.
### uttt.ui:
Manages the graphical interface, which can be used to visualize and test your implementation.

## Key Classes and Interfaces
### MarkInterface:
Manages the placement of player marks on the board.
### BoardInterface:
Defines the structure and validation of moves on a small board.
### SimulatorInterface:
Manages the entire game, determining where moves should be made and checking win conditions.
### PlayerInterface:
Handles player input.
### UTTTFactory:
A factory pattern implementation that links the game components together.

## Getting Started
### Prerequisites
- Java Development Kit (JDK)
- Visual Studio Code (or any Java IDE)
- JUnit for running tests
