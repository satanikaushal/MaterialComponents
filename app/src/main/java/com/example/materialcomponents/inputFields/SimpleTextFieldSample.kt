package com.example.materialcomponents.inputFields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.materialcomponents.Screens

@Composable
fun SimpleTextFieldSample(navController: NavHostController) {
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
        ClickableText(text = AnnotatedString("Text Field List"), onClick = {
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
        ClickableText(text = AnnotatedString("Text..."), onClick = {
            navController.navigate(Screens.SimpleTextFieldSample.Route){
                popUpTo(Screens.SimpleTextFieldSample.Route){
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
        modifier = Modifier.fillMaxSize().fillMaxHeight(0.95f),
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
            ){
        var text by rememberSaveable { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Label") },
            singleLine = true
        )


        var text1 by rememberSaveable { mutableStateOf("") }
        TextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("Label") },
            leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = "Localized description") },
            trailingIcon = { Icon(Icons.Filled.Info, contentDescription = "Localized description") }
        )
        var text2 by rememberSaveable { mutableStateOf("") }

        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Email") },
            placeholder = { Text("example@gmail.com") }
        )

        var text3 by rememberSaveable { mutableStateOf("") }

        TextField(
            value = text3,
            onValueChange = { text3 = it },
            singleLine = true,
            label = { Text("Label") },
            prefix = { Text("www.") },
            suffix = { Text(".com") },
            placeholder = { Text("google") },
        )


        val errorMessage = "Text input too long"
        var text4 by rememberSaveable { mutableStateOf("") }
        var isError by rememberSaveable { mutableStateOf(false) }
        val charLimit = 10

        fun validate(text: String) {
            isError = text.length > charLimit
        }

        TextField(
            value = text4,
            onValueChange = {
                text4 = it
                validate(text4)
            },
            singleLine = true,
            label = { Text(if (isError) errorMessage else "Username") },
            supportingText = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Limit: ${text4.length}/$charLimit",
                    textAlign = TextAlign.Start,
                )
            },
            isError = isError,
            keyboardActions = KeyboardActions { validate(text4) }
        )


        var text5 by rememberSaveable { mutableStateOf("") }

        TextField(
            value = text5,
            onValueChange = { text5 = it },
            label = { Text("Label") },
            supportingText = {
                Text("Supporting text that is long and perhaps goes onto another line.", modifier = Modifier.fillMaxWidth(0.8f))
            },
        )


        var password by rememberSaveable { mutableStateOf("") }
        var passwordHidden by rememberSaveable { mutableStateOf(true) }
        TextField(
            value = password,
            onValueChange = { password = it },
            singleLine = true,
            label = { Text("Enter password") },
            visualTransformation =
            if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordHidden = !passwordHidden }) {
                    val visibilityIcon =
                        if (passwordHidden) Icons.Filled.Refresh else Icons.Filled.Refresh
                    // Please provide localized description for accessibility services
                    val description = if (passwordHidden) "Show password" else "Hide password"
                    Icon(imageVector = visibilityIcon, contentDescription = description)
                }
            }
        )

    }
}