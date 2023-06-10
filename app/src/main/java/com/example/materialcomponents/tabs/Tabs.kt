package com.example.materialcomponents.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRow
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

@Composable
fun LeadingIconTabs(navController: NavHostController) {
    var state by remember { mutableStateOf(0) }
    val titlesAndIcons = listOf(
        "Tab" to Icons.Filled.Favorite,
        "Icon" to Icons.Filled.Favorite,
        "Text" to Icons.Filled.Favorite
    )
    Column {

        Row(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primaryContainer).padding(vertical = 10.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ClickableText(text = AnnotatedString("Home"), onClick = {
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
            ClickableText(text = AnnotatedString("Tabs Row"), onClick = {
                navController.navigate(Screens.LeadingIconTabs.Route){
                    popUpTo(Screens.LeadingIconTabs.Route){
                        inclusive = true
                    }
                }
            },
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
        }
        TabRow(selectedTabIndex = state) {
            titlesAndIcons.forEachIndexed { index, (title, icon) ->
                LeadingIconTab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(title) },
                    icon = { Icon(icon, contentDescription = null) }
                )
            }
        }
        Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Leading icon tab ${state + 1} selected",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
