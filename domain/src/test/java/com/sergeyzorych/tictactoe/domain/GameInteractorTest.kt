package com.sergeyzorych.tictactoe.domain

import com.sergeyzorych.tictactoe.domain.features.game.GameInteractor
import com.sergeyzorych.tictactoe.domain.features.game.MoveStatus
import com.sergeyzorych.tictactoe.domain.features.game.Players
import org.junit.Before
import org.junit.Test

/**
 * Created by Android Studio on 02/15/2024 18:42
 *
 * @author Sergey Zorych
 */
class GameInteractorTest {

    private val interactor: GameInteractor = GameInteractor()

    @Before
    fun setup() {
        interactor.startGame()
    }

    @Test
    fun row0Win() {

        //   add X at 0,0
        //
        //   |X| | |
        //   | | | |
        //   | | | |
        assert(interactor.move(0, 0) == MoveStatus.DONE)
        assert(interactor.board.value[0][0] == Players.X)

        //  add O at 0,1
        //
        //  |X| | |
        //  |O| | |
        //  | | | |
        assert(interactor.move(0, 1) == MoveStatus.DONE)
        assert(interactor.board.value[0][1] == Players.O)

        //   add X at 1,0
        //
        //   |X|X| |
        //   |O| | |
        //   | | | |
        assert(interactor.move(1, 0) == MoveStatus.DONE)
        assert(interactor.board.value[1][0] == Players.X)

        //   add X at 1,0
        //
        //   |X|X| |
        //   |O|O| |
        //   | | | |
        assert(interactor.move(1, 1) == MoveStatus.DONE)
        assert(interactor.board.value[1][1] == Players.O)

        //   add X at 2,0 and win for X
        //
        //   |X|X|X|
        //   |O|O| |
        //   | | | |
        assert(interactor.move(2, 0) == MoveStatus.WIN)
        assert(interactor.board.value[2][0] == Players.X)
    }

    @Test
    fun row1Win() {

        //   add X at 0,1
        //
        //   | | | |
        //   |X| | |
        //   | | | |
        assert(interactor.move(0, 1) == MoveStatus.DONE)
        assert(interactor.board.value[0][1] == Players.X)

        //   add 0 at 0,0
        //
        //   |O| | |
        //   |X| | |
        //   | | | |
        assert(interactor.move(0, 0) == MoveStatus.DONE)
        assert(interactor.board.value[0][0] == Players.O)

        //   add X at 1,1
        //
        //   |O| | |
        //   |X|X| |
        //   | | | |
        assert(interactor.move(1, 1) == MoveStatus.DONE)
        assert(interactor.board.value[1][1] == Players.X)

        //   add O at 1,0
        //
        //   |O|O| |
        //   |X|X| |
        //   | | | |
        assert(interactor.move(1, 0) == MoveStatus.DONE)
        assert(interactor.board.value[1][0] == Players.O)

        //   add X at 2,1 and win for X
        //
        //   |O|O| |
        //   |X|X|X|
        //   | | | |
        assert(interactor.move(2, 1) == MoveStatus.WIN)
        assert(interactor.board.value[2][1] == Players.X)
    }

    @Test
    fun row2Win() {

        //   add X at 0,2
        //
        //   | | | |
        //   | | | |
        //   |X| | |
        assert(interactor.move(0, 2) == MoveStatus.DONE)
        assert(interactor.board.value[0][2] == Players.X)

        //   add O at 0,0
        //
        //   |O| | |
        //   | | | |
        //   |X| | |
        assert(interactor.move(0, 0) == MoveStatus.DONE)
        assert(interactor.board.value[0][0] == Players.O)

        //   add X at 1,2
        //
        //   |O| | |
        //   | | | |
        //   |X|X| |
        assert(interactor.move(1, 2) == MoveStatus.DONE)
        assert(interactor.board.value[1][2] == Players.X)

        //   add O at 1,0
        //
        //   |O|O| |
        //   | | | |
        //   |X|X| |
        assert(interactor.move(1, 0) == MoveStatus.DONE)
        assert(interactor.board.value[1][0] == Players.O)

        //   add X at 2,2 and win fo X
        //
        //   |O|O| |
        //   | | | |
        //   |X|X|X|
        assert(interactor.move(2, 2) == MoveStatus.WIN)
        assert(interactor.board.value[2][2] == Players.X)
    }

    @Test
    fun column0Win() {

        //   add X at 0,0
        //
        //   |X| | |
        //   | | | |
        //   | | | |
        assert(interactor.move(0, 0) == MoveStatus.DONE)
        assert(interactor.board.value[0][0] == Players.X)

        //   add O at 1,0
        //
        //   |X|O| |
        //   | | | |
        //   | | | |
        assert(interactor.move(1, 0) == MoveStatus.DONE)
        assert(interactor.board.value[1][0] == Players.O)

        //   add X at 0,1
        //
        //   |X|O| |
        //   |X| | |
        //   | | | |
        assert(interactor.move(0, 1) == MoveStatus.DONE)
        assert(interactor.board.value[0][1] == Players.X)

        //   add O at 1,1
        //
        //   |X|O| |
        //   |X|O| |
        //   | | | |
        assert(interactor.move(1, 1) == MoveStatus.DONE)
        assert(interactor.board.value[1][1] == Players.O)

        //   add X at 0,2
        //
        //   |X|O| |
        //   |X|O| |
        //   |X| | |
        assert(interactor.move(0, 2) == MoveStatus.WIN)
        assert(interactor.board.value[0][2] == Players.X)
    }

