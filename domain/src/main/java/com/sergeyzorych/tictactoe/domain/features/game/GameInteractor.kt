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

        currentTurn *= -1
    }

    private fun canMove(x: Int, y: Int): Boolean {
        return board[x][y] == 0
    }
}