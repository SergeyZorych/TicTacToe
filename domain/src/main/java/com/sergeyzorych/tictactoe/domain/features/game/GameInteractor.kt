package com.sergeyzorych.tictactoe.domain.features.game

/**
 * Created by Android Studio on 02/14/2024 18:41
 *
 * @author Sergey Zorych
 */
class GameInteractor {
    private var currentPlayer = Players.X

    private val board = Array(3) {
        Array<Players?>(3) { null }
    }

    /**
     * Start new game and reset board
     */
    fun startGame() {
        board.forEach { row ->
            for (i in row.indices) {
                row[i] = null
            }
        }
    }

    fun move(x: Int, y: Int): MoveStatus {
        if (canMove(x, y).not()) return MoveStatus.CELL_FULL

        board[x][y] = currentPlayer


        if (!isWin(x, y)) {
            currentPlayer = if (currentPlayer == Players.X) Players.O else Players.X
            return MoveStatus.DONE
        }

        return MoveStatus.WIN
    }

    private fun canMove(x: Int, y: Int): Boolean {
        return board[x][y] == null
    }

    private fun isWin(currentRow: Int, currentCol: Int): Boolean {
        return (board[currentRow][0] == currentPlayer         // 3-in-the-row
                && board[currentRow][1] == currentPlayer
                && board[currentRow][2] == currentPlayer
                || board[0][currentCol] == currentPlayer      // 3-in-the-column
                && board[1][currentCol] == currentPlayer
                && board[2][currentCol] == currentPlayer
                || currentRow == currentCol            // 3-in-the-diagonal
                && board[0][0] == currentPlayer
                && board[1][1] == currentPlayer
                && board[2][2] == currentPlayer
                || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                && board[0][2] == currentPlayer
                && board[1][1] == currentPlayer
                && board[2][0] == currentPlayer)

    }

}