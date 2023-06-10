package com.example.materialcomponents.navigationBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.materialcomponents.Screens

@Composable
fun NavigationBarSample(navController: NavHostController) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists")
   Column() {
       Row(modifier = Modifier
           .fillMaxWidth()
           .background(MaterialTheme.colorScheme.primaryContainer)
           .padding(vertical = 10.dp, horizontal = 20.dp),
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
           ClickableText(text = AnnotatedString("Navigation Bar"), onClick = {
               navController.navigate(Screens.NavigationBarSample.Route){
                   popUpTo(Screens.NavigationBarSample.Route){
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
           verticalArrangement = Arrangement.Center
       ) {
           NavigationBar {
               items.forEachIndexed { index, item ->
                   NavigationBarItem(
                       icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                       label = { Text(item) },
                       selected = selectedItem == index,
                       onClick = { selectedItem = index }
                   )
               }
           }
       }
   }
}
