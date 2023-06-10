package com.example.materialcomponents.swipeToDismiss

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.DismissValue
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SwipeToDismissListItems() {
    val dismissState = rememberDismissState()
    SwipeToDismiss(
        modifier = Modifier.fillMaxSize(),
        state = dismissState,
        background = {
            val color by animateColorAsState(
                when (dismissState.targetValue) {
                    DismissValue.DismissedToEnd -> Color.Green
                    DismissValue.DismissedToStart -> Color.Red
                    else -> Color.LightGray
                }
            )
            Box(Modifier.fillMaxSize().background(color))
        },
        dismissContent = {
            Card {
                ListItem(
                    headlineContent = {
                        Text("Cupcake")
                    },
                    supportingContent = { Text("Swipe me left or right!") }
                )
                Divider()
            }
        }
    )
}
