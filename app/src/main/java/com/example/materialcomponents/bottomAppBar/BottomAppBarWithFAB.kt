package com.example.materialcomponents.bottomAppBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.materialcomponents.Screens

@Composable
fun BottomAppBarWithFAB(navController: NavHostController) {
    Scaffold(
        topBar = {
            Row(modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer).fillMaxWidth().padding(vertical = 10.dp, horizontal = 20.dp),
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
                ClickableText(text = AnnotatedString("Bottom App Bar"), onClick = {
                    navController.navigate(Screens.BottomAppBarWithFAB.Route){
                        popUpTo(Screens.BottomAppBarWithFAB.Route){
                            inclusive = true
                        }
                    }
                },
                    style = TextStyle(
                        fontSize = 20.sp
                    )
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Check, contentDescription = "Localized description")
                    }
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description",
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* do something */ },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, "Localized description")
                    }
                }
            )
        },
    content = {
        innerPadding -> LazyColumn(modifier = Modifier.fillMaxWidth(), contentPadding = innerPadding){
            items(count = 50){
                Text(text = "$it")
            }
    }
    })
}
