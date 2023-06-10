package com.example.materialcomponents.sliderList

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
fun SliderList(navController: NavHostController) {
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
        ClickableText(text = AnnotatedString("Slider List"), onClick = {
            navController.navigate(Screens.IndicatorList.Route){
                popUpTo(Screens.IndicatorList.Route){
                    inclusive = true
                }
            }
        },
            style = TextStyle(
                fontSize = 20.sp
            )
        )
    }
    Column(verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()) {
        Text(text = "Sliders", style = TextStyle(
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
                navController.navigate(Screens.StepsSliderSample.Route)
            }) {
            Text(text = "Normal Slider")
            IconButton(onClick = { navController.navigate(Screens.StepsSliderSample.Route) }, modifier = Modifier.absoluteOffset(x = 85.dp)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
            }
        }
        TextButton(modifier = Modifier
            .clip(RoundedCornerShape(10))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
            .height(56.dp),
            onClick = {
                navController.navigate(Screens.RangeSliderSample.Route)
            }) {
            Text(text = "Range Slider")
            IconButton(onClick = { navController.navigate(Screens.RangeSliderSample.Route)}, modifier = Modifier.absoluteOffset(x = 85.dp)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
            }
        }
    }
}