package com.example.materialcomponents.topAppBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.materialcomponents.Screens

@Composable
fun TopAppBarList(navController: NavHostController) {
    Row(modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer).fillMaxWidth().padding(vertical = 10.dp, horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        ClickableText(text = AnnotatedString("Home"), onClick = {
            navController.popBackStack()
        },
            style = TextStyle(
                fontSize = 20.sp
            ))
        Text(text = ">",
            style = TextStyle(
                fontSize = 20.sp
            ))
        ClickableText(text = AnnotatedString("Top App Bars List"), onClick = {
            navController.navigate(Screens.TopAppBarList.Route){
                popUpTo(Screens.TopAppBarList.Route){
                    inclusive = true
                }
            }
        },
            style = TextStyle(
                fontSize = 20.sp
            ))
    }
    Column(verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp).fillMaxSize()) {
        Text(text = "Top App Bars", style = TextStyle(
            fontSize = 36.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        ),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(20.dp))
        TextButton(modifier = Modifier
            .clip(RoundedCornerShape(10))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
            .height(56.dp),
            onClick = {
                navController.navigate(Screens.SampleTopAppBar.Route)
            }) {
            Text(text = "Sample Top App Bar")
            IconButton(onClick = {                 navController.navigate(Screens.SampleTopAppBar.Route)
            }, modifier = Modifier.absoluteOffset(x = 70.dp)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
            }
        }
        TextButton(modifier = Modifier
            .clip(RoundedCornerShape(10))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
            .height(56.dp),
            onClick = {
                navController.navigate(Screens.PinnedTopAppBar.Route)
            }) {
            Text(text = "Pinned Top App Bar")
            IconButton(onClick = {                 navController.navigate(Screens.PinnedTopAppBar.Route)
            }, modifier = Modifier.absoluteOffset(x = 70.dp)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
            }
        }
        TextButton(modifier = Modifier
            .clip(RoundedCornerShape(10))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
            .height(56.dp),
            onClick = {
                navController.navigate(Screens.EnterAlwaysTopAppBar.Route)
            }) {
            Text(text = "Enter Always Top App Bar")
            IconButton(onClick = {                 navController.navigate(Screens.EnterAlwaysTopAppBar.Route)
            }, modifier = Modifier.absoluteOffset(x = 50.dp)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
            }
        }
        TextButton(modifier = Modifier
            .clip(RoundedCornerShape(10))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
            .height(56.dp),
            onClick = {
                navController.navigate(Screens.SimpleCenterAlignedTopAppBar.Route)
            }) {
            Text(text = "Simple Center Aligned Top App Bar")
            IconButton(onClick = {                 navController.navigate(Screens.SimpleCenterAlignedTopAppBar.Route)
            }, modifier = Modifier.absoluteOffset(x = 17.dp)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
            }
        }
        TextButton(modifier = Modifier
            .clip(RoundedCornerShape(10))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
            .height(56.dp),
            onClick = {
                navController.navigate(Screens.ExitUntilCollapsedMediumTopAppBar.Route)
            }) {
            Text(text = "Exit Until Collapsed Medium Top Apps Bar")
            IconButton(onClick = {                 navController.navigate(Screens.ExitUntilCollapsedMediumTopAppBar.Route)
            }, modifier = Modifier.absoluteOffset(x = 0.dp)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
            }
        }
    }
}