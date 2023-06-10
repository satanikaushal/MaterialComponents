package com.example.materialcomponents.datePickers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.materialcomponents.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerSample(navController: NavHostController) {
  Column() {
       Row(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primaryContainer).padding(vertical = 10.dp, horizontal = 20.dp),
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
           ClickableText(text = AnnotatedString("Date Pickers List"), onClick = {
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
           ClickableText(text = AnnotatedString("Nor..."), onClick = {
               navController.navigate(Screens.DateRangePickerSample.Route){
                   popUpTo(Screens.DateRangePickerSample.Route){
                       inclusive = true
                   }
               }
           },
               style = TextStyle(
                   fontSize = 20.sp
               ))
       }
       Column(
           modifier = Modifier.fillMaxHeight(0.9f)
           ,verticalArrangement = Arrangement.spacedBy(8.dp)) {
           // Pre-select a date for January 4, 2020
           val datePickerState = rememberDatePickerState()
           DatePicker(state = datePickerState, modifier = Modifier.padding(1.dp))
       }
   }
}
