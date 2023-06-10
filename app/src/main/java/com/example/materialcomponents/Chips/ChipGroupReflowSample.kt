package com.example.materialcomponents.Chips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.materialcomponents.Screens

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ChipGroupReflowSample(navController: NavHostController) {
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
            ClickableText(text = AnnotatedString("Input Chip"), onClick = {
                navController.navigate(Screens.ChipGroupReflowSample.Route){
                    popUpTo(Screens.ChipGroupReflowSample.Route){
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
            FlowRow(
                Modifier
                    .fillMaxWidth(1f)
                    .wrapContentHeight(align = Alignment.Top),
                horizontalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterHorizontally),
            ) {
                repeat(10) { index ->
                    var selected by remember { mutableStateOf(false) }
                    InputChip(
                        selected = selected,
                        onClick = { selected = !selected },
                        label = { Text("Input Chip $index") },
                        avatar = {
                            Icon(
                                Icons.Filled.Person,
                                contentDescription = "Localized description",
                                Modifier.size(InputChipDefaults.AvatarSize)
                            )
                        }
                    )
                }
            }
        }
    }
}
