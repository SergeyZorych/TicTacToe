package com.sergeyzorych.tictactoe.domain.features.game

/**
 * Created by Android Studio on 07/02/2023 23:08
 *
 * @author Sergey Zorych
 */
class GameInteractor {
    private val board = Array(3) {
        IntArray(3)
    }

    private var currentTurn = 1

    fun startGame() {
        board.forEach { row ->
            for (i in row.indices) {
                row[i] = -1
            }
        }
    }

    fun move(x: Int, y: Int) {
        if (canMove(x, y).not()) return

        board[x][y] = currentTurn

        if (!isWin(x, y)) {
            currentTurn *= -1
        }
    }

    private fun canMove(x: Int, y: Int): Boolean {
        return board[x][y] == 0
    }

    private fun isWin(currentRow: Int, currentCol: Int): Boolean {
        return (board[currentRow][0] == currentTurn         // 3-in-the-row
                && board[currentRow][1] == currentTurn
                && board[currentRow][2] == currentTurn
                || board[0][currentCol] == currentTurn      // 3-in-the-column
                && board[1][currentCol] == currentTurn
                && board[2][currentCol] == currentTurn
                || currentRow == currentCol            // 3-in-the-diagonal
                && board[0][0] == currentTurn
                && board[1][1] == currentTurn
                && board[2][2] == currentTurn
                || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                && board[0][2] == currentTurn
                && board[1][1] == currentTurn
                && board[2][0] == currentTurn)

    }
}