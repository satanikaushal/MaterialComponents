package com.example.materialcomponents.datePickers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.materialcomponents.Screens
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRangePickerSample(navController: NavHostController) {
    // Decoupled snackbar host state from scaffold state for demo purposes.
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()
    SnackbarHost(hostState = snackState, Modifier.zIndex(1f))

    val state = rememberDateRangePickerState()

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
            ClickableText(text = AnnotatedString("Ran.."), onClick = {
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
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
                // Add a row with "Save" and dismiss actions.
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { /* dismiss the UI */ }) {
                        Icon(Icons.Filled.Close, contentDescription = "Localized description")
                    }
                    TextButton(
                        onClick = {
                            snackScope.launch {
                                snackState.showSnackbar(
                                    "Saved range (timestamps): " +
                                            "${state.selectedStartDateMillis!!..state.selectedEndDateMillis!!}"
                                )
                            }
                        },
                        enabled = state.selectedEndDateMillis != null
                    ) {
                        Text(text = "Save")
                    }
                }

                DateRangePicker(state = state, modifier = Modifier.weight(1f))
            }
        }
    }
}