    @Test
    fun column1Win() {

        //   add X at 1,0
        //
        //   | |X| |
        //   | | | |
        //   | | | |
        assert(interactor.move(1, 0) == MoveStatus.DONE)
        assert(interactor.board.value[1][0] == Players.X)

        //   add O at O,0
        //
        //   |O|X| |
        //   | | | |
        //   | | | |
        assert(interactor.move(0, 0) == MoveStatus.DONE)
        assert(interactor.board.value[0][0] == Players.O)

        //   add X at 1,1
        //
        //   |O|X| |
        //   | |X| |
        //   | | | |
        assert(interactor.move(1, 1) == MoveStatus.DONE)
        assert(interactor.board.value[1][1] == Players.X)

        //   add O at O,1
        //
        //   |O|X| |
        //   |O|X| |
        //   | | | |
        assert(interactor.move(0, 1) == MoveStatus.DONE)
        assert(interactor.board.value[0][1] == Players.O)

        //   add X at 1,2 and win for X
        //
        //   |O|X| |
        //   |O|X| |
        //   | |X| |
        assert(interactor.move(1, 2) == MoveStatus.WIN)
        assert(interactor.board.value[1][2] == Players.X)
    }

    @Test
    fun column2Win() {

        //   add X at 2,0
        //
        //   | | |X|
        //   | | | |
        //   | | | |
        assert(interactor.move(2, 0) == MoveStatus.DONE)
        assert(interactor.board.value[2][0] == Players.X)

        //   add O at 0,0
        //
        //   |O| |X|
        //   | | | |
        //   | | | |
        assert(interactor.move(0, 0) == MoveStatus.DONE)
        assert(interactor.board.value[0][0] == Players.O)

        //   add X at 2,1
        //
        //   |O| |X|
        //   | | |X|
        //   | | | |
        assert(interactor.move(2, 1) == MoveStatus.DONE)
        assert(interactor.board.value[2][1] == Players.X)

        //   add O at 0,1
        //
        //   |O| |X|
        //   |O| |X|
        //   | | | |
        assert(interactor.move(0, 1) == MoveStatus.DONE)
        assert(interactor.board.value[0][1] == Players.O)

        //   add X at 2,2 and win for X
        //
        //   |O| |X|
        //   |O| |X|
        //   | | |X|
        assert(interactor.move(2, 2) == MoveStatus.WIN)
        assert(interactor.board.value[2][2] == Players.X)
    }

    @Test
    fun diagonal1Win() {

        //   add X at 0,0
        //
        //   |X| | |
        //   | | | |
        //   | | | |
        assert(interactor.move(0, 0) == MoveStatus.DONE)
        assert(interactor.board.value[0][0] == Players.X)

        //   add O at 1,0
        //
        //   |X|O| |
        //   | | | |
        //   | | | |
        assert(interactor.move(1, 0) == MoveStatus.DONE)
        assert(interactor.board.value[1][0] == Players.O)

        //   add X at 1,1
        //
        //   |X|O| |
        //   | |X| |
        //   | | | |
        assert(interactor.move(1, 1) == MoveStatus.DONE)
        assert(interactor.board.value[1][1] == Players.X)

        //   add O at 2,0
        //
        //   |X|O|O|
        //   | |X| |
        //   | | | |
        assert(interactor.move(0, 1) == MoveStatus.DONE)
        assert(interactor.board.value[0][1] == Players.O)

        //   add X at 2,2 and win for X
        //
        //   |X|O|O|
        //   | |X| |
        //   | | |X|
        assert(interactor.move(2, 2) == MoveStatus.WIN)
        assert(interactor.board.value[2][2] == Players.X)
    }

    @Test
    fun diagonal2Win() {

        //   add X at 0,2
        //
        //   | | | |
        //   | | | |
        //   |X| | |
        assert(interactor.move(0, 2) == MoveStatus.DONE)
        assert(interactor.board.value[0][2] == Players.X)

        //   add O at 0,0
        //
        //   |O| | |
        //   | | | |
        //   |X| | |
        assert(interactor.move(0, 0) == MoveStatus.DONE)
        assert(interactor.board.value[0][0] == Players.O)

        //   add X at 1,1
        //
        //   |O| | |
        //   | |X| |
        //   |X| | |
        assert(interactor.move(1, 1) == MoveStatus.DONE)
        assert(interactor.board.value[1][1] == Players.X)

        //   add O at 0,1
        //
        //   |O| | |
        //   |O|X| |
        //   |X| | |
        assert(interactor.move(0, 1) == MoveStatus.DONE)
        assert(interactor.board.value[0][1] == Players.O)

        //   add X at 2,0 and win for X
        //
        //   |O| |X|
        //   |O|X| |
        //   |X| | |
        assert(interactor.move(2, 0) == MoveStatus.WIN)
        assert(interactor.board.value[2][0] == Players.X)
    }


}