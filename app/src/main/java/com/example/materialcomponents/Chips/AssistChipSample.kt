package com.example.materialcomponents.Chips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.materialcomponents.Screens

@Composable
fun AssistChipSample(navController: NavHostController) {
    Column() {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(vertical = 10.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ClickableText(text = AnnotatedString("Home"), onClick = {
                navController.popBackStack()
                navController.popBackStack()
            },
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
            Text(text = ">",
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
            ClickableText(text = AnnotatedString("Chips"), onClick = {
                navController.popBackStack()
            },
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
            Text(text = ">",
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
            ClickableText(text = AnnotatedString("Assist Chips"), onClick = {
                navController.navigate(Screens.AssistChipSample.Route){
                    popUpTo(Screens.AssistChipSample.Route){
                        inclusive = true
                    }
                }
            },
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AssistChip(
                onClick = { /* Do something! */ },
                label = { Text("Assist Chip") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = "Localized description",
                        Modifier.size(AssistChipDefaults.IconSize)
                    )
                }
            )
        }
    }
}
