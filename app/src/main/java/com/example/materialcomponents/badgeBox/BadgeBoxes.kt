package com.example.materialcomponents.badgeBox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.materialcomponents.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBarItemWithBadge(navController: NavHostController) {
    Scaffold(
        topBar = {
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
                    ))
                ClickableText(text = AnnotatedString("Simple Badge Boxes"), onClick = {
                    navController.navigate(Screens.NavigationBarItemWithBadge.Route){
                        popUpTo(Screens.NavigationBarItemWithBadge.Route){
                            inclusive = true
                        }
                    }
                },
                    style = TextStyle(
                        fontSize = 20.sp
                    ))
            }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = {
                        BadgedBox(
                            badge = {
                                Badge {
                                    val badgeNumber = "1"
                                    Text(
                                        badgeNumber,
                                        modifier = Modifier.semantics {
                                            contentDescription = "$badgeNumber new notifications"
                                        }
                                    )
                                }
                            }) {
                            Icon(
                                Icons.Filled.Favorite,
                                contentDescription = "Favorite"
                            )
                        }
                    },
                    selected = false,
                    onClick = {}
                )
                NavigationBarItem(
                    icon = {
                        BadgedBox(
                            badge = {
                                Badge {
                                    val badgeNumber = "8"
                                    Text(
                                        badgeNumber,
                                        modifier = Modifier.semantics {
                                            contentDescription = "$badgeNumber new notifications"
                                        }
                                    )
                                }
                            }) {
                            Icon(
                                Icons.Filled.Star,
                                contentDescription = "Favorite"
                            )
                        }
                    },
                    selected = false,
                    onClick = {}
                )
                NavigationBarItem(
                    icon = {
                        BadgedBox(
                            badge = {
                                Badge {
                                    val badgeNumber = "0"
                                    Text(
                                        badgeNumber,
                                        modifier = Modifier.semantics {
                                            contentDescription = "$badgeNumber new notifications"
                                        }
                                    )
                                }
                            }) {
                            Icon(
                                Icons.Filled.Add,
                                contentDescription = "Favorite"
                            )
                        }
                    },
                    selected = false,
                    onClick = {}
                )
            }
        },
        content = {
            paddingValues -> LazyColumn(modifier = Modifier.padding(paddingValues)){

        }
        }
    )
}
