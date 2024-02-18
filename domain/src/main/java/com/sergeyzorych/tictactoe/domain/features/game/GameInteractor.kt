package com.sergeyzorych.tictactoe.domain.features.game

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by Android Studio on 02/14/2024 18:41
 *
 * @author Sergey Zorych
 */
class GameInteractor {
    private var currentPlayer = Players.X

    private val _boardFlow = MutableStateFlow(Array(3) { Array<Players?>(3) { null } })
    val board = _boardFlow.asStateFlow()

    /**
     * Start new game and reset board
     */
    fun startGame() {
        _boardFlow.update {
            it.forEach { row ->
                for (i in row.indices) {
                    row[i] = null
                }
            }
            it
        }
    }

    fun move(x: Int, y: Int): MoveStatus {
        if (canMove(x, y).not()) return MoveStatus.CELL_FULL

        _boardFlow.update { board ->
            board[x][y] = currentPlayer
            board
        }


        if (!isWin(x, y)) {
            currentPlayer = if (currentPlayer == Players.X) Players.O else Players.X
            return MoveStatus.DONE
        }

        return MoveStatus.WIN
    }

    private fun canMove(x: Int, y: Int): Boolean {
        return _boardFlow.value[x][y] == null
    }

    private fun isWin(currentRow: Int, currentCol: Int): Boolean {
        return (_boardFlow.value[currentRow][0] == currentPlayer         // 3-in-the-row
                && _boardFlow.value[currentRow][1] == currentPlayer
                && _boardFlow.value[currentRow][2] == currentPlayer
                || _boardFlow.value[0][currentCol] == currentPlayer      // 3-in-the-column
                && _boardFlow.value[1][currentCol] == currentPlayer
                && _boardFlow.value[2][currentCol] == currentPlayer
                || currentRow == currentCol            // 3-in-the-diagonal
                && _boardFlow.value[0][0] == currentPlayer
                && _boardFlow.value[1][1] == currentPlayer
                && _boardFlow.value[2][2] == currentPlayer
                || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                && _boardFlow.value[0][2] == currentPlayer
                && _boardFlow.value[1][1] == currentPlayer
                && _boardFlow.value[2][0] == currentPlayer)

    }

}