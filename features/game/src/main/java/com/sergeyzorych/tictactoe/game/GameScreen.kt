package com.sergeyzorych.tictactoe.game

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times

/**
 * Created by Android Studio on 07/01/2023 20:34
 *
 * @author Sergey Zorych
 */
@Composable
fun GameScreen() {
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val boardSize = configuration.screenWidthDp.dp
    val dividerSize = 1.dp
    val cellSize = (boardSize - (2 * dividerSize)) / 3
    val heightPadding = (screenHeight - boardSize) / 2

    Canvas(
        modifier = Modifier
            .size(boardSize)
            .padding(vertical = heightPadding)
            .background(Color.LightGray)
    ) {
        for (i in 0 until 2) {
            val mainAxisOffset = (cellSize.toPx() * (i + 1)) + (dividerSize.toPx() * i)

            //Draw vertical line
            drawLine(
                color = Color.Black,
                start = Offset(
                    x = mainAxisOffset,
                    y = 0f
                ),
                end = Offset(
                    x = mainAxisOffset,
                    y = boardSize.toPx()
                ),
                strokeWidth = dividerSize.toPx()
            )

            //Draw horizontal line
            drawLine(
                color = Color.Black,
                start = Offset(
                    x = 0f,
                    y = mainAxisOffset
                ),
                end = Offset(
                    x = boardSize.toPx(),
                    y = mainAxisOffset
                ),
                strokeWidth = dividerSize.toPx()
            )
        }
    }
}